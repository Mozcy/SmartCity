package com.example.smartcity

import android.app.AlertDialog
import android.content.SharedPreferences
import android.view.View
import com.bumptech.glide.Glide
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityGuideBinding
import com.example.smartcity.databinding.DialogIpSetBinding
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.hide
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnPageChangeListener

class GuideActivity : BaseActivity<ActivityGuideBinding>() {
    private val ipRegex =
        """(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])"""
    private val portRegex =
        """([0-9]|[1-9]\d{1,3}|[1-5]\d{4}|6[0-4]\d{3}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])"""
    private val images =
        listOf(R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3, R.mipmap.guide4, R.mipmap.guide5)
    lateinit var sp: SharedPreferences
    lateinit var spe: SharedPreferences.Editor

    override fun initView() {
        sp = getSharedPreferences("DATA", MODE_PRIVATE)
        spe = getSharedPreferences("DATA", MODE_PRIVATE).edit()
        if (sp.getBoolean("flag", false)) {
            start<MainActivity> { }
            finish()
        }
    }

    override fun initData() {
        bind.banner.apply {
            indicator = CircleIndicator(c)
            setAdapter(object : BannerImageAdapter<Int>(images) {
                override fun onBindView(p0: BannerImageHolder?, p1: Int?, p2: Int, p3: Int) {
                    Glide.with(c).load(p1).into(p0!!.imageView)
                }
            }, false)
            isAutoLoop(false)
        }
    }

    override fun onClick() {
        bind.banner.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

            override fun onPageSelected(p0: Int) {
                if (p0 == images.size - 1) {
                    bind.btn0.visibility = View.VISIBLE;
                    bind.btn1.visibility = View.VISIBLE;
                } else {
                    bind.btn0.visibility = View.GONE;
                    bind.btn1.visibility = View.GONE;
                }
            }

            override fun onPageScrollStateChanged(p0: Int) {}
        })
        bind.btn0.setOnClickListener {
            val inflate = DialogIpSetBinding.inflate(layoutInflater)
            val dialog = AlertDialog.Builder(c)
                .setView(inflate.root)
                .show()
            var ip = sp.getString("IP", "")!!
            var port = sp.getString("PORT", "")!!
            inflate.et0.setText(ip)
            inflate.et1.setText(port)
            inflate.tvBtn.apply {
                text = if (ip.isNullOrEmpty()) "保存" else "修改"
                setOnClickListener {
                    inflate.et0.hide(c)
                    ip = inflate.et0.text.toString()
                    port = inflate.et1.text.toString()
                    if (ip.isNullOrEmpty() || port.isNullOrEmpty()) {
                        toast("IP地址和端口地址不能为空! ")
                    } else if (!Regex(ipRegex).matches(ip)) {
                        toast("IP格式错误请检查")
                    } else if (!Regex(portRegex).matches(port)) {
                        toast("端口格式错误请检查")
                    } else {
                        dialog.dismiss()
                        toast("${inflate.tvBtn.text}成功")
                        baseURL = "http://${ip}:${port}"
                        spe.putString("IP", ip).putString("PORT", port).apply()
                    }
                }
            }
            inflate.cancel.setOnClickListener { dialog.dismiss() }
        }
        bind.btn1.setOnClickListener {
            if (sp.getString("IP", "")!!.isEmpty()) {
                toast("请设置IP地址和端口")
            } else {
                spe.putBoolean("flag", true).apply()
                start<MainActivity> { }
                finish()
            }
        }
    }
}