package com.example.smartcity.activity.personal

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityPersonalFeedbackListBinding
import com.example.smartcity.databinding.ItemMainNav5FeedbackBinding
import com.example.smartcity.pojo.personal.PersonalFeedbackData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.show

class PersonalFeedbackListActivity : BaseActivity<ActivityPersonalFeedbackListBinding>() {
    override fun initView() {
        setTitle("反馈历史记录")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        get<PersonalFeedbackData>("/api/common/feedback/list") {
            bind.no.tvNo.show(it.total == 0).text = "暂无反馈记录"
            bind.rv.adapter = object :
                CommonAdapter<ItemMainNav5FeedbackBinding, PersonalFeedbackData.RowsBean>(it.rows) {
                override fun bind(
                    holder: ItemMainNav5FeedbackBinding, data: PersonalFeedbackData.RowsBean
                ) {
                    setText(holder.tv0, data.title ?: "无标题")
                        .setText(holder.tv1, data.content.let {
                            if (it.length >= 20) {
                                "${it.substring(0..19)}..."
                            } else {
                                it
                            }
                        })
                        .setClick(holder.cv) {
                            start<PersonalFeedbackInfoActivity> { it.putExtra("data", data) }
                        }
                }
            }
        }
    }

    override fun onClick() {

    }
}
