package com.example.smartcity.fragment

import android.text.Html
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.activity.home.NewsInfoActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseFragment
import com.example.smartcity.databinding.FragmentMainNav4Binding
import com.example.smartcity.databinding.ItemMainNav1Rv2Binding
import com.example.smartcity.pojo.home.NewsData
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.get
import com.google.android.material.tabs.TabLayout
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class MainFragmentNav4 : BaseFragment<FragmentMainNav4Binding>() {
    override fun initView() {
        setTitle("新闻", false)
        bind.rv2.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        get<NewsData>("/press/press/list") { list ->
            get<NewsData>("/press/category/list") { label ->
                bind.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        val temp =
                            list.rows.filter { it.type.toInt() == label.data[tab!!.position].id }
                        bind.banner.banner.apply {
                            indicator = CircleIndicator(c)
                            adapter = object : BannerImageAdapter<NewsData.RowsBean>(temp) {
                                override fun onBindView(
                                    p0: BannerImageHolder?, p1: NewsData.RowsBean, p2: Int, p3: Int
                                ) {
                                    Glide.with(c).load(baseURL + p1?.cover).into(p0!!.imageView)
                                    p0?.imageView.setOnClickListener {
                                        start<NewsInfoActivity> { it.putExtra("data", p1?.id) }
                                    }
                                }
                            }
                        }
                        bind.rv2.adapter = object :
                            CommonAdapter<ItemMainNav1Rv2Binding, NewsData.RowsBean>(temp) {
                            override fun bind(
                                holder: ItemMainNav1Rv2Binding, data: NewsData.RowsBean
                            ) {
                                val flag = temp.indexOf(data) % 2 == 0
                                setImage(if (flag) holder.iv0 else holder.iv1, data?.cover)
                                    .setText(holder.tv0, data.title)
                                    .setText(holder.tv1, "${Html.fromHtml(data.content, 1)}")
                                    .setText(holder.tv2, "${data.commentNum} 人评论")
                                    .setText(holder.tv3, "${data.publishDate} 发布")
                                    .setClick(holder.cv) {
                                        start<NewsInfoActivity> { it.putExtra("data", data.id) }
                                    }
                                holder.iv0.visibility = if (flag) View.VISIBLE else View.GONE
                                holder.iv1.visibility = if (!flag) View.VISIBLE else View.GONE
                            }
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {}
                    override fun onTabReselected(tab: TabLayout.Tab?) {}
                })
                label.data.forEach {
                    bind.tab.addTab(bind.tab.newTab().setText(it.name))
                }
            }
        }
    }

    override fun onClick() {
    }
}