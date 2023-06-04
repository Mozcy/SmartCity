package com.example.smartcity.activity.limited

import android.widget.EditText
import com.example.smartcity.R
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q5Binding
import com.example.smartcity.pojo.Data
import com.example.smartcity.utils.hide
import java.util.*

class N3Q5Activity : BaseActivity<ActivityN3Q5Binding>() {
    private val ets = arrayOfNulls<EditText>(4)
    override fun initView() {
        setTitle("建言献策")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        ets[0] = bind.et0
        ets[1] = bind.et1
        ets[2] = bind.et2
        ets[3] = bind.et3
    }

    override fun initData() {
        if (Data.q5.isEmpty()) {
            val data: Data.Comment = Data.Comment(
                "【奋斗百年路 启航新征程】全力建设区域性国际铁路枢纽",
                "万柳",
                "13302322333",
                "新中国成立后，在党的领导下，1958年，国家投资兴建的准轨贵昆、成昆铁路相继开工，不断推动西南铁路建设大步向前。"
            )
            val list: MutableList<Array<String>> = ArrayList()
            list.add(
                arrayOf(
                    "张书记",
                    Data.f.format(System.currentTimeMillis()),
                    "你的反馈我们已经收到了,经过组织开会决定, 将采用你的建议。"
                )
            )
            data.list = list
        }
    }

    override fun onClick() {
        bind.btn0.setOnClickListener {
            val s = arrayOfNulls<String>(4)
            for (i in ets.indices) {
                val s1 = ets[i]!!.text.toString()
                if (s1.isEmpty()) {
                    toast("请输入完整的信息")
                    return@setOnClickListener
                }
                s[i] = s1
            }
            Data.Comment(s[0], s[1], s[2], s[3])
            toast("提交反馈成功")
            bind.et0.hide(c)
            start<N3Q5InfoActivity> { }
        }
        bind.btn1.setOnClickListener {
            start<N3Q5InfoActivity> { }
        }
    }
}