package com.example.smartcity.activity.limited

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q4InfoBinding
import com.example.smartcity.databinding.ItemMainNav1CommentBinding
import com.example.smartcity.pojo.Data
import com.example.smartcity.utils.hide

class N3Q4InfoActivity : BaseActivity<ActivityN3Q4InfoBinding>() {
    private val list: MutableList<Array<String>> = mutableListOf()

    override fun initView() {
        setTitle("活动详情")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        var data = intent.getSerializableExtra("data") as Data.Doing?
        bind.tvTitle.text = data?.title
        bind.tvContent.text = data?.content
        bind.tvTime.text = "地点: ${data?.address} 时间: ${data?.date}"
        Glide.with(c).load(data?.img).into(bind.iv)
        list.add(arrayOf("张三", Data.f.format(System.currentTimeMillis()), "伟大的中国共产党,坚持一个中国原则。"))
        list.add(arrayOf("王五", Data.f.format(System.currentTimeMillis()), "中国建党100周年。"))
        comment()
    }

    override fun onClick() {
        bind.btn0.setOnClickListener {
            if (bind.btn0.text.toString() == "加入活动") {
                toast("加入活动成功")
                bind.btn0.text = "已加入"
            } else {
                toast("已加入过该活动")
            }
        }
        bind.btn1.setOnClickListener {
            val s: String = bind.et.text.toString()
            if (s.isEmpty()) {
                toast("请输入内容")
            } else {
                list.add(0, arrayOf("测试用户", Data.f.format(System.currentTimeMillis()), s))
                bind.et.hide(c)
                toast("提交成功")
                comment()
            }
        }

    }

    private fun comment() {
        bind.rv.adapter = object : CommonAdapter<ItemMainNav1CommentBinding, Array<String>>(list) {
            override fun bind(holder: ItemMainNav1CommentBinding, data: Array<String>) {
                setText(holder.tv0, data[0])
                    .setText(holder.tv1, data[1])
                    .setText(holder.tv2, data[2])
            }
        }
    }

}