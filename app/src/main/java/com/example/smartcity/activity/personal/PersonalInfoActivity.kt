package com.example.smartcity.activity.personal

import android.content.Intent
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalInfoBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.pojo.personal.PersonalFileData
import com.example.smartcity.pojo.personal.PersonalUserData
import com.example.smartcity.utils.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class PersonalInfoActivity : BaseActivity<ActivityPersonalInfoBinding>() {
    private var fileName = ""
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null) {
                val uri = it?.data?.data
                var query = contentResolver.query(uri!!, arrayOf("_data"), null, null, null)
                query!!.moveToFirst()
                val index = query.getColumnIndex("_data")
                val path = query.getString(index)
                Glide.with(c).load(BitmapFactory.decodeFile(path)).apply(AppConfig.circle)
                    .into(bind.iv)
                val body = MultipartBody.Builder()
                    .addFormDataPart(
                        "file", "1.png", File(path).asRequestBody("image/*".toMediaType())
                    ).build()
                post<PersonalFileData>("/common/upload", body) {
                    fileName = it.fileName
                }
            }
        }

    override fun initView() {
        setTitle("个人信息")
    }

    override fun initData() {
        get<PersonalUserData>("/api/common/user/getInfo") {
            fileName = it.user.avatar
            Glide.with(c).load(baseURL + "/prod-api${fileName}").apply(AppConfig.circle)
                .error(R.mipmap.icon_avatar).into(bind.iv)
            bind.et0.setText(it.user?.nickName)
            bind.rb0.isChecked = it.user.sex == "0"
            bind.rb1.isChecked = it.user.sex == "1"
            bind.et1.setText(it.user.phonenumber
                .let { if (it.length < 11) "1888888****" else it.substring(0..6) + "****" })
        }
    }

    private fun getImage() {
        if (permission()) {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            launcher.launch(intent)
        }
    }

    override fun onClick() {
        bind.iv.setOnClickListener { getImage() }
        bind.btn.setOnClickListener {
            val et0 = bind.et0.text.toString()
            val et1 = bind.et1.text.toString()
            if (et0.isEmpty() || et1.isEmpty()) {
                toast("请输入昵称和联系电话")
            } else {
                val map = mapOf(
                    "avatar" to fileName,
                    "nickName" to et0,
                    "phonenumber" to et1,
                    "sex" to if (bind.rb0.isChecked) "0" else "1",
                    "userId" to userBean?.userId
                )
                Log.e(TAG, "onClick: ${userBean?.userId}")
                loadingMsg("修改中...")
                put<MsgData>("/api/common/user", map) {
                    dismiss()
                    if (it.code == 200) {
                        toast("修改成功")
                        setResult(RESULT_OK)
                        finish()
                    } else {
                        toast(it?.msg)
                    }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 2) getImage()
    }
}