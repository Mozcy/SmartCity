package com.example.smartcity.activity.sport

import com.bumptech.glide.Glide
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivitySportInfoBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.pojo.sport.SportBannerData
import com.example.smartcity.pojo.sport.SportInfoData
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.get
import com.example.smartcity.utils.put

class SportInfoActivity : BaseActivity<ActivitySportInfoBinding>() {
    override fun initView() {
    }

    override fun initData() {
        val id = intent.getIntExtra("data", 10)
        get<SportInfoData>("/sport/venue/${id}") {
            get<SportBannerData>("/sport/carousel/list") {
                val img = it.rows.find { it.sportVenurId.toInt() == id }?.imgUrl
                Glide.with(c).load(baseURL + img).into(bind.iv)
            }
            setTitle(it.data.sportVenueName)
            bind.wv.loadDataWithBaseURL(baseURL, it.data.sportContent, "text/html", "utf-8", null)
            bind.cb.text = "${it.data.likeNum} 赞"
            bind.cb.setOnCheckedChangeListener { _, isChecked ->
                val like = if (isChecked) ++it.data.likeNum else --it.data.likeNum
                bind.cb.text = "$like 赞"
                val map = mapOf("id" to id, "likeNum" to like)
                put<MsgData>("/sport/venue", map) {
                    toast(if (isChecked) "点赞成功" else "取消点赞")
                    setResult(RESULT_OK)
                }
            }
        }
        bind.btn.setOnClickListener { start<SportReserveActivity> { it.putExtra("data", id) } }
    }

    override fun onClick() {

    }
}