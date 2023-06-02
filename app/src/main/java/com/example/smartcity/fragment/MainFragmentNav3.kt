package com.example.smartcity.fragment

import android.content.Intent
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.smartcity.MainActivity
import com.example.smartcity.R
import com.example.smartcity.activity.home.NewsSearchActivity
import com.example.smartcity.activity.limited.N3Q2InfoActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.adapter.ViewHolder
import com.example.smartcity.base.BaseFragment
import com.example.smartcity.databinding.*
import com.example.smartcity.pojo.Data
import com.example.smartcity.utils.TTS
import com.example.smartcity.utils.hide
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class MainFragmentNav3 : BaseFragment<FragmentMainNav3Binding>() {
    private lateinit var tts: TTS
    private var rounded = RequestOptions.bitmapTransform(RoundedCorners(5))
    override fun initView() {
        tts = TTS(c, activity?.window!!.decorView)
        bind.rv0.layoutManager = GridLayoutManager(context, 3)
        bind.rv1.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        bind.banner.banner.setIndicator(CircleIndicator(context))
            .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            .setAdapter(object : BannerImageAdapter<Int?>(Data.homeBanner) {
                override fun onBindView(p0: BannerImageHolder?, p1: Int?, p2: Int, p3: Int) {
                    Glide.with(context!!).load(p1).into(p0!!.imageView)
                    p0?.imageView.setOnClickListener {
                        start<N3Q2InfoActivity> { it.putExtra("data", Data.news[p2]) }
                    }
                }
            }).start()
        bind.rv0.adapter =
            object : CommonAdapter<ItemMainNav3HomeEntryBinding, Data.Service>(Data.homeEntry) {
                override fun bind(holder: ItemMainNav3HomeEntryBinding, data: Data.Service) {
                    setText(holder.tv, data.title)
                        .setImage(holder.iv, data.img)
                        .setClick(holder.ll) {
                            startActivity(Intent(context, data.getaClass()))
                        }
                }

            }
        bind.rv1.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun getItemViewType(position: Int): Int {
                return Data.news[position].item
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
                var news = Data.news[position]
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
                return Data.news.size
            }

        }

    }

    override fun onClick() {
        bind.tvMe.setOnClickListener {
            (c as MainActivity).bind.nav.selectedItemId = R.id.main_nav5
        }

        bind.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val data = bind.etSearch.text.toString()
                if (data.isEmpty()) {
                    toast("请输入搜索内容")
                } else {
                    bind.etSearch.hide(c).text = null
                    start<NewsSearchActivity> { it.putExtra("data", data) }
                }
            }
            true
        }
    }

    override fun onPause() {
        super.onPause()
        tts.stop()
    }
}