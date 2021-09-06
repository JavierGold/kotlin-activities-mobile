package com.example.activities_tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var counter = 1
    private lateinit var image: Image



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = Image()
        counter = 0
        initViews()

    }
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var btnAccept: Button
    private lateinit var imvIcon: ImageView

    private lateinit var imagesArray: Array<Image>


    private fun initViews() {
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        btnAccept = findViewById(R.id.btnAccept)
        imvIcon = findViewById(R.id.imvIcon)

        imagesArray = image.getAllImages()


        setImageResource()
        setButtonFunctionality()
    }

    private fun setButtonFunctionality() {
        btnLeft.setOnClickListener {
            if (counter == 0) {
                counter = imagesArray.size - 1
            } else {
                counter --
            }
            setImageResource()
        }

        btnRight.setOnClickListener {
            if (counter == imagesArray.size - 1) {
                counter = 0
            } else {
                counter ++
            }
            setImageResource()
        }

        btnAccept.setOnClickListener {
            startActivity(Intent(this, ImageDescription::class.java).apply {
                putExtra("imageSelected", imagesArray[counter])
            })
        }
    }

    private fun setImageResource() {
        imvIcon.setImageResource(imagesArray[counter].imagesource)
    }


}