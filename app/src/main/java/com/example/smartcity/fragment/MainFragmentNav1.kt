package com.example.smartcity.fragment

import android.content.Intent
import android.text.Html
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smartcity.MainActivity
import com.example.smartcity.R
import com.example.smartcity.activity.home.NewsInfoActivity
import com.example.smartcity.activity.home.NewsSearchActivity
import com.example.smartcity.activity.home.NullActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.adapter.ViewPagerAdapter
import com.example.smartcity.base.BaseFragment
import com.example.smartcity.databinding.FragmentMainNav1Binding
import com.example.smartcity.databinding.ItemMainNav1Rv0Binding
import com.example.smartcity.databinding.ItemMainNav1Rv1Binding
import com.example.smartcity.databinding.ItemMainNav1Rv2Binding
import com.example.smartcity.pojo.home.BannerData
import com.example.smartcity.pojo.home.NewsData
import com.example.smartcity.pojo.home.ServiceListData
import com.example.smartcity.utils.*
import com.google.android.material.tabs.TabLayout
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class MainFragmentNav1 : BaseFragment<FragmentMainNav1Binding>() {
    private val rvs = mutableListOf<RecyclerView>()
    override fun initView() {
        setTitle("首页", false)
        bind.rv0.layoutManager = GridLayoutManager(c, 5)
        bind.rv2.layoutManager = LinearLayoutManager(c)
        for (i in 0..1) {
            rvs.add(RecyclerView(c).apply {
                overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                layoutManager = GridLayoutManager(c, if (c.isPad()) 4 else 2)
            })
        }
    }

    override fun initData() {
        get<BannerData>("/api/rotation/list") {
            bind.banner.banner.apply {
                indicator = CircleIndicator(c)
                adapter = object : BannerImageAdapter<BannerData.RowsBean>(it.rows) {
                    override fun onBindView(
                        p0: BannerImageHolder?, p1: BannerData.RowsBean?, p2: Int, p3: Int
                    ) {
                        Glide.with(c).load(baseURL + p1?.advImg).into(p0!!.imageView)
                        p0?.imageView.setOnClickListener {
                            start<NewsInfoActivity> { it.putExtra("data", p1?.targetId) }
                        }
                    }
                }
            }
        }
        get<ServiceListData>("/api/service/list") {
            it.rows.apply { sortWith(Comparator { o1, o2 -> o2.sort - o1.sort }) }
            val data = it.rows.filterIndexed { index, _ -> index < 9 }.let {
                var more = ServiceListData.RowsBean().apply { sort = -1; serviceName = "更多服务" }
                it.toMutableList().apply { add(more) }
            }
            bind.rv0.adapter = object :
                CommonAdapter<ItemMainNav1Rv0Binding, ServiceListData.RowsBean>(data) {
                override fun bind(
                    holder: ItemMainNav1Rv0Binding, data: ServiceListData.RowsBean
                ) {
                    setImage(holder.iv, data.imgUrl ?: R.mipmap.icon_more)
                        .setText(holder.tv, data.serviceName)
                        .setClick(holder.ll) {
                            when (data.serviceName) {
                                "更多服务" -> (c as MainActivity).bind.nav.selectedItemId =
                                    R.id.main_nav2
                                else -> {
                                    val clazz = entry[data.serviceName]
                                    val intent = Intent(c, clazz ?: NullActivity::class.java)
                                        .putExtra("data", data.serviceName)
                                    startActivity(intent)
                                }
                            }
                        }
                }
            }
        }
        get<NewsData>("/press/press/list") { list ->
            loadRv1(rvs[0], list.rows.filterIndexed { index, _ -> index < 4 })
            loadRv1(rvs[1], list.rows.filterIndexed { index, _ -> index in (4..7) })
            bind.vp.adapter = ViewPagerAdapter(rvs)
            get<NewsData>("/press/category/list") { label ->
                bind.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        val temp =
                            list.rows.filter { it.type.toInt() == label.data[tab!!.position].id }
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

    private fun loadRv1(rv: RecyclerView, list: List<NewsData.RowsBean>) {
        rv.adapter = object : CommonAdapter<ItemMainNav1Rv1Binding, NewsData.RowsBean>(list) {
            override fun bind(holder: ItemMainNav1Rv1Binding, data: NewsData.RowsBean) {
                setImage(holder.iv, data?.cover)
                    .setText(holder.tv, data.title)
                    .setClick(holder.cv) {
                        start<NewsInfoActivity> { it.putExtra("data", data.id) }
                    }
            }
        }
    }

    override fun onClick() {
        bind.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val data = bind.etSearch.text.toString()
                if (data.isEmpty()) {
                    toast("请输入搜索内容")
                } else {
                    bind.etSearch.hide(c).text = null
                    start<NewsSearchActivity> { it.putExtra("data", data) }
                }
            }
            true
        }
    }
}