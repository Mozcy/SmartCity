package com.example.smartcity.activity.gov

import android.content.Intent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smartcity.activity.personal.LoginActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.adapter.ViewPagerAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityGovBinding
import com.example.smartcity.databinding.ItemGovListRvBinding
import com.example.smartcity.databinding.ItemGovRv0Binding
import com.example.smartcity.pojo.gov.GovBannerData
import com.example.smartcity.pojo.gov.GovLabelData
import com.example.smartcity.pojo.gov.GovListData
import com.example.smartcity.utils.baseURL
import com.example.smartcity.utils.get
import com.example.smartcity.utils.isLogin
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class GovActivity : BaseActivity<ActivityGovBinding>() {
    private val rvs = mutableListOf<RecyclerView>()
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                initData()
            }
        }

    override fun initView() {
        setTitle("政府服务热线")
        bind.rv1.layoutManager = LinearLayoutManager(c)
        for (i in 0..1) {
            rvs.add(RecyclerView(c).apply {
                overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                layoutManager = object : GridLayoutManager(c, 4) {
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
            })
        }
    }

    override fun initData() {
        if (c.isLogin { launcher.launch(Intent(c, LoginActivity::class.java)) }) {
            get<GovBannerData>("/api/gov-service-hotline/ad-banner/list") {
                bind.banner.banner.apply {
                    indicator = CircleIndicator(c)
                    adapter = object : BannerImageAdapter<GovBannerData.DataBean>(it.data) {
                        override fun onBindView(
                            p0: BannerImageHolder?,
                            p1: GovBannerData.DataBean?,
                            p2: Int,
                            p3: Int
                        ) {
                            Glide.with(c).load(baseURL + p1?.imgUrl).into(p0!!.imageView)
                        }
                    }
                }
            }
            get<GovLabelData>("/api/gov-service-hotline/appeal-category/list") { label ->
                setRv(rvs[0], label.rows.filterIndexed { index, _ -> index < 8 })
                setRv(rvs[1], label.rows.filterIndexed { index, _ -> (index in 8..15) })
                bind.vp.adapter = ViewPagerAdapter(rvs)
            }
            get<GovListData>("/api/gov-service-hotline/appeal/my-list") { list ->
                dismiss()
                bind.tv.tvNo.visibility = if (list.rows.isEmpty()) View.VISIBLE else View.GONE
                bind.tv.tvNo.text = "暂无述求数据"
                list.rows.sortWith(Comparator { o1, o2 ->
                    o2.state.toInt() - o1.state.toInt()
                })
                bind.rv1.adapter =
                    object :
                        CommonAdapter<ItemGovListRvBinding, GovListData.RowsBean>(list.rows) {
                        override fun bind(
                            holder: ItemGovListRvBinding,
                            data: GovListData.RowsBean
                        ) {
                            var temp = if (data.state == "0") "未处理" else "已处理"
                            setText(holder.tv0, data.title)
                                .setText(holder.tv1, temp)
                                .setText(holder.tv2, "承办单位: ${data.undertaker}")
                                .setText(holder.tv3, "提交时间: ${data.createTime}")
                                .setClick(holder.cv) {
                                    start<GovInfoActivity> { it.putExtra("data", data.id) }
                                }
                        }
                    }
            }
        }
    }

    private fun setRv(rv: RecyclerView, list: List<GovLabelData.RowsBean>) {
        rv.adapter = object : CommonAdapter<ItemGovRv0Binding, GovLabelData.RowsBean>(list) {
            override fun bind(holder: ItemGovRv0Binding, data: GovLabelData.RowsBean) {
                setImage(holder.iv, data?.imgUrl)
                    .setText(holder.tv, data?.name)
                    .setClick(holder.ll) {
                        intent = if (data.name == "其他诉求") {
                            Intent(c, GovAddActivity::class.java).putExtra("data", true)
                        } else {
                            Intent(c, GovListActivity::class.java).putExtra("data", data.id)
                        }
                        launcher.launch(intent)
                    }
            }
        }
    }

    override fun onClick() {
    }
}