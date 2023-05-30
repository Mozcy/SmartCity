package com.example.smartcity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.smartcity.utils.baseURL
import java.lang.reflect.ParameterizedType

abstract class CommonAdapter<V : ViewBinding, T>(private val data: List<T>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz = type.actualTypeArguments[0] as Class<*>
        val method = clazz.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java
        )
        val bind = method.invoke(null, LayoutInflater.from(parent.context), parent, false) as V
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bind(holder.bind as V, data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    abstract fun bind(holder: V, data: T)

    fun setText(textView: TextView, data: String?): CommonAdapter<V, T> {
        textView.text = data
        return this
    }

    fun <I> setImage(imageView: ImageView, data: I?): CommonAdapter<V, T> {
        Glide.with(imageView.context).load(if (data is String) baseURL + data else data)
            .into(imageView)
        return this
    }

    fun setClick(view: View, click: () -> Unit): CommonAdapter<V, T> {
        view.setOnClickListener { click() }
        return this
    }
}