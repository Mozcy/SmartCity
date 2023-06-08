package com.example.smartcity.activity.housekeeping

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityHouseKeepingListBinding
import com.example.smartcity.databinding.ItemHouseKeepingRv1Binding
import com.example.smartcity.pojo.housekeeping.HPListData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.show

class HouseKeepingListActivity : BaseActivity<ActivityHouseKeepingListBinding>() {
    override fun initView() {
        setTitle("服务列表")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        val data = intent.getStringExtra("data").let { it ?: "" }
        get<HPListData>("/takeout/server/list${data}") {
            bind.no.tvNo.show(it.rows.isEmpty()).text = "暂无搜索数据"
            bind.rv.adapter = object :
                CommonAdapter<ItemHouseKeepingRv1Binding, HPListData.RowsBean>(it.rows) {
                override fun bind(
                    holder: ItemHouseKeepingRv1Binding, data: HPListData.RowsBean
                ) {
                    val flag = it.rows.indexOf(data) % 2 == 0
                    setImage(if (flag) holder.iv0 else holder.iv1, data?.picUrl)
                        .setText(holder.tv0, data.serverName)
                        .setText(holder.tv1, data.serverTitle)
                        .setText(holder.tv2, "所属 ${data.companyName} 公司")
                        .setText(holder.tv3, "${data.serverMoneyNew}")
                        .setClick(holder.cv) {
                            start<HouseKeepingInfoActivity> { it.putExtra("data", data.id) }
                        }
                    holder.iv0.visibility = if (flag) View.VISIBLE else View.GONE
                    holder.iv1.visibility = if (!flag) View.VISIBLE else View.GONE
                }
            }
        }
    }

    override fun onClick() {
    }
}