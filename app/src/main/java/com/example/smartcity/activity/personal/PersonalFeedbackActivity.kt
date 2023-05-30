package com.example.smartcity.activity.personal

import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalFeedbackBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.utils.hide
import com.example.smartcity.utils.post
import com.example.smartcity.utils.userBean

class PersonalFeedbackActivity : BaseActivity<ActivityPersonalFeedbackBinding>() {
    override fun initView() {
        setTitle("意见反馈")
    }

    override fun initData() {
    }

    override fun onClick() {
        bind.btn0.setOnClickListener { start<PersonalFeedbackListActivity> { } }
        bind.btn1.setOnClickListener {
            val et0 = bind.et0.text.toString()
            val et1 = bind.et1.text.toString()
            if (et0.isEmpty() || et1.isEmpty()) {
                toast("请输入反馈标题和内容")
            } else {
                val map = mapOf(
                    "content" to et1,
                    "title" to et0,
                    "userId" to userBean?.userId
                )
                loadingMsg("反馈中...")
                post<MsgData>("/api/common/feedback", map) {
                    dismiss()
                    if (it.code == 200) {
                        bind.et0.hide(c).text = null
                        bind.et1.hide(c).text = null
                        toast("提交反馈成功")
                    } else {
                        toast(it?.msg)
                    }
                }
            }
        }
    }
}
