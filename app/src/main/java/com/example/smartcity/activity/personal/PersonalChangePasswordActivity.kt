package com.example.smartcity.activity.personal

import android.app.Activity
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalChangePasswordBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.utils.put
import com.example.smartcity.utils.token

class PersonalChangePasswordActivity : BaseActivity<ActivityPersonalChangePasswordBinding>() {
    override fun initView() {
        setTitle("修改密码")
    }

    override fun initData() {
    }

    override fun onClick() {
        bind.btn.setOnClickListener {
            val et0 = bind.et0.text.toString()
            val et1 = bind.et1.text.toString()
            if (et1.isEmpty()) {
                toast("新密码不能为空")
            } else {
                val map = mapOf("oldPassword" to et0, "newPassword" to et1)
                loadingMsg("修改中...")
                put<MsgData>("/api/common/user/resetPwd", map) {
                    dismiss()
                    if (it.code == 200) {
                        toast("修改成功, 请重新登录!")
                        token = ""
                        setResult(Activity.RESULT_OK)
                        finish()
                    } else {
                        toast(it?.msg)
                    }
                }
            }
        }
    }
}
