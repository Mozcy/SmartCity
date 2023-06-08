package com.example.smartcity.activity.housekeeping

import android.content.Intent
import android.net.Uri
import android.text.Html
import com.bumptech.glide.Glide
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityHouseKeepingLnfoBinding
import com.example.smartcity.pojo.housekeeping.HPCompanyData
import com.example.smartcity.pojo.housekeeping.HPInfoData
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.get


class HouseKeepingInfoActivity : BaseActivity<ActivityHouseKeepingLnfoBinding>() {
    override fun initView() {
        setTitle("服务详情")
    }

    override fun initData() {
        val data = intent.getIntExtra("data", 5)
        get<HPInfoData>("/takeout/server/${data}") {
            Glide.with(c).load(baseURL + it.data.picUrl).into(bind.iv)
            bind.tv0.text = it.data.serverName
            bind.tv1.text = it.data.serverTitle
            bind.tv2.text = "${it.data.serverMoneyOld}"
            bind.tv3.text = "${it.data.serverMoneyNew}"
            bind.tv4.text = "${it.data.consultNum} 人咨询"
            bind.tv5.text = "${Html.fromHtml(it.data.serverComtent, 1)}"
            bind.tv6.text = "公司名称: ${it.data.companyName}"
            get<HPCompanyData>("/takeout/company/${it.data.companyId}") {
                bind.tv7.text = "联系电话: ${it.data.phone}"
                bind.btn.setOnClickListener { _ ->
                    try {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${it.data.phone}")
                        startActivity(intent)
                    } catch (e: Exception) {
                        toast("该模拟器不支持拨打电话")
                    }
                }
            }
        }
    }

    override fun onClick() {
    }
}