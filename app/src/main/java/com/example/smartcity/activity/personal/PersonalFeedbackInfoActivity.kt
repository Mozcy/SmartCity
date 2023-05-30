package com.example.smartcity.activity.personal

import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalFeedbackInfoBinding
import com.example.smartcity.pojo.personal.PersonalFeedbackData
import com.example.smartcity.utils.userBean

class PersonalFeedbackInfoActivity : BaseActivity<ActivityPersonalFeedbackInfoBinding>() {
    override fun initView() {
        setTitle("反馈详情")
    }

    override fun initData() {
        val data = intent.getSerializableExtra("data") as PersonalFeedbackData.RowsBean
        bind.tv0.text = data.title ?: "无标题"
        bind.tv1.text = "反馈人: ${userBean?.nickName}"
        bind.tv2.text = data.content
    }

    override fun onClick() {

    }
}
