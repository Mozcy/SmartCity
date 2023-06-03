package com.example.smartcity.activity.limited

import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q4Binding
import com.example.smartcity.databinding.ItemMainNav3Q4Binding
import com.example.smartcity.pojo.Data
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class N3Q4Activity : BaseActivity<ActivityN3Q4Binding>() {
    override fun initView() {
        setTitle("组织活动")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv.layoutManager = GridLayoutManager(c, 2)
    }

    override fun initData() {
        bind.banner.banner.apply {
            indicator = CircleIndicator(c)
            setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            adapter = object : BannerImageAdapter<Data.Doing>(Data.doings) {
                override fun onBindView(p0: BannerImageHolder?, p1: Data.Doing, p2: Int, p3: Int) {
                    Glide.with(c).load(p1.img).into(p0!!.imageView)
                    p0.imageView.setOnClickListener {
                        start<N3Q4InfoActivity> { it.putExtra("data", p1) }
                    }
                }

            }
        }
        bind.rv.adapter = object : CommonAdapter<ItemMainNav3Q4Binding, Data.Doing>(Data.doings) {
            override fun bind(holder: ItemMainNav3Q4Binding, data: Data.Doing) {
                setText(holder.tv0, "主题: ${data.title}")
                    .setText(holder.tv1, "时间: ${data.date}")
                    .setText(holder.tv2, "地点: ${data.address}")
                    .setImage(holder.iv, data.img)
                    .setClick(holder.btn) {
                        start<N3Q4InfoActivity> { it.putExtra("data", data) }
                    }
            }

        }
    }

    override fun onClick() {
    }
}