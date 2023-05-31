package com.example.smartcity.fragment

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartcity.R
import com.example.smartcity.activity.home.NullActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseFragment
import com.example.smartcity.databinding.FragmentMainNav2Binding
import com.example.smartcity.databinding.ItemMainNav1Rv0Binding
import com.example.smartcity.databinding.ItemMainNav2DialogBinding
import com.example.smartcity.databinding.ItemMainNav2Rv0Binding
import com.example.smartcity.pojo.home.ServiceListData
import com.example.smartcity.utils.*

class MainFragmentNav2 : BaseFragment<FragmentMainNav2Binding>() {
    override fun initView() {
        setTitle("全部服务", false)
        bind.rv0.layoutManager = LinearLayoutManager(c)
        bind.rv1.layoutManager = GridLayoutManager(c, 3)
    }

    override fun initData() {
        get<ServiceListData>("/api/service/list") {
            it.rows.apply { sortWith(Comparator { o1, o2 -> o2.sort - o1.sort }) }
            val label = it.rows.map { it.serviceType ?: "其他服务" }.toSet().toList()
            bind.rv0.adapter = object : CommonAdapter<ItemMainNav2Rv0Binding, String>(label) {
                var current = label[0]
                override fun bind(holder: ItemMainNav2Rv0Binding, data: String) {
                    holder.tv.setTextColor(if (current == data) Color.BLUE else Color.BLACK)
                    holder.tv.setBackgroundColor(if (current == data) c.getColor(R.color.background) else Color.WHITE)
                    setText(holder.tv, data)
                        .setClick(holder.tv) {
                            if (current != data) {
                                current = data
                                notifyDataSetChanged()
                                refreshRv1(it.rows.filter { it.serviceType ?: "其他服务" == data })
                            }
                        }
                }
            }
            refreshRv1(it.rows.filter { it.serviceType ?: "其他服务" == label[0] })
        }
    }

    private fun refreshRv1(list: List<ServiceListData.RowsBean>, rv: RecyclerView = bind.rv1) {
        rv.adapter = object :
            CommonAdapter<ItemMainNav1Rv0Binding, ServiceListData.RowsBean>(list) {
            override fun bind(
                holder: ItemMainNav1Rv0Binding, data: ServiceListData.RowsBean
            ) {
                setImage(holder.iv, data.imgUrl ?: R.mipmap.icon_more)
                    .setText(holder.tv, data.serviceName)
                    .setClick(holder.ll) {
                        val clazz = entry[data.serviceName]
                        val intent = Intent(c, clazz ?: NullActivity::class.java)
                            .putExtra("data", data.serviceName)
                        startActivity(intent)
                    }
            }
        }
    }

    override fun onClick() {
        bind.btn.setOnClickListener {
            loadingMsg("搜索中...")
            val data = bind.etSearch.text
            bind.etSearch.hide(c).text = null
            get<ServiceListData>("/api/service/list?serviceName=${data}") {
                dismiss()
                val bind = ItemMainNav2DialogBinding.inflate(layoutInflater)
                bind.no.tvNo.show(it.total == 0).text = "暂无 \"$data\" 相关结果"
                refreshRv1(it.rows, bind.rv.apply { layoutManager = GridLayoutManager(c, 3) })
                val dialog = AlertDialog.Builder(c)
                    .setView(bind.root)
                    .setCancelable(true)
                    .create()
                dialog.show()
                bind.iv.setOnClickListener { dialog.dismiss() }
            }
        }
    }
}