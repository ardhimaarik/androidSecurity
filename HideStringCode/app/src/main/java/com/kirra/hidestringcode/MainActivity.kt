package com.kirra.hidestringcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var instance: String
        @JvmStatic lateinit var instance2: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instance = "Passw0rdRahasi4_1"
        instance2 = "Passw0rdRahasi4_2"
    }
}
