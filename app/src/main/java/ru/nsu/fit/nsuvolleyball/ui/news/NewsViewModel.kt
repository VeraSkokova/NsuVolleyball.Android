package ru.nsu.fit.nsuvolleyball.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.nsuvolleyball.domain.NewsDataSource

class NewsViewModel : ViewModel() {
    private val _news = MutableLiveData<List<NewsView>>().apply {
        value = mutableListOf()
    }
    val news: LiveData<List<NewsView>> = _news

    fun getNews(): MutableLiveData<List<NewsView>> {
        return MutableLiveData<List<NewsView>>().apply {
            value = NewsDataSource.getNews().map { NewsMapper().toNewsView(it) }
        }
    }
}