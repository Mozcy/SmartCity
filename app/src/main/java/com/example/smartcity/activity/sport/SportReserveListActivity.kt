package com.example.smartcity.activity.sport

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivitySportReserveListBinding
import com.example.smartcity.databinding.ItemSportReserveListBinding
import com.example.smartcity.pojo.sport.SportReserveData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.show

class SportReserveListActivity : BaseActivity<ActivitySportReserveListBinding>() {
    private var sportVenueId = 10
    override fun initView() {
        setTitle("预约历史")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        sportVenueId = intent.getIntExtra("data", 10)
        get<SportReserveData>("/sport/make/list?sportVenueId=${sportVenueId}") {
            it.rows.apply { removeIf { it.type == 2 }; sortByDescending { it.id } }
            bind.no.tvNo.show(it.rows.isEmpty()).text = "暂无预约历史记录"
            bind.rv.adapter = object :
                CommonAdapter<ItemSportReserveListBinding, SportReserveData.RowsBean>(it.rows) {
                override fun bind(
                    holder: ItemSportReserveListBinding, data: SportReserveData.RowsBean
                ) {
                    setText(holder.tv0, "姓名: ${data.name}")
                        .setText(holder.tv1, "预约电话: ${data.phone}")
                        .setText(holder.tv2, "预约时间段: ${data.makeTime}")
                        .setText(holder.tv3, "今日时间: ${data.todayTime}")
                }
            }
        }
    }

    override fun onClick() {
    }
}