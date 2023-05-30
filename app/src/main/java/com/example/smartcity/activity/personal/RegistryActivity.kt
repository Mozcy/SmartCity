package com.example.smartcity.activity.personal

import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityRegistryBinding
import com.example.smartcity.pojo.personal.PersonalTokenData
import com.example.smartcity.utils.post

class RegistryActivity : BaseActivity<ActivityRegistryBinding>() {
    override fun initView() {
        setTitle("注册")
    }

    override fun initData() {
    }

    override fun onClick() {
        bind.btn.setOnClickListener {
            val et0 = bind.et0.text.toString()
            val et1 = bind.et1.text.toString()
            val et2 = bind.et1.text.toString()
            val map = mapOf(
                "email" to "${et0}@qq.com",
                "idCard" to "500000000000000000",
                "nickName" to et0,
                "password" to et1,
                "phonenumber" to et2.let { if (it.length < 11) "1851243${(1000..9999).random()}" else it },
                "sex" to "0",
                "userName" to et0
            )
            loadingMsg("注册中...")
            post<PersonalTokenData>("/api/register", map) {
                dismiss()
                if (it.code == 200) {
                    toast("注册成功")
                    finish()
                } else {
                    toast(it?.msg)
                }
            }
        }
    }
}
