package com.example.activities_tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class ImageDescription : AppCompatActivity() {
    private lateinit var image: Image
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_description)

        image = intent.getParcelableExtra("imageSelected") ?: Image()

        initViews()
    }

    private lateinit var imgBtnPrincipal: ImageButton
    private lateinit var txvDescripcion: TextView

    private fun initViews() {
        imgBtnPrincipal = findViewById(R.id.imgBtnPrincipal)
        txvDescripcion = findViewById(R.id.txvDescripcion)

        setImage()
        setDescription()

        imgBtnPrincipal.setOnClickListener {
            startActivity(Intent(this, TotalImage::class.java).apply {
                putExtra("imageResource", image.imagesource)
            })
        }

    }

    private fun setImage() {
        imgBtnPrincipal.setImageResource(image.imagesource)
    }

    private fun setDescription() {
        txvDescripcion.setText(image.description)
    }
}