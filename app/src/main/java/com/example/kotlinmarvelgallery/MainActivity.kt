package com.example.kotlinmarvelgallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlinmarvelgallery.data.Doctor
import com.example.kotlinmarvelgallery.utils.bindToText
import com.example.kotlinmarvelgallery.utils.bindView

class MainActivity : AppCompatActivity(), MainView {

    override var name: String by bindToText(R.id.tv_text)

    private val tvText: TextView by bindView(R.id.tv_text)
    private val btnClick: Button by bindView(R.id.btn_click)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener {
            tvText.text = "Clicked"
            ParamsReceiverActivity.start(this, Doctor(1, "John Smith"), "Doc")
        }
    }
}
