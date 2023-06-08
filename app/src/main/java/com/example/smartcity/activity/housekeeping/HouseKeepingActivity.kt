package com.example.smartcity.activity.housekeeping

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smartcity.activity.personal.LoginActivity
import com.example.smartcity.adapter.CommonAdapter
import com.example.smartcity.adapter.ViewPagerAdapter
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityHouseKeepingBinding
import com.example.smartcity.databinding.ItemHouseKeepingRv0Binding
import com.example.smartcity.databinding.ItemHouseKeepingRv1Binding
import com.example.smartcity.pojo.housekeeping.HPBannerData
import com.example.smartcity.pojo.housekeeping.HPLabelData
import com.example.smartcity.pojo.housekeeping.HPListData
import com.example.smartcity.utils.*
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import java.text.DecimalFormat
import kotlin.math.ceil

class HouseKeepingActivity : BaseActivity<ActivityHouseKeepingBinding>() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) initData()
        }
    private val rvs = mutableListOf<RecyclerView>()

    override fun initView() {
        setTitle("家政服务")
        bind.rv.layoutManager = LinearLayoutManager(c)
    }

    override fun initData() {
        if (c.isLogin { launcher.launch(Intent(c, LoginActivity::class.java)) }) {
            get<HPBannerData>("/system/carousel/list") {
                bind.banner.banner.apply {
                    indicator = CircleIndicator(c)
                    adapter = object : BannerImageAdapter<HPBannerData.RowsBean>(it.rows) {
                        override fun onBindView(
                            p0: BannerImageHolder?, p1: HPBannerData.RowsBean?, p2: Int, p3: Int
                        ) {
                            Glide.with(c).load(baseURL + p1?.picUrl).into(p0!!.imageView)
                            p0?.imageView.setOnClickListener {
                                start<HouseKeepingInfoActivity> { it.putExtra("data", p1?.id) }
                            }
                        }
                    }
                }
            }
            get<HPLabelData>("/system/menus/list") { label ->
                label.rows.apply { sortByDescending { it.id } }
                //计算出需要几个 RecyclerView ceil()向上取整
                val flag = if (c.isPad()) 10 else 8
                for (i in 0 until ceil(label.total / flag.toDouble()).toInt()) {
                    rvs.add(RecyclerView(c).apply {
                        overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                        layoutManager = GridLayoutManager(c, if (c.isPad()) 5 else 4)
                    })
                    val data =
                        label.rows.filterIndexed { id, _ -> id in (i * flag until (i + 1) * flag) }
                    loadLabelRv(rvs[i], data)
                }
                bind.vp.adapter = ViewPagerAdapter(rvs)

                get<HPListData>("/takeout/server/list") { list ->
                    //统计所有 服务类别 的 咨询总数
                    val labelSum = mutableListOf<List<String>>()
                    label.rows.forEach { i0 ->
                        //咨询总数
                        val cNum = list.rows.filter { i0.id == it.menusId }.sumBy { it.consultNum }
                        //现价总数
                        val n = list.rows.filter { i0.id == it.menusId }.sumBy { it.serverMoneyNew }
                        //原价总数
                        val o = list.rows.filter { i0.id == it.menusId }.sumBy { it.serverMoneyOld }
                        //写入集合
                        labelSum.add(listOf(i0.menuName, "$cNum", "$n", "$o"))
                    }

                    //咨询总数前5的数据
                    val top5 = labelSum.apply { sortByDescending { it[1].toInt() } }
                        .filterIndexed { index, _ -> index < 5 }
                    //图表数据加载
                    showChart(top5.map { it[0] }.toList(), barData(top5), lineData(top5))
                    bind.rv.adapter = object :
                        CommonAdapter<ItemHouseKeepingRv1Binding, HPListData.RowsBean>(list.rows.filterIndexed { index, _ -> index < 5 }) {
                        override fun bind(
                            holder: ItemHouseKeepingRv1Binding, data: HPListData.RowsBean
                        ) {
                            val flag = list.rows.indexOf(data) % 2 == 0
                            setImage(if (flag) holder.iv0 else holder.iv1, data?.picUrl)
                                .setText(holder.tv0, data.serverName)
                                .setText(holder.tv1, data.serverTitle)
                                .setText(holder.tv2, "所属 ${data.companyName} 公司")
                                .setText(holder.tv3, "${data.serverMoneyNew}")
                                .setClick(holder.cv) {
                                    start<HouseKeepingInfoActivity> { it.putExtra("data", data.id) }
                                }
                            holder.iv0.visibility = if (flag) View.VISIBLE else View.GONE
                            holder.iv1.visibility = if (!flag) View.VISIBLE else View.GONE
                        }
                    }
                }
            }
        }
    }

    //加载服务类别
    private fun loadLabelRv(rv: RecyclerView, list: List<HPLabelData.RowsBean>) {
        rv.adapter = object :
            CommonAdapter<ItemHouseKeepingRv0Binding, HPLabelData.RowsBean>(list) {
            override fun bind(holder: ItemHouseKeepingRv0Binding, data: HPLabelData.RowsBean) {
                setImage(holder.iv, data?.picUrl)
                    .setText(holder.tv, data.menuName)
                    .setClick(holder.ll) {
                        start<HouseKeepingListActivity> {
                            it.putExtra("data", "?menusId=${data.id}")
                        }
                    }
            }
        }
    }

    //初始化图标
    private fun initChart() {
        bind.chart.apply {
            legend.isEnabled = false
            description.isEnabled = false

            //绘制 柱状图 和 折线图
            drawOrder = arrayOf(CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE)

            //左 Y 轴
            axisLeft.apply {
                setDrawGridLines(true)
                axisMinimum = 0f
            }
            //右 Y 轴
            axisRight.apply {
                setDrawGridLines(false)
                axisMinimum = 0f
                axisMaximum = 1.2f
            }

            //底部 X 轴
            xAxis.apply {
                setDrawGridLines(true)
                position = XAxis.XAxisPosition.BOTTOM
                axisMinimum = -.5f
                axisMaximum = 5f
                labelCount = 5
                textSize = 13f
            }
            extraBottomOffset = 10f
        }
    }

    //折线图数据填充
    private fun lineData(top5: List<List<String>>): LineData {
        val lineEntry = mutableListOf<Entry>()
        top5.forEachIndexed { index, list ->
            val temp = list[2].toFloat() / list[3].toFloat()
            val data = DecimalFormat("0.00").format(temp).toFloat()
            lineEntry.add(Entry(index.toFloat(), data))
        }
        val lineDataSet = LineDataSet(lineEntry, null).apply {
            color = Color.BLACK
            lineWidth = 3f
            mode = LineDataSet.Mode.LINEAR
            circleRadius = 5f
            setDrawCircleHole(false)
            setCircleColor(Color.RED)
            setDrawValues(true)
            valueTextSize = 15f
            //设置折线图Y轴为右轴
            axisDependency = YAxis.AxisDependency.RIGHT
            valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return "${value}%"
                }
            }
        }
        return LineData(lineDataSet)
    }

    //柱状图数据填充
    private fun barData(top5: List<List<String>>): BarData {
        val barEntry = mutableListOf<BarEntry>()
        top5.forEachIndexed { index, list ->
            barEntry.add(BarEntry(index.toFloat(), list[1].toFloat()))
        }
        val barDataSet = BarDataSet(barEntry, null).apply {
            color = Color.YELLOW
            setDrawValues(true)
            valueTextSize = 15f
            axisDependency = YAxis.AxisDependency.LEFT
        }
        return BarData(barDataSet)
    }

    //渲染图表
    private fun showChart(xData: List<String>, barData: BarData, lineData: LineData) {
        initChart()
        //填充数据
        bind.chart.data = CombinedData().apply {
            setData(barData)
            setData(lineData)
        }

        //显示图表底部X轴数据
        bind.chart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return value.toInt().let {
                    if (it in xData.indices) xData[it] else ""
                }
            }
        }
        bind.chart.invalidate()
        bind.chart.notifyDataSetChanged()
    }

    override fun onClick() {
        bind.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val data = bind.etSearch.text.toString()
                if (data.isEmpty()) {
                    toast("请输入搜索内容")
                } else {
                    bind.etSearch.hide(c).text = null
                    start<HouseKeepingListActivity> { it.putExtra("data", "?serverName=${data}") }
                }
            }
            true
        }
        bind.btn.setOnClickListener { start<HouseKeepingListActivity> { } }
    }
}