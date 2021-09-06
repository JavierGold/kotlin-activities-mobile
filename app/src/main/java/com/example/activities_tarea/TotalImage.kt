package com.example.activities_tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TotalImage : AppCompatActivity() {
    private var imageSource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total_image)
        imageSource = intent.getIntExtra("imageResource", R.drawable.ic_helicopter)


        initViews()

        imgTotal.setImageResource(imageSource)

    }

    private lateinit var imgTotal: ImageView

    private fun initViews() {
        imgTotal = findViewById(R.id.imgTotal)

    }
}