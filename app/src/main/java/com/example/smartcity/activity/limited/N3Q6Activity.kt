package com.example.smartcity.activity.limited

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.CheckBox
import android.widget.CompoundButton
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q6Binding
import com.example.smartcity.pojo.Data
import com.example.smartcity.utils.hide
import com.example.smartcity.utils.permission

class N3Q6Activity : BaseActivity<ActivityN3Q6Binding>() {
    private var type = "先进事迹"
    private var bitmap: Bitmap? = null
    private val cbs = arrayOfNulls<CheckBox>(6)
    override fun initView() {
        setTitle("随手拍")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        cbs[2] = bind.cb2
        cbs[3] = bind.cb3
        cbs[4] = bind.cb4
        cbs[1] = bind.cb1
        cbs[5] = bind.cb5
        cbs[0] = bind.cb0
    }

    override fun initData() {
        if (Data.q6.isEmpty()) {
            Data.Comment(
                bitmap,
                Data.f.format(System.currentTimeMillis()),
                "【奋斗百年路 启航新征程】全力建设区域性国际铁路枢纽",
                "新中国成立后，在党的领导下，1958年，国家投资兴建的准轨贵昆、成昆铁路相继开工，不断推动西南铁路建设大步向前。"
            )
        }
    }

    override fun onClick() {
        for (i in cbs.indices) {
            val cb = cbs[i]!!
            cb.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
                if (isChecked) {
                    type = cb.text.toString()
                    for (box in cbs) {
                        if (cb !== box) {
                            box!!.isChecked = false
                        }
                    }
                }
            }
        }
        bind.btn0.setOnClickListener {
            val s2: String = bind.et0.text.toString()
            if (s2.isEmpty()) {
                toast("请输入完整的信息")
                return@setOnClickListener
            }
            Data.Comment(bitmap, Data.f.format(System.currentTimeMillis()), type, s2)
            toast("提交成功")
            bind.et0.hide(c)
            start<N3Q6InfoActivity> { }
        }
        bind.btn1.setOnClickListener { start<N3Q6InfoActivity> { } }
        bind.iv0.setOnClickListener {
          if(permission()){
              val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
              startActivityForResult(intent, 6)
          }else{
              toast("请同意拍照权限")
          }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 6 && data != null) {
            bitmap = data.extras!!["data"] as Bitmap?
            Glide.with(c).load(bitmap).into(bind.iv)
        }
    }
}