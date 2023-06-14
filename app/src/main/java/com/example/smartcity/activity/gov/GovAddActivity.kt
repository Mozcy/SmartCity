package com.example.smartcity.activity.gov

import android.content.Intent
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityGovAddBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.pojo.gov.GovLabelData
import com.example.smartcity.pojo.personal.PersonalFileData
import com.example.smartcity.utils.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class GovAddActivity : BaseActivity<ActivityGovAddBinding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null) {
                val uri = it!!.data!!.data
                val c = contentResolver.query(uri!!, arrayOf("_data"), null, null, null)
                c!!.moveToFirst()
                val index = c.getColumnIndex("_data")
                val path = c.getString(index)
                c.close()
                Glide.with(this).load(BitmapFactory.decodeFile(path)).apply(AppConfig.circle)
                    .into(bind.iv)
                val body = MultipartBody.Builder()
                    .addFormDataPart(
                        "file", "1.png", File(path).asRequestBody("image/*".toMediaType())
                    ).build()
                post<PersonalFileData>("/common/upload", body) {
                    fileName = "/prod-api" + it.fileName
                }
            }
        }

    private var id = 0
    private var fileName = ""
    override fun initView() {
        setTitle("新建诉求")
        id = intent.getIntExtra("id", 0)
    }

    override fun initData() {
        val flag = intent.getBooleanExtra("data", false)
        if (flag) {
            get<GovLabelData>("/api/gov-service-hotline/appeal-category/list") {
                bind.sp.adapter = object : ArrayAdapter<String>(
                    c,
                    android.R.layout.simple_list_item_1,
                    it.rows.map { it.name }) {}
                bind.sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, temp: Long
                    ) {
                        id = it.rows[position].id
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            }
        }
    }

    override fun onClick() {
        bind.iv.setOnClickListener {
            if (c.permission()) {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                launcher.launch(intent)
            }
        }
        bind.btn.setOnClickListener {
            bind.et0.hide(c)
            val map = mapOf(
                "appealCategoryId" to id,
                "content" to bind.et3.text.toString(),
                "imgUrl" to fileName,
                "title" to bind.et0.text.toString(),
                "undertaker" to bind.et1.text.toString(),
                "userId" to userBean?.userId
            )
            if (map["title"].toString().isEmpty() || map["content"].toString()
                    .isEmpty() || map["undertaker"].toString().isEmpty()
            ) {
                toast("请输入内容信息")
            } else {
                loadingMsg("发布中...")
                post<MsgData>("/api/gov-service-hotline/appeal", map) {
                    if (it.code == 200) {
                        toast("发布成功")
                        bind.et0.text = null
                        bind.et1.text = null
                        bind.et2.text = null
                        bind.et3.text = null
                        Glide.with(c).load(R.drawable.ic_baseline_add_circle_48).into(bind.iv)
                        setResult(RESULT_OK)
                    }
                    dismiss()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 2) {
            if (c.permission()) {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                launcher.launch(intent)
            }
        }
    }
}

