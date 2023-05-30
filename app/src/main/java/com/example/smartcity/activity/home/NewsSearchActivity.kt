package com.example.smartcity.activity.home

import android.text.Html
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityNewsSerachBinding
import com.example.smartcity.databinding.ItemMainNav1Rv2Binding
import com.example.smartcity.pojo.home.NewsData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.show

class NewsSearchActivity : BaseActivity<ActivityNewsSerachBinding>() {

    override fun initView() {
        setTitle("新闻资讯列表")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        val data = intent.getStringExtra("data").toString()
        get<NewsData>("/press/press/list?title=${data}") {
            bind.no.tvNo.show(it.rows.isEmpty()).text = "暂无 \"$data\" 相关资讯"
            bind.rv.adapter = object :
                CommonAdapter<ItemMainNav1Rv2Binding, NewsData.RowsBean>(it.rows) {
                override fun bind(
                    holder: ItemMainNav1Rv2Binding, data: NewsData.RowsBean
                ) {
                    val flag = it.rows.indexOf(data) % 2 == 0
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
    }

    override fun onClick() {
    }
}