package com.henrianthony.myloancalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val title = intent.getStringExtra("titulo")
        val review = intent.getStringExtra("resumo")

        val tituloView = findViewById<TextView>(R.id.tituloDetalhe)
        val resumoView = findViewById<TextView>(R.id.resumoDetalhe)

        tituloView.text = title
        resumoView.text = review
    }


}