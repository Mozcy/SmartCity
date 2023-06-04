package com.example.smartcity.activity.limited

import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q5InfoBinding
import com.example.smartcity.databinding.ItemMainNav1CommentBinding
import com.example.smartcity.databinding.ItemMainNav3Q5InfoBinding
import com.example.smartcity.pojo.Data

class N3Q5InfoActivity : BaseActivity<ActivityN3Q5InfoBinding>() {
    private val ets = arrayOfNulls<EditText>(4)
    override fun initView() {
        setTitle("领导留言")
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        bind.rv.adapter = object : CommonAdapter<ItemMainNav3Q5InfoBinding, Data.Comment>(Data.q5) {
            override fun bind(holder: ItemMainNav3Q5InfoBinding, data: Data.Comment) {
                holder.cb.setOnCheckedChangeListener { _, isChecked ->
                    holder.rl.visibility = if (isChecked) View.VISIBLE else View.GONE
                }
                setText(holder.tv0, "标题: ${data.title}")
                    .setText(holder.tv1, "姓名: ${data.name}  电话: ${data.tel}")
                    .setText(holder.tv2, "内容: ${data.content}")
                holder.no.tvNo.text = "暂无领导留言"
                holder.no.tvNo.visibility = if (data.list.isEmpty()) View.VISIBLE else View.GONE
                holder.rv.layoutManager = LinearLayoutManager(c)
                holder.rv.adapter =
                    object : CommonAdapter<ItemMainNav1CommentBinding, Array<String>>(data.list) {
                        override fun bind(holder: ItemMainNav1CommentBinding, data: Array<String>) {
                            setText(holder.tv0, data[0])
                                .setText(holder.tv1, data[1])
                                .setText(holder.tv2, data[2])
                        }

                    }
            }

        }
    }

    override fun onClick() {
    }
}