package com.example.smartcity.activity.library

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityLibraryCommentBinding
import com.example.smartcity.databinding.ItemLibraryCommentBinding
import com.example.smartcity.pojo.MsgData
import com.example.smartcity.pojo.library.LibraryCommentData
import com.example.smartcity.utils.get
import com.example.smartcity.utils.hide
import com.example.smartcity.utils.post
import com.example.smartcity.utils.userBean

class LibraryCommentActivity : BaseActivity<ActivityLibraryCommentBinding>() {
    private var id: Int = 10
    override fun initView() {
        setTitle("图书馆评论")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        id = intent.getIntExtra("data", 10)
        get<LibraryCommentData>("/api/digital-library/library-comment/list?libraryId=${id}") {
            // 模拟点赞数进行排序目前接口没有这个字段 如果有可以替换掉
            it.data.apply {
                forEach {
                    it.remark = (10..90).random()
                }
                sortWith(Comparator { o1, o2 -> o2.remark - o1.remark })
            }
            bind.tvAll.text = "评论总数 (${it.data?.size})"
            bind.no.tvNo.visibility = if (it.data.isEmpty()) View.VISIBLE else View.GONE
            bind.no.tvNo.text = "暂无评论数据"
            bind.rv.adapter = object :
                CommonAdapter<ItemLibraryCommentBinding, LibraryCommentData.DataBean>(it.data) {
                override fun bind(
                    holder: ItemLibraryCommentBinding, data: LibraryCommentData.DataBean
                ) {
                    setText(holder.tv0, data.userName)
                        .setText(holder.tv1, data.content)
                        .setText(holder.tvLike, "${data.remark}")
                        .setText(holder.tvBtn, "${if (data.isMyLikeState) "取消点赞" else "点赞"}")
                        .setClick(holder.tvBtn) {
                            loadingMsg("请求中...")
                            val map = mapOf("commentId" to data.id, "like" to !data.isMyLikeState)
                            try {
                                post<MsgData>("/api/digital-library/library-comment/like", map) {
                                    holder.tvLike.text = if (data.isMyLikeState) {
                                        (holder.tvLike.text.toString().toInt() - 1).toString()
                                    } else {
                                        (holder.tvLike.text.toString().toInt() + 1).toString()
                                    }
                                    toast(if (data.isMyLikeState) "取消点赞成功" else "点赞成功")
                                    data.isMyLikeState = !data.isMyLikeState
                                    holder.tvBtn.text =
                                        "${if (data.isMyLikeState) "取消点赞" else "点赞"}"
                                }
                            } catch (e: Exception) {
                            } finally {
                                dismiss()
                            }
                        }
                }
            }
        }

    }

    override fun onClick() {
        bind.btn.setOnClickListener {
            val et = bind.et0.text.toString()
            bind.et0.hide(c)
            if (et.isEmpty()) {
                toast("请输入评论信息")
            } else {
                loadingMsg("发表中...")
                val map = mapOf(
                    "content" to et,
                    "libraryId" to id,
                    "myLikeState" to false,
                    "userId" to userBean?.userId
                )
                post<MsgData>("/api/digital-library/library-comment", map) {
                    dismiss()
                    toast(it.msg)
                    if (it.code == 200) {
                        bind.et0.text = null
                        initData()
                    }
                }
            }
        }
    }
}