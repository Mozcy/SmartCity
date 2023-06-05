package com.example.smartcity.activity.limited

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q6InfoBinding
import com.example.smartcity.databinding.ItemMainNav3Q6Binding
import com.example.smartcity.pojo.Data

class N3Q6InfoActivity : BaseActivity<ActivityN3Q6InfoBinding>() {


    override fun initView() {
        setTitle("最新发布")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        bind.rv.adapter = object : CommonAdapter<ItemMainNav3Q6Binding, Data.Comment>(Data.q6) {
            override fun bind(holder: ItemMainNav3Q6Binding, data: Data.Comment) {
                setText(holder.tv0, "主题: ${data.title}")
                    .setText(holder.tv1, "发布时间: ${data.time}")
                    .setText(holder.tv2, "内容: ${data.content}")
                Glide.with(c).load(data.img).error(R.drawable.danglearn3).into(holder.iv)
            }

        }
    }

    override fun onClick() {

    }
}