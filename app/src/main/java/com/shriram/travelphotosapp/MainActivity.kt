package com.shriram.travelphotosapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


class MainActivity : AppCompatActivity() {

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageButton>(R.id.prevBtn)
        val next = findViewById<ImageButton>(R.id.nextBtn)
        val text = findViewById<TextView>(R.id.displayName)
        val places = arrayOf(
            "Taj Mahal",
            "Place 2",
            "Place 3",
            "Red Fort",
            "Gold Temple",
            "Boating Place",
            "Buddha statue",
            "Place 8",
            "Place 9",
            "Boat"
        )
        val placeDetails = findViewById<TextView>(R.id.placeDetails)
        val details = arrayOf(
            getString(R.string.taj_Mahal),
            getString(R.string.place2),
            getString(R.string.place3),
            getString(R.string.place4),
            getString(R.string.place5),
            getString(R.string.place6),
            getString(R.string.place7),
            getString(R.string.place8),
            getString(R.string.place9),
            getString(R.string.place10)
        )


        var currentImg = 1
        lateinit var image: ImageView

        next.setOnClickListener {
            val currentImgName = "img$currentImg"
            val currentImgID = this.resources.getIdentifier(currentImgName, "id", packageName)
            image = findViewById(currentImgID)
            image.alpha = 0f

            currentImg += 1
            if (currentImg > 10) {
                currentImg = 1
            }

            val currentImgDisplay = "img$currentImg"
            val currentImgString =
                this.resources.getIdentifier(currentImgDisplay, "id", packageName)
            image = findViewById(currentImgString)
            image.alpha = 1f
            text.text = places[currentImg - 1]

            //  place details
            placeDetails.text = details[currentImg - 1]
        }

        prev.setOnClickListener {
            val currentImgName = "img$currentImg"
            val currentImgID = this.resources.getIdentifier(currentImgName, "id", packageName)
            image = findViewById(currentImgID)
            image.alpha = 0f

            currentImg -= 1
            if (currentImg < 1) {
                currentImg = 10
            }

            val currentImgDisplay = "img$currentImg"
            val currentImgString =
                this.resources.getIdentifier(currentImgDisplay, "id", packageName)
            image = findViewById(currentImgString)
            image.alpha = 1f
            text.text = places[currentImg - 1]

            //  place details
            placeDetails.text = details[currentImg - 1]
        }


        // Menu controls
        val settingsBtn = findViewById<Button>(R.id.settingsBtn)
        settingsBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))

        }

        // hide status bar
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars())
    }
}
