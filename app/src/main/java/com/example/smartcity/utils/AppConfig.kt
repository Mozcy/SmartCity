package com.example.smartcity.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.bumptech.glide.request.RequestOptions

/**
 * 键盘输入后隐藏键盘
 */
fun EditText.hide(c: Context): EditText {
    val imm = c.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
    clearFocus()
    return this
}

/**
 * 拓展方法方便藏和显示控件
 */
fun TextView.show(flag: Boolean): TextView {
    visibility = if (flag) View.VISIBLE else View.GONE
    return this
}

/**
 * 判断是否平板
 */
fun Context.isPad(): Boolean {
    val s = resources.configuration.screenLayout
    val m = Configuration.SCREENLAYOUT_SIZE_MASK
    val l = Configuration.SCREENLAYOUT_SIZE_LARGE
    return (s and m) >= l
}

/**
 * 进入需要token的功能模块前判断是否登陆
 */
fun Context.isLogin(click: () -> Unit): Boolean {
    if (token.isEmpty()) {
        AlertDialog.Builder(this)
            .setTitle("提示")
            .setMessage("请登录后再试")
            .setCancelable(true)
            .setPositiveButton("登陆") { _, _ ->
                click()
            }.show()
        return false
    }
    return true
}

/**
 * 动态权限申请
 */
fun Activity.permission(): Boolean {
    val arr = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    arr.forEach {
        if (checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arr, 2)
            return false
        }
    }
    return true
}

class AppConfig : Application() {

    companion object {
        val circle = RequestOptions.circleCropTransform()
    }
}