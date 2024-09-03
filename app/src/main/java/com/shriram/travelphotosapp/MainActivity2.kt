package com.shriram.travelphotosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Xml
import android.widget.Button
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val homeBtn = findViewById<Button>(R.id.homeBtn)
        homeBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        // hide status bar
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars())

        //close app button

        val closeBtn = findViewById<Button>(R.id.closeBtn)
        closeBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            this.finish()
        }
    }
}