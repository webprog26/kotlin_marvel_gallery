package com.example.kotlinmarvelgallery

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kotlinmarvelgallery.data.Doctor
import com.example.kotlinmarvelgallery.utils.extra
import com.example.kotlinmarvelgallery.utils.extraString
import com.example.kotlinmarvelgallery.utils.toast

class ParamsReceiverActivity: AppCompatActivity() {

    private val doctor by extra<Doctor>(DOCTOR_KEY)
    private val title by extraString(TITLE_KEY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.params_receiver_activity)
        toast("Doctor ${doctor.id} with name ${doctor.name}", Toast.LENGTH_SHORT)
        toast("Title $title", Toast.LENGTH_SHORT)
    }

    companion object {
        const val DOCTOR_KEY = "doctor_key"
        const val TITLE_KEY = "title_key"

        fun start(context: Context, doctor: Doctor, title: String) {
            context.startActivity(Intent(context, ParamsReceiverActivity::class.java).apply {
                putExtra(DOCTOR_KEY, doctor)
                putExtra(TITLE_KEY, title)
            })
        }
    }
}