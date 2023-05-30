package com.example.smartcity.activity.personal

import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalOrderInfoBinding
import com.example.smartcity.pojo.personal.PersonalOrderData

class PersonalOderInfoActivity : BaseActivity<ActivityPersonalOrderInfoBinding>() {
    override fun initView() {
        setTitle("订单详情")
    }

    override fun initData() {
        val data = intent.getSerializableExtra("data") as PersonalOrderData.RowsBean
        bind.tv0.text = data.orderTypeName
        bind.tv1.text = "订单编号: ${data.orderNo}"
        bind.tv2.text = "订单商品: ${data.name}"
        bind.tv3.text = "订单状态: ${data.orderStatus}"
        bind.tv4.text = "${data.amount} 元"
    }

    override fun onClick() {
    }
}