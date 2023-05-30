package com.example.smartcity.activity.personal

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalOrderListBinding
import com.example.smartcity.databinding.ItemMainNav5OrderBinding
import com.example.smartcity.pojo.personal.PersonalOrderData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.show
import com.google.android.material.tabs.TabLayout

class PersonalOderListActivity : BaseActivity<ActivityPersonalOrderListBinding>() {
    override fun initView() {
        setTitle("我的订单")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        get<PersonalOrderData>("/api/allorder/list") {
            val label = it.rows.map { it.orderStatus }.toSet()
            bind.tab.visibility = if (label.isNotEmpty()) View.VISIBLE else View.GONE
            bind.no.tvNo.show(it.rows.isEmpty()).text = "Error: Admin 用户才有订单数据"
            bind.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val temp = it.rows.filter { it.orderStatus == tab!!.text }
                    bind.no.tvNo.show(temp.isEmpty()).text = "暂无 \"${tab?.text}\" 数据"
                    bind.rv.adapter = object :
                        CommonAdapter<ItemMainNav5OrderBinding, PersonalOrderData.RowsBean>(temp) {
                        override fun bind(
                            holder: ItemMainNav5OrderBinding, data: PersonalOrderData.RowsBean
                        ) {
                            val temp = data.orderNo
                            var date =
                                "${temp.substring(0..3)}-${temp.substring(4..5)}-${temp.substring(6..7)}"
                            val d = "$date ${temp.substring(8..9)}:${temp.substring(10..11)}"
                            setText(holder.tv0, "订单编号:${data.orderNo}")
                                .setText(holder.tv1, data.orderTypeName)
                                .setText(holder.tv2, "订单创建时间: $d")
                                .setClick(holder.cv) {
                                    start<PersonalOderInfoActivity> { it.putExtra("data", data) }
                                }
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
            label.forEach { bind.tab.addTab(bind.tab.newTab().setText(it)) }
        }
    }

    override fun onClick() {
    }
}