package com.example.kotfisher

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        val textTitle = findViewById<TextView>(R.id.textTitle)
        val TVContent = findViewById<TextView>(R.id.TVContent)
        val imageViewFish = findViewById<ImageView>(R.id.imageViewFish)
        textTitle.text = intent.getStringExtra("title")
        TVContent.text = intent.getStringExtra("content")
        imageViewFish.setImageResource(intent.getIntExtra("image", R.drawable.marsh))
    }
}