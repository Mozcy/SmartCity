package com.example.smartcity.activity.limited

import android.graphics.Color
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q3InfoBinding
import com.example.smartcity.databinding.ItemMainNav1CommentBinding
import com.example.smartcity.databinding.ItemMainNav3Q3InfoBinding
import com.example.smartcity.pojo.Data
import com.example.smartcity.utils.hide

class N3Q3InfoActivity : BaseActivity<ActivityN3Q3InfoBinding>() {
    private val list: MutableList<Array<String>> = mutableListOf()
    private val rv0d: MutableList<String> = mutableListOf()
    private val raws = intArrayOf(R.raw.video01, R.raw.video02, R.raw.video03)

    override fun initView() {
        setTitle("课程详情")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv0.layoutManager = LinearLayoutManager(c)
        bind.rv1.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        var data = intent.getSerializableExtra("data") as Data.Learn?
        bind.tvContent.text = data?.content
        comment()
        setVideo(data!!.video)
        list.add(arrayOf("张三", Data.f.format(System.currentTimeMillis()), "伟大的中国共产党,坚持一个中国原则。"))
        list.add(arrayOf("王五", Data.f.format(System.currentTimeMillis()), "中国建党100周年。"))
        rv0d.add("第一章 党的伟大")
        rv0d.add("第二章 党的100年")
        rv0d.add("第三章 党的精神")
        bind.rv0.adapter = object : CommonAdapter<ItemMainNav3Q3InfoBinding, String>(rv0d) {
            var temp = rv0d[0]
            override fun bind(holder: ItemMainNav3Q3InfoBinding, data: String) {
                holder.cb.apply {
                    text = data
                    isChecked = temp === data
                    setTextColor(if (temp === data) Color.WHITE else Color.BLACK)
                    setOnClickListener {
                        temp = data
                        notifyDataSetChanged()
                        setVideo(raws[rv0d.indexOf(data)])
                    }
                }

            }

        }
    }

    override fun onClick() {
        bind.btn.setOnClickListener {
            val s: String = bind.et.text.toString()
            if (s.isEmpty()) {
                toast("请输入内容")
            } else {
                list.add(0, arrayOf("测试用户", Data.f.format(System.currentTimeMillis()), s))
                bind.et.hide(c)
                toast("提交成功")
                comment()
            }
        }
    }

    private fun comment() {
        bind.rv1.adapter = object : CommonAdapter<ItemMainNav1CommentBinding, Array<String>>(list) {
            override fun bind(holder: ItemMainNav1CommentBinding, data: Array<String>) {
                setText(holder.tv0, data[0])
                    .setText(holder.tv1, data[1])
                    .setText(holder.tv2, data[2])
            }
        }
    }

    private fun setVideo(raw: Int) {
        val url = "android.resource://${packageName}/raw/${raw}"
        bind.video.vv.setVideoURI(Uri.parse(url))
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(c, Uri.parse(url))
        bind.video.iv.setImageBitmap(retriever.frameAtTime)
        bind.video.play.setOnClickListener {
            bind.video.vv.start()
            bind.video.iv.visibility = View.GONE
            bind.video.play.visibility = View.GONE
        }
        bind.video.vv.setOnTouchListener { v, e ->
            bind.video.vv.pause()
            bind.video.play.visibility = View.VISIBLE
            true
        }
    }

}