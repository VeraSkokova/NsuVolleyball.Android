package ru.nsu.fit.nsuvolleyball.ui.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.nsuvolleyball.R

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel

    private var newsClickListener: OnNewsClickListener? = null
    private var newsAdapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news, container, false)

        newsAdapter = NewsAdapter(newsClickListener)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
            addItemDecoration(
                NewsItemDecoration(
                    requireContext().resources.getDimension(R.dimen.news_card_margin).toInt()
                )
            )
        }

        newsViewModel.getNews().observe(viewLifecycleOwner, Observer {
            newsAdapter?.updateNews(it)
        })
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        newsClickListener = activity as OnNewsClickListener
    }

    override fun onDetach() {
        newsClickListener = null
        super.onDetach()
    }

    interface OnNewsClickListener {
        fun onNewsClick(id: Int)
    }
}