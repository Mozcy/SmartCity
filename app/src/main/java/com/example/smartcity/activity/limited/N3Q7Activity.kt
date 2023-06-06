package com.example.smartcity.activity.limited

import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q7Binding
import com.example.smartcity.databinding.ItemMainNav3Q7Binding
import com.example.smartcity.pojo.Data
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

class N3Q7Activity : BaseActivity<ActivityN3Q7Binding>() {
    private val list: MutableList<Array<Any>> = mutableListOf()
    override fun initView() {
        setTitle("百年党史")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv.layoutManager = GridLayoutManager(c, 2)
    }

    override fun initData() {
        list.add(arrayOf(R.drawable.danglearn2, "开天辟地\n(1921-1927)"))
        list.add(arrayOf(R.drawable.danglearn3, "星火燎原\n(1928-1932)"))
        list.add(arrayOf(R.drawable.danglearn4, "抗日洪流\n(1933-1938)"))
        list.add(arrayOf(R.drawable.danglearn2, "激情岁月\n(1939-1945)"))
        list.add(arrayOf(R.drawable.danglearn3, "日月新天\n(1946-1966)"))
        list.add(arrayOf(R.drawable.danglearn3, "胜利之师\n(1967-1978)"))
        bind.banner.banner.adapter = object : BannerImageAdapter<Int>(Data.bannerLearn) {
            override fun onBindView(p0: BannerImageHolder?, p1: Int?, p2: Int, p3: Int) {
                Glide.with(c).load(p1).into(p0!!.imageView)
                p0!!.imageView.setOnClickListener {
                    start<N3Q3InfoActivity> { it.putExtra("data", Data.learns[p2]) }
                }
            }

        }
        bind.rv.adapter = object : CommonAdapter<ItemMainNav3Q7Binding, Array<Any>>(list) {
            override fun bind(holder: ItemMainNav3Q7Binding, data: Array<Any>) {
                setText(holder.tv, data[1] as String)
                    .setImage(holder.iv, data[0] as Int)
                    .setClick(holder.cv) {
                        start<N3Q3InfoActivity> { it.putExtra("data", Data.learns[0]) }
                    }
            }

        }
    }

    override fun onClick() {
    }

}