package com.example.activities_tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class ImageDescription : AppCompatActivity() {
    private lateinit var image: Image
    private var numberId: Int = 0
    private var favorite: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_description)

        image = intent.getParcelableExtra("imageSelected") ?: Image()
        numberId = intent.getIntExtra("numberSelected", 0)

        favorite = image.favorito

        initViews()
    }

    private lateinit var imgBtnPrincipal: ImageButton
    private lateinit var txvDescripcion: TextView
    private lateinit var imgBtnFavorite: ImageButton

    private fun initViews() {
        imgBtnPrincipal = findViewById(R.id.imgBtnPrincipal)
        txvDescripcion = findViewById(R.id.txvDescripcion)
        imgBtnFavorite = findViewById(R.id.imgBtnFavorites)

        setImage()
        setDescription()
        setFavorite()

        imgBtnPrincipal.setOnClickListener {
            startActivity(Intent(this, TotalImage::class.java).apply {
                putExtra("imageResource", image.imagesource)
            })
        }

        imgBtnFavorite.setOnClickListener {
            favorite = !favorite
            Image().changeFavorite(numberId, favorite)
            setFavorite()
        }


    }

    private fun setImage() {
        imgBtnPrincipal.setImageResource(image.imagesource)
    }

    private fun setDescription() {
        txvDescripcion.setText(image.description)
    }

    private fun setFavorite() {
        if (favorite) {
            imgBtnFavorite.setImageResource(R.drawable.ic_estrella)
        } else {
            imgBtnFavorite.setImageResource(R.drawable.ic_estrella_vacia)
        }
    }
}