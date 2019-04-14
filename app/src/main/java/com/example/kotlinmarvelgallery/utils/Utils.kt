package com.example.kotlinmarvelgallery.utils

import android.app.Activity
import android.content.Context
import android.os.Parcelable
import android.support.annotation.IdRes
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T : View> Activity.bindView(viewId: Int) = lazy { findViewById(viewId) as T }

fun <T : Parcelable> Activity.extra(key: String) = lazy { intent.extras.getParcelable<T>(key) }

fun Activity.extraString(key: String) = lazy { intent.extras.getString(key) }

fun Context.toast(message: String, length: Int) {
    Toast.makeText(this, message, length).show()
}

fun Activity.bindToText(
    @IdRes viewId: Int) = object :
    ReadWriteProperty<Any?, String> {
    val textView by lazy { findViewById<TextView>(viewId) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return textView.text.toString()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        textView.text = value
    }
}