package com.example.smartcity.activity.home

import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityNullBinding

class NullActivity : BaseActivity<ActivityNullBinding>() {
    override fun initView() {
        val data = intent.getStringExtra("data").toString()
        setTitle(data)
        bind.tv.text = data
    }

    override fun initData() {
    }

    override fun onClick() {
    }
}