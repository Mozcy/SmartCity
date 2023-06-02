package com.example.smartcity.activity.limited

import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q3Binding
import com.example.smartcity.databinding.ItemMainNav3Q2Binding
import com.example.smartcity.pojo.Data
import com.google.android.material.tabs.TabLayout
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class N3Q3Activity : BaseActivity<ActivityN3Q3Binding>() {
    private val data: MutableList<Data.Learn> = mutableListOf()
    private val tabs = arrayOf("党风廉政", "法律法规", "辉煌中国", "法律法规", "不忘初心继续前进")
    override fun initView() {
        setTitle("党员学习")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv.layoutManager = GridLayoutManager(c, 2)
    }

    override fun initData() {
        data.addAll(Data.learns)
        bind.banner.banner.apply {
            indicator = CircleIndicator(c)
            setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            adapter = object : BannerImageAdapter<Int>(Data.bannerLearn) {
                override fun onBindView(p0: BannerImageHolder?, p1: Int?, p2: Int, p3: Int) {
                    Glide.with(c).load(p1).into(p0!!.imageView)
                    p0.imageView.setOnClickListener {
                        start<N3Q3InfoActivity> { it.putExtra("data", Data.learns[p2]) }
                    }
                }

            }
        }
        bind.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                data.shuffle()
                bind.rv.adapter = object : CommonAdapter<ItemMainNav3Q2Binding, Data.Learn>(data) {
                    override fun bind(holder: ItemMainNav3Q2Binding, data: Data.Learn) {
                        setText(holder.tv, data.title)
                            .setImage(holder.iv, data.img)
                            .setClick(holder.cv) {
                                start<N3Q3InfoActivity> { it.putExtra("data", data) }
                            }
                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        for (s in tabs) {
            bind.tab.addTab(bind.tab.newTab().setText(s))
        }
    }

    override fun onClick() {
    }
}