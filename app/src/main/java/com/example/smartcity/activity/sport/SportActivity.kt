package com.example.smartcity.activity.sport

import android.app.Activity
import android.content.Intent
import android.view.inputmethod.EditorInfo
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smartcity.activity.personal.LoginActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.adapter.ViewPagerAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivitySportBinding
import com.example.smartcity.databinding.ItemSportLabelBinding
import com.example.smartcity.databinding.ItemSportList0Binding
import com.example.smartcity.pojo.sport.SportBannerData
import com.example.smartcity.pojo.sport.SportLabelData
import com.example.smartcity.pojo.sport.SportListData
import com.example.smartcity.utils.*
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

class SportActivity : BaseActivity<ActivitySportBinding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) initData()
        }
    private val rvs = mutableListOf<RecyclerView>()
    override fun initView() {
        setTitle("运动健身")
        for (i in 0..1) {
            rvs.add(RecyclerView(c).apply {
                layoutManager = GridLayoutManager(c, 5)
                overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            })
        }
        bind.rv1.layoutManager = GridLayoutManager(c, if (c.isPad()) 4 else 2)
    }

    override fun initData() {
        if (c.isLogin { launcher.launch(Intent(c, LoginActivity::class.java)) }) {
            get<SportBannerData>("/sport/carousel/list") {
                bind.banner.banner.apply {
                    adapter = object : BannerImageAdapter<SportBannerData.RowsBean>(it.rows) {
                        override fun onBindView(
                            p0: BannerImageHolder?, p1: SportBannerData.RowsBean?, p2: Int, p3: Int
                        ) {
                            Glide.with(c).load(baseURL + p1?.imgUrl).into(p0!!.imageView)
                            p0?.imageView.setOnClickListener {
                                val intent = Intent(c, SportInfoActivity::class.java)
                                    .putExtra("data", p1?.sportVenurId?.toInt())
                                launcher.launch(intent)
                            }
                        }
                    }
                }
                loadListRv(it.rows)
            }
            get<SportLabelData>("/sport/menu/list") {
                loadLabelRv(rvs[0], it.rows.filterIndexed { index, _ -> index < 10 })
                loadLabelRv(rvs[1], it.rows.filterIndexed { index, _ -> index >= 10 })
                bind.vp.adapter = ViewPagerAdapter(rvs)
            }
        }
    }

    //加载运动项目入口
    private fun loadLabelRv(rv: RecyclerView, list: List<SportLabelData.RowsBean>) {
        rv.adapter = object :
            CommonAdapter<ItemSportLabelBinding, SportLabelData.RowsBean>(list) {
            override fun bind(holder: ItemSportLabelBinding, data: SportLabelData.RowsBean) {
                setImage(holder.iv, data?.iconUrl)
                    .setText(holder.tv, data.sportMenu)
                    .setClick(holder.ll) {
                        val intent = Intent(c, SportListActivity::class.java)
                            .putExtra("menuId", data.id)
                        launcher.launch(intent)
                    }
            }
        }
    }

    //加载热门场馆列表
    private fun loadListRv(img: List<SportBannerData.RowsBean>) {
        get<SportListData>("/sport/venue/list?pageNum=1&pageSize=10&hot=1") {
            it.rows.apply { sortByDescending { it.likeNum } }
            bind.rv1.adapter = object :
                CommonAdapter<ItemSportList0Binding, SportListData.RowsBean>(it.rows) {
                override fun bind(holder: ItemSportList0Binding, data: SportListData.RowsBean) {
                    setImage(holder.iv, img.find { it.sportVenurId.toInt() == data.id }?.imgUrl)
                        .setText(holder.tv0, data.sportVenueName)
                        .setText(holder.tv1, "${data.likeNum} 赞")
                        .setClick(holder.cv) {
                            val intent = Intent(c, SportInfoActivity::class.java)
                                .putExtra("data", data.id)
                            launcher.launch(intent)
                        }
                }
            }
        }
    }

    override fun onClick() {
        bind.btn.setOnClickListener { start<SportListActivity> { } }
        bind.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val data = bind.etSearch.text.toString()
                if (data.isEmpty()) {
                    toast("请输入搜索内容")
                } else {
                    bind.etSearch.hide(c).text = null
                    start<SportListActivity> { it.putExtra("data", "?sportVenueName=${data}") }
                }
            }
            true
        }
    }
}