package com.henrianthony.myloancalculator.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailsActivity : androidx.appcompat.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_root_ide_package_.com.henrianthony.myloancalculator.R.layout.activity_news_details)

        val title = intent.getStringExtra("titulo")
        val review = intent.getStringExtra("resumo")

        val tituloView = findViewById<TextView>(_root_ide_package_.com.henrianthony.myloancalculator.R.id.tituloDetalhe)
        val resumoView = findViewById<TextView>(_root_ide_package_.com.henrianthony.myloancalculator.R.id.resumoDetalhe)

        tituloView.text = title
        resumoView.text = review
    }


}