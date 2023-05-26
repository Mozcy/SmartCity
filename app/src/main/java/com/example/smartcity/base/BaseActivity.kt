package com.example.smartcity.base

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.example.smartcity.R
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {
    var dialog: ProgressDialog? = null
    val TAG = lazy { this::class.java.name }.value
    val c = lazy { this }.value

    lateinit var bind: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz = type.actualTypeArguments[0] as Class<*>
        val method = clazz.getDeclaredMethod("inflate", LayoutInflater::class.java)
        bind = method.invoke(null, layoutInflater) as V
        setContentView(bind.root)
        initView()
        initData()
        onClick()
    }

    abstract fun initView()
    abstract fun initData()
    abstract fun onClick()

    fun setTitle(data: String, flag: Boolean = true): Toolbar = findViewById<Toolbar>(R.id.toolbar).apply {
        getChildAt(0).visibility = if (flag) View.VISIBLE else View.GONE
        getChildAt(0).setOnClickListener { finish() }
        (getChildAt(1) as TextView).text = data
    }

    fun toast(msg: String?) =
        Toast.makeText(c, null, Toast.LENGTH_SHORT).also { it.setText(msg) }.show()

    fun loadingMsg(msg: String?) {
        dialog = ProgressDialog(c).apply {
            setCancelable(false)
            setMessage(msg)
            show()
        }
    }

    fun dismiss() = dialog?.dismiss()

    inline fun <reified T> start(set: (Intent) -> Unit) {
        val intent = Intent(c, T::class.java).apply(set)
        startActivity(intent)
    }
}