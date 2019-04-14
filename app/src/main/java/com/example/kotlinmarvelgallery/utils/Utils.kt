package com.example.kotlinmarvelgallery.utils

import android.app.Activity
import android.content.Context
import android.os.Parcelable
import android.view.View
import android.widget.Toast

fun <T : View> Activity.bindView(viewId: Int) = lazy { findViewById(viewId) as T }

fun <T : Parcelable> Activity.extra(key: String) = lazy { intent.extras.getParcelable<T>(key) }

fun Activity.extraString(key: String) = lazy { intent.extras.getString(key) }

fun Context.toast(message: String, length: Int) {
    Toast.makeText(this, message, length).show()
}