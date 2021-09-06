package com.example.activities_tarea

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Image (
    var imagesource: Int = R.drawable.ic_car,
    var description: String = "",
    var favorito: Boolean = false
): Parcelable {
    companion object {
        val images = arrayOf(
            Image(R.drawable.bird, "es un pajaro", false),
            Image(R.drawable.cat, "es un gato", false),
            Image(R.drawable.dog, "es un perro", false),
            Image(R.drawable.fox, "es un zorro", false),
            Image(R.drawable.ic_car, "es un carro", false),
            Image(R.drawable.ic_desktop, "es un escritorio", false),
            Image(R.drawable.ic_headphones, "son audifonos", false),
            Image(R.drawable.ic_helicopter, "es un helicopetero", false),
            Image(R.drawable.ic_raqueta, "es una raqueta", false),
            Image(R.drawable.snake, "es una serpiente", false),

            )
    }

    fun getAllImages() = images
}