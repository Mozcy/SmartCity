package com.example.smartcity.activity.home

import android.text.Html
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.activity.personal.LoginActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityNewsInfoBinding
import com.example.smartcity.databinding.ItemMainNav1CommentBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.pojo.home.NewsCommentData
import com.example.smartcity.pojo.home.NewsInfoData
import com.example.smartcity.utils.*

class NewsInfoActivity : BaseActivity<ActivityNewsInfoBinding>() {
    private var id = 8
    override fun initView() {
        setTitle("新闻详情")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        id = intent.getIntExtra("data", 8)
        get<NewsInfoData>("/press/press/${id}") {
            Glide.with(c).load(baseURL + it.data?.cover).into(bind.iv)
            bind.tv0.text = it.data.title
            bind.tv1.text = Html.fromHtml(it.data.content, 1)
        }
        loadComment()
    }

    private fun loadComment() {
        get<NewsCommentData>("/press/comments/list?newsId=${id}") {
            bind.no.tvNo.show(it.rows.isEmpty()).text = "暂无评论内容"
            bind.tvComment.text = "评论总数 (${it.total})"
            bind.rv.setItemViewCacheSize(it.total)
            it.rows.apply { sortWith(Comparator { o1, o2 -> o2.commentDate.compareTo(o1.commentDate) }) }
            bind.rv.adapter = object :
                CommonAdapter<ItemMainNav1CommentBinding, NewsCommentData.RowsBean>(it.rows) {
                override fun bind(
                    holder: ItemMainNav1CommentBinding, data: NewsCommentData.RowsBean
                ) {
                    setText(holder.tv0, data.userName)
                        .setText(holder.tv1, data.commentDate)
                        .setText(holder.tv2, data.content)
                }
            }
        }
    }

    override fun onClick() {
        bind.btn.setOnClickListener {
            val data = bind.et.text.toString()
            if (data.isEmpty()) {
                toast("请输入评论内容")
            } else if (c.isLogin { start<LoginActivity> { } }) {
                loadingMsg("评论中...")
                bind.et.hide(c).text = null
                val map = mapOf("content" to data, "newsId" to id, "userId" to userBean?.userId)
                post<MsgData>("/press/pressComment", map) {
                    dismiss()
                    if (it.code == 200) {
                        toast("评论成功")
                        loadComment()
                    } else {
                        toast(it.msg)
                    }
                }
            }
        }
    }
}