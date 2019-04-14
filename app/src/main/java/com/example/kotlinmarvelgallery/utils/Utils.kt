package com.example.kotlinmarvelgallery.utils

import android.app.Activity
import android.view.View

fun <T: View> Activity.bindView(viewId: Int) = lazy { findViewById(viewId) as T }