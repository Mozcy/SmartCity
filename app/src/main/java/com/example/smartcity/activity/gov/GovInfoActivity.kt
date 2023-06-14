package com.example.smartcity.activity.gov

import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityGovInfoBinding
import com.example.smartcity.pojo.gov.GovInfoData
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.get

class GovInfoActivity : BaseActivity<ActivityGovInfoBinding>() {
    override fun initView() {
        setTitle("诉求详情")
    }

    override fun initData() {
        val id = intent.getIntExtra("data", 10)
        get<GovInfoData>("/api/gov-service-hotline/appeal/${id}") {
            Glide.with(c).load(baseURL + it.data?.imgUrl).error(R.mipmap.no_image).into(bind.iv)
            bind.tv0.text = it.data.title
            bind.tv1.text = "${if (it.data.state == "0") "未处理" else "已处理"}"
            bind.tv2.text = it.data.content
            bind.tv3.text = "承办单位: ${it.data.undertaker}"
            bind.tv4.text = "发布时间: ${it.data.createTime}"
            bind.tv5.text =
                if (it.data.detailResult == null || it.data.detailResult.isEmpty()) "无" else it.data.detailResult

        }
    }

    override fun onClick() {
    }
}