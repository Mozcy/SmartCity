package com.example.smartcity.fragment;

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.activity.personal.*
import com.example.smartcity.base.BaseFragment
import com.example.smartcity.databinding.FragmentMainNav5Binding
import com.example.smartcity.pojo.personal.PersonalUserData
import com.example.smartcity.utils.*

class MainFragmentNav5 : BaseFragment<FragmentMainNav5Binding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) initData()
        }

    override fun onHiddenChanged(hidden: Boolean) {
        if (!hidden) initData()
    }

    override fun initView() {
        setTitle("个人中心", false)
    }

    override fun initData() {
        get<PersonalUserData>("/api/common/user/getInfo") {
            userBean = it.user
            Glide.with(c).load(baseURL + "/prod-api${it.user?.avatar}").apply(AppConfig.circle)
                .error(R.mipmap.icon_avatar).into(bind.iv)
            bind.tvName.text = it.user?.nickName ?: "未登录"
            bind.btn.text = if (it.user == null) "登陆" else "退出"
        }
    }

    private fun jump(clazz: Class<*>) {
        if (c.isLogin { launcher.launch(Intent(c, LoginActivity::class.java)) }) {
            launcher.launch(Intent(c, clazz))
        }
    }

    override fun onClick() {
        bind.tv0.setOnClickListener { jump(PersonalInfoActivity::class.java) }
        bind.tv1.setOnClickListener { jump(PersonalOderListActivity::class.java) }
        bind.tv2.setOnClickListener { jump(PersonalChangePasswordActivity::class.java) }
        bind.tv3.setOnClickListener { jump(PersonalFeedbackActivity::class.java) }
        bind.btn.setOnClickListener {
            if (token.isNotEmpty()) {
                token = ""
                initData()
                toast("退出成功")
            }
            launcher.launch(Intent(c, LoginActivity::class.java))
        }
    }
}