package com.example.tableview2

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tableview2.R

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private val images = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,R.drawable.image6, R.drawable.image7) // добавьте здесь свои изображения

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val randomImageId = images.random()
            imageView.setImageResource(randomImageId)

            // Рандомное изменение цвета кнопки
            val randomColor = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
            button.setBackgroundColor(randomColor)
        }
    }
}