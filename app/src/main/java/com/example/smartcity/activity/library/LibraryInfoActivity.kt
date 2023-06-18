package com.example.smartcity.activity.library

import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityLibraryInfoBinding
import com.example.smartcity.pojo.library.LibraryInfoData
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.get

class LibraryInfoActivity : BaseActivity<ActivityLibraryInfoBinding>() {

    override fun initView() {
        setTitle("图书馆详情")

    }

    override fun initData() {
        val id = intent.getIntExtra("data", 10)
        get<LibraryInfoData>("/api/digital-library/library/${id}") {
            Glide.with(c).load(baseURL + it.data?.mapUrl).error(R.mipmap.no_image).into(bind.iv)
            bind.tv0.text = it.data.name
            bind.tv1.text = "${if (it.data.businessState == "1") "营业中" else "未营业"}"
            bind.tv2.text = "营业时间: ${it.data.businessHours}"
            bind.tv3.text = "地址: ${it.data.address}"
            bind.tv4.text = "简介:\r\t\t ${it.data.description}"
        }
        bind.btn.setOnClickListener { start<LibraryCommentActivity> { it.putExtra("data", id) } }
    }

    override fun onClick() {

    }
}