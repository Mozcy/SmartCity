package com.example.smartcity.activity.personal

import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityLoginBinding
import com.example.smartcity.pojo.personal.PersonalTokenData
import com.example.smartcity.pojo.personal.PersonalUserData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.post
import com.example.smartcity.utils.token
import com.example.smartcity.utils.userBean

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun initView() {
        setTitle("登陆")
    }

    override fun initData() {
    }

    override fun onClick() {
        bind.tvRegistry.setOnClickListener { start<RegistryActivity> { } }
        bind.btn.setOnClickListener {
            val et0 = bind.et0.text.toString()
            val et1 = bind.et1.text.toString()
            val map = mapOf("username" to et0, "password" to et1)
            loadingMsg("登陆中...")
            post<PersonalTokenData>("/api/login", map) {
                dismiss()
                if (it.code == 200) {
                    token = it.token
                    get<PersonalUserData>("/api/common/user/getInfo") {
                        userBean = it?.user
                        setResult(RESULT_OK)
                        toast("登陆成功")
                        finish()
                    }
                } else {
                    toast(it?.msg)
                }
            }
        }
    }
}
