package com.henrianthony.myloancalculator.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.henrianthony.myloancalculator.R
import com.henrianthony.myloancalculator.model.News

class NewsAdapter (
    private val newsList: List<News>,
    private val onDoubleClick: (News) -> Unit
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var lastClickTime = 0L

        fun bind(news: News) {
            val titulo = itemView.findViewById<TextView>(R.id.titulo)
            val resumo = itemView.findViewById<TextView>(R.id.resumo)

            titulo.text = news.title
            resumo.text = news.review

            itemView.setOnClickListener {
                val now = System.currentTimeMillis()
                if (now - lastClickTime < 800) {
                    // TODO check the time to double click
                    onDoubleClick(news)
                }
                lastClickTime = now
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount() = newsList.size
}