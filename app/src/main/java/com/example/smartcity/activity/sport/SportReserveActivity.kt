package com.example.smartcity.activity.sport

import android.graphics.Color
import android.widget.RadioButton
import androidx.recyclerview.widget.GridLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivitySportReserveBinding
import com.example.smartcity.databinding.ItemSportReserveBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.pojo.sport.SportInfoData
import com.example.smartcity.pojo.sport.SportReserveData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.post
import com.example.smartcity.utils.put
import com.example.smartcity.utils.userBean
import java.text.SimpleDateFormat

class SportReserveActivity : BaseActivity<ActivitySportReserveBinding>() {
    private val format = SimpleDateFormat("yyyy-MM-dd")
    private var sportVenueId = 10
    private var reserveId = -1
    private val dates = listOf(
        "9:00-11:00", "11:30-13:00", "14:00-15:00", "16:30-17:30", "18:00-19:00", "20:30-21:30"
    )
    private var selectTime = ""
    override fun initView() {
        setTitle("场馆预约")
        bind.rv.layoutManager = GridLayoutManager(c, 2)
    }

    override fun initData() {
        sportVenueId = intent.getIntExtra("data", 10)
        get<SportInfoData>("/sport/venue/${sportVenueId}") {
            bind.tv0.text = it.data.sportVenueName
            bind.tv1.text = "${it.data?.openTime?.split("-")?.get(0)}"
            bind.tv2.text = "${it.data?.openTime?.split("-")?.get(1)}"
            bind.tv3.text = "${it.data.likeNum} 赞"
            bind.tv4.text = "${it.data.money}"
        }
        bind.et0.setText(userBean?.nickName)
        bind.et1.setText(userBean?.phonenumber)
        loadSelectRv()
    }

    //加载选择预约时间列表
    private fun loadSelectRv() {
        get<SportReserveData>("/sport/make/list?sportVenueId=${sportVenueId}") {
            bind.tvCount.text = "预约总数 (${it.total})"
            it.rows.apply { removeIf { it.type == 2 } }
            bind.rv.adapter = object : CommonAdapter<ItemSportReserveBinding, String>(dates) {
                val rbs = mutableListOf<RadioButton>()
                override fun bind(holder: ItemSportReserveBinding, data: String) {
                    rbs.add(holder.rb)
                    setText(holder.rb, data)
                    reserveId = it.rows.find { it.makeTime == data }?.id ?: -1
                    holder.rb.setTextColor(if (reserveId != -1) Color.BLUE else Color.BLACK)
                    holder.rb.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            reserveId = it.rows.find { it.makeTime == data }?.id ?: -1
                            rbs.forEach { if (holder.rb != it) it.isChecked = false }
                            selectTime = data
                            bind.btn1.text = if (reserveId != -1) "取消预约" else "立即预约"
                        }
                    }
                }
            }
        }
    }

    override fun onClick() {
        bind.btn0.setOnClickListener { toast("今日时间: ${format.format(System.currentTimeMillis())}") }
        bind.btn2.setOnClickListener {
            start<SportReserveListActivity> { it.putExtra("data", sportVenueId) }
        }
        bind.btn1.setOnClickListener {
            val et0 = bind.et0.text.toString()
            val et1 = bind.et1.text.toString()
            if (et0.isEmpty() || et1.isEmpty() || selectTime.isEmpty()) {
                toast("请输入姓名 和 电话 和 选择预约时间")
            } else {
                val map = mapOf(
                    "sportVenueId" to sportVenueId,
                    "name" to et0,
                    "phone" to et1,
                    "makeTime" to selectTime,
                    "id" to reserveId,
                    "type" to if (reserveId == -1) 1 else 2,
                    "todayTime" to format.format(System.currentTimeMillis()),
                    "userId" to userBean?.userId
                )

                if (reserveId != -1) {
                    put<MsgData>("/sport/make", map) {
                        toast("取消预约成功")
                        bind.btn1.text = "立即预约"
                        reserveId = -1
                        selectTime = ""
                        loadSelectRv()
                    }
                } else {
                    post<MsgData>("/sport/make", map) {
                        if (it.code == 200) {
                            toast("预约成功")
                            selectTime = ""
                            loadSelectRv()
                        } else {
                            toast("预约失败")
                        }
                    }
                }
            }
        }
    }
}