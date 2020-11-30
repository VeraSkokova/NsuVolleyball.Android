package ru.nsu.fit.nsuvolleyball.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.nsuvolleyball.R

class NewsAdapter(private val newsClickListener: NewsFragment.OnNewsClickListener?) :
    RecyclerView.Adapter<NewsViewHolder>() {
    private var news = listOf<NewsView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
        holder.itemView.setOnClickListener { newsClickListener?.onNewsClick(position) }
    }

    override fun getItemCount(): Int = news.size

    fun updateNews(news: List<NewsView>) {
        this.news = news
        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById<TextView>(R.id.tv_title)
    private val date = itemView.findViewById<TextView>(R.id.tv_date)
    private val description = itemView.findViewById<TextView>(R.id.tv_description)

    fun bind(news: NewsView) {
        title.text = news.title
        date.text = news.date
        description.text = news.shortDescription
    }
}