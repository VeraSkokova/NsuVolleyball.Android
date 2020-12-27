package ru.nsu.fit.nsuvolleyball.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.nsu.fit.nsuvolleyball.R

class NewsDetailsFragment : Fragment() {
    private lateinit var newsViewModel: NewsViewModel

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_details, container, false)

        title = view.findViewById(R.id.tv_title)
        description = view.findViewById(R.id.tv_description)
        image = view.findViewById(R.id.iv_picture)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)

        newsViewModel.getNews().observe(viewLifecycleOwner, Observer {
            val id = arguments?.getInt(ID_KEY) ?: 0
            val news = it[id]

            title.text = news.title
            description.text = news.longDescription
        })
    }

    companion object {
        private const val ID_KEY = "newsId"
    }
}