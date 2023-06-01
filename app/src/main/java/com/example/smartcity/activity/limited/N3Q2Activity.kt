package com.example.smartcity.activity.limited

import android.media.MediaMetadataRetriever
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.smartcity.R
import com.example.smartcity.adapter.ViewHolder
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityN3Q2Binding
import com.example.smartcity.databinding.ItemMainNav3Home0Binding
import com.example.smartcity.databinding.ItemMainNav3Home1Binding
import com.example.smartcity.databinding.ItemMainNav3Home2Binding
import com.example.smartcity.pojo.Data
import com.example.smartcity.pojo.TTS
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class N3Q2Activity : BaseActivity<ActivityN3Q2Binding>() {
    private var rounded = RequestOptions.bitmapTransform(RoundedCorners(5))
    private lateinit var tts: TTS
    private var data: MutableList<Data.News> = mutableListOf()
    private val tabs = arrayOf("理论导航", "三会一课", "先锋模范", "小康社会", "体察民生", "社会动态")
    override fun initView() {
        setTitle("党建动态")
        data.addAll(Data.news)
        tts = TTS(c, window.decorView)
        bind.toolbar.toolbar.setBackgroundColor(c.getColor(R.color.red))
        window.statusBarColor = c.getColor(R.color.red)
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        bind.tab.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                data.shuffle()
                bind.rv.adapter = object : RecyclerView.Adapter<ViewHolder>() {
                    override fun getItemViewType(position: Int): Int {
                        return data[position].item
                    }

                    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                        return when (viewType) {
                            0 -> ViewHolder(
                                ItemMainNav3Home0Binding.inflate(
                                    LayoutInflater.from(parent.context),
                                    parent,
                                    false
                                )
                            )
                            1 -> ViewHolder(
                                ItemMainNav3Home1Binding.inflate(
                                    LayoutInflater.from(parent.context),
                                    parent,
                                    false
                                )
                            )
                            else -> ViewHolder(
                                ItemMainNav3Home2Binding.inflate(
                                    LayoutInflater.from(parent.context),
                                    parent,
                                    false
                                )
                            )
                        }
                    }

                    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                        var news = data[position]
                        holder.bind.root.setOnClickListener {
                            start<N3Q2InfoActivity> { it.putExtra("data", news) }
                        }
                        if (news.item == 0) {
                            var bind = holder.bind as ItemMainNav3Home0Binding
                            bind.tv0.text = news.title
                            bind.tv1.text = news.time
                            bind.tvVolume.setOnClickListener {
                                tts.speak(news.title, news.content)
                            }
                        } else if (news.item == 1) {
                            var bind = holder.bind as ItemMainNav3Home1Binding
                            bind.tv0.text = news.title
                            bind.tv1.text = news.time
                            Glide.with(c).load(news.img).apply(rounded).into(bind.iv)
                        } else {
                            var bind = holder.bind as ItemMainNav3Home2Binding
                            val url = "android.resource://${c.packageName}/raw/${news.video}"
                            bind.vv.setVideoURI(Uri.parse(url))
                            val retriever = MediaMetadataRetriever()
                            retriever.setDataSource(c, Uri.parse(url))
                            bind.iv.setImageBitmap(retriever.frameAtTime)
                            bind.play.setOnClickListener {
                                bind.vv.start()
                                bind.iv.visibility = View.GONE
                                bind.play.visibility = View.GONE
                            }
                            bind.vv.setOnTouchListener { v, event ->
                                bind.vv.pause()
                                bind.play.visibility = View.VISIBLE
                                true
                            }
                        }
                    }

                    override fun getItemCount(): Int {
                        return data.size
                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        for (t in tabs) {
            bind.tab.addTab(bind.tab.newTab().setText(t))
        }
    }

    override fun onClick() {

    }

    override fun onPause() {
        super.onPause()
        tts.stop()
    }
}