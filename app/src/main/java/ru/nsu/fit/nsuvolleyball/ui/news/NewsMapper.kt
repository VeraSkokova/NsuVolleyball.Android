package ru.nsu.fit.nsuvolleyball.ui.news

import ru.nsu.fit.nsuvolleyball.model.News

class NewsMapper() {
    fun toNewsView(news: News): NewsView {
        return NewsView(news.title, news.date, news.shortDescription, news.fullDescription)
    }
}