package com.example.smartcity

import android.util.SparseArray
import androidx.core.util.forEach
import androidx.fragment.app.Fragment
import com.example.smartcity.base.BaseActivity
import com.example.smartcity.databinding.ActivityMainBinding
import com.example.smartcity.fragment.*

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val sp = SparseArray<Fragment>()
    private lateinit var current: Fragment
    override fun initView() {
        sp.put(R.id.main_nav1, MainFragmentNav1())
        sp.put(R.id.main_nav2, MainFragmentNav2())
        sp.put(R.id.main_nav3, MainFragmentNav3())
        sp.put(R.id.main_nav4, MainFragmentNav4())
        sp.put(R.id.main_nav5, MainFragmentNav5())
        current = sp.valueAt(0)
    }

    override fun initData() {
        supportFragmentManager.beginTransaction().apply {
            sp.forEach { _, value ->
                add(R.id.fl, value)
                if (current != value) {
                    hide(value)
                }
            }
        }.commit()
    }

    override fun onClick() {
        // 点击底部导航栏切换到对应的页面
        bind.nav.setOnNavigationItemSelectedListener {
            sp[it.itemId].let {
                if (current != it) {
                    supportFragmentManager.beginTransaction().show(it).hide(current).commit()
                    current = it
                }
            }
            true
        }
    }

}