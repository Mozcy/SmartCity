package com.example.smartcity.activity.gov

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityGovListBinding
import com.example.smartcity.databinding.ItemGovListRvBinding
import com.example.smartcity.pojo.gov.GovListData
import com.example.smartcity.utils.get

class GovListActivity : BaseActivity<ActivityGovListBinding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                initData()
            }
        }

    override fun initView() {
        setTitle("诉求列表")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        val id = intent.getIntExtra("data", 10)
        get<GovListData>("/api/gov-service-hotline/appeal/list?appealCategoryId=${id}") {
            bind.rv.adapter =
                object : CommonAdapter<ItemGovListRvBinding, GovListData.RowsBean>(it.rows) {
                    override fun bind(
                        holder: ItemGovListRvBinding,
                        data: GovListData.RowsBean
                    ) {
                        setText(holder.tv0, data.title)
                            .setText(holder.tv1, "${if (data.state == "0") "未处理" else "已处理"}")
                            .setText(holder.tv2, "承办单位: ${data.undertaker}")
                            .setText(holder.tv3, "提交时间: ${data.createTime}")
                            .setClick(holder.cv) {
                                start<GovInfoActivity> { it.putExtra("data", data.id) }
                            }
                    }
                }
        }
        bind.btn.setOnClickListener {
            launcher.launch(Intent(c, GovAddActivity::class.java).putExtra("id", id))
        }
    }

    override fun onClick() {

    }
}