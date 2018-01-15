package com.kirra.hidestringcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var instance: String
        @JvmStatic lateinit var instance2: String
        lateinit var stringfromjava1: String
        lateinit var stringfromjava2: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        instance = "Passw0rdRahasi4_1"
        instance2 = "Passw0rdRahasi4_2"
        stringfromjava1 = Constant.data
        stringfromjava2 = String(Constant.databyte)


        Toast.makeText(this, stringfromjava2.toString(),Toast.LENGTH_SHORT).show()
    }
}
