package com.example.smartcity.activity.library

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.activity.personal.LoginActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityLibraryBinding
import com.example.smartcity.databinding.ItemLibraryListBinding
import com.example.smartcity.pojo.library.LibraryListData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.isLogin

class LibraryActivity : BaseActivity<ActivityLibraryBinding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                initData()
            }
        }

    override fun initView() {
        setTitle("数字图书馆")
        bind.rv.layoutManager = LinearLayoutManager(c)

    }

    override fun initData() {
        if (c.isLogin { launcher.launch(Intent(c, LoginActivity::class.java)) }) {
            get<LibraryListData>("/api/digital-library/library/list") {
                bind.rv.adapter =
                    object :
                        CommonAdapter<ItemLibraryListBinding, LibraryListData.RowsBean>(it.rows) {
                        override fun bind(
                            holder: ItemLibraryListBinding, data: LibraryListData.RowsBean
                        ) {
                            val status = if (data.businessState == "1") "营业中" else "未营业"
                            setText(holder.tv0, data.name)
                                .setText(holder.tv1, status)
                                .setText(holder.tv2, "营业时间: ${data.businessHours}")
                                .setText(holder.tv3, "地址: ${data.address}")
                                .setClick(holder.cv) {
                                    start<LibraryInfoActivity> { it.putExtra("data", data.id) }
                                }
                        }
                    }
            }
        }
    }

    override fun onClick() {
    }
}