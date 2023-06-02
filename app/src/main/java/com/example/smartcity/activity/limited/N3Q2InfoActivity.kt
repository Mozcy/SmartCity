package com.example.smartcity.activity.limited

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.smartcity.R
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q2InfoBinding
import com.example.smartcity.databinding.ItemMainNav1CommentBinding
import com.example.smartcity.pojo.Data
import com.example.smartcity.utils.TTS
import com.example.smartcity.utils.hide

class N3Q2InfoActivity : BaseActivity<ActivityN3Q2InfoBinding>() {
    private lateinit var tts: TTS
    private lateinit var data: Data.News
    private var list: MutableList<Array<String>> = mutableListOf()
    override fun initView() {
        setTitle("党建详情")
        tts = TTS(c, window.decorView)
        window.statusBarColor = c.getColor(R.color.red)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        data = c.intent.getSerializableExtra("data") as Data.News
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        bind.tvTitle.text = data.title
        bind.tvTime.text = data.time
        Glide.with(c).load(data.img).into(bind.iv)
        bind.tvContent.text = "    ${data.content}"
        list.add(arrayOf("张三", Data.f.format(System.currentTimeMillis()), "伟大的中国共产党,坚持一个中国原则。"))
        list.add(arrayOf("王五", Data.f.format(System.currentTimeMillis()), "中国建党100周年。"))
        comment()
    }

    override fun onClick() {
        bind.tvVolume.setOnClickListener {
            tts.speak(data.title, data.content)
        }
        bind.btn.setOnClickListener {
            val s: String = bind.et.text.toString()
            if (s.isEmpty()) {
                toast("请输入内容")
            } else {
                list.add(0, arrayOf("测试用户", Data.f.format(System.currentTimeMillis()), s))
            }
            bind.et.hide(c)
            toast("提交成功")
            comment()
        }
    }

    private fun comment() {
        bind.rv.adapter = object : CommonAdapter<ItemMainNav1CommentBinding, Array<String>>(list) {
            override fun bind(holder: ItemMainNav1CommentBinding, data: Array<String>) {
                setText(holder.tv0, data[0])
                    .setText(holder.tv1, data[1])
                    .setText(holder.tv2, data[2])
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        tts.stop()
    }
}