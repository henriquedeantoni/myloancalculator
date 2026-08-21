package com.henrianthony.myloancalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henrianthony.myloancalculator.data.MockNews
import com.henrianthony.myloancalculator.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonSimulateLoan = findViewById<Button>(R.id.button_simulateLoan)

        buttonSimulateLoan.setOnClickListener {
            val intent = Intent(this, SimulateLoanActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_news)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = NewsAdapter(MockNews.mockList){ news ->
            val intent = Intent(this, NewsDetailsActivity::class.java)
            intent.putExtra("titulo", news.title)
            intent.putExtra("resumo", news.review)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}