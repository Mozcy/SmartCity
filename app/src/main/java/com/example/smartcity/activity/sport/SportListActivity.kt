package com.example.smartcity.activity.sport

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivitySportListBinding
import com.example.smartcity.databinding.ItemSportList1Binding
import com.example.smartcity.pojo.sport.SportBannerData
import com.example.smartcity.pojo.sport.SportListData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.isPad
import com.example.smartcity.utils.show

class SportListActivity : BaseActivity<ActivitySportListBinding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) initData()
        }

    override fun initView() {
        setTitle("场馆列表")
        bind.rv.layoutManager = GridLayoutManager(c, if (c.isPad()) 4 else 2)
    }

    override fun initData() {
        loadingMsg("加载中...")
        val data = intent.getStringExtra("data").let { it ?: "" }
        val menuId = intent.getIntExtra("menuId", -1)
        get<SportBannerData>("/sport/carousel/list") { img ->
            get<SportListData>("/sport/venue/list${data}") {
                var data = it.rows.apply { sortByDescending { it.likeNum } }
                if (menuId != -1) data =
                    it.rows.filter { it.sportMenus.find { it.menuId == menuId } != null }
                bind.no.tvNo.show(data.isEmpty()).text = "暂无相关运动场馆"
                bind.rv.adapter = object :
                    CommonAdapter<ItemSportList1Binding, SportListData.RowsBean>(data) {
                    override fun bind(holder: ItemSportList1Binding, data: SportListData.RowsBean) {
                        val image = img.rows.find { it.sportVenurId.toInt() == data.id }?.imgUrl
                        setImage(holder.iv, image)
                            .setText(holder.tv0, data.sportVenueName)
                            .setText(holder.tv1, "${data.likeNum} 赞")
                            .setText(holder.tv2, "${data?.openTime?.split("-")?.get(0)}")
                            .setText(holder.tv3, "${data?.openTime?.split("-")?.get(1)}")
                            .setClick(holder.cv) {
                                val intent = Intent(c, SportInfoActivity::class.java)
                                    .putExtra("data", data.id)
                                launcher.launch(intent)
                            }
                    }
                }
                dismiss()
            }
        }
    }

    override fun onClick() {
    }
}