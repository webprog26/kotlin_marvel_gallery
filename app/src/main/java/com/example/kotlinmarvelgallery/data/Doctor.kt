package com.example.kotlinmarvelgallery.data

import android.os.Parcel
import android.os.Parcelable

data class Doctor(var id: Int, var name: String): Parcelable {

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Doctor> {
            override fun createFromParcel(source: Parcel?) = Doctor(source!!)

            override fun newArray(size: Int): Array<Doctor?> = arrayOfNulls(size)
        }
    }

    private constructor(source: Parcel): this (
        id = source.readInt(),
        name = source.readString()!!)

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(id)
        dest?.writeString(name)

    }

    override fun describeContents(): Int = 0
}