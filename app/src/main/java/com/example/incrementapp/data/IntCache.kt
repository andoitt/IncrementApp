package com.example.incrementapp.data

import android.content.Context
import com.example.incrementapp.R

interface IntCache {

    fun save(value: Int, key: String)

    fun read(key: String, default: Int): Int

    class Base(context: Context) : IntCache {

        private val sharedPreferences = context.getSharedPreferences(
            context.getString(R.string.app_name), Context.MODE_PRIVATE
        )

        override fun save(value: Int, key: String) {
            sharedPreferences.edit()
                .putInt(key,value)
                .apply()
        }

        override fun read(key: String, default: Int): Int {
            return sharedPreferences.getInt(key,default)
        }
    }
}