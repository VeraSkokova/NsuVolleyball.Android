package ru.nsu.fit.nsuvolleyball.domain

import ru.nsu.fit.nsuvolleyball.model.Game

class GamesDataSource {
    fun getFutureGames(): List<Game> {
        return listOf(
            Game(0, "НГУ", "НГТУ", "16 февраля 18:45", false),
            Game(1, "НГУ-Корсар", "НГАУ", "14 февраля 18:00", true),
            Game(2, "НГУ", "Авангард", "9 февраля 20:00", true),
            Game(3, "НГУ", "НГТУ", "21 января 20:00", false),
            Game(4, "НГУ", "НГТУ", "15 января 19:00", true),
        )
    }

    fun getPastGames(): List<Game> {
        return listOf(
            Game(0, "НГУ", "НГТУ", "16 ноября 18:45", true),
            Game(1, "НГУ-Корсар", "НГАУ", "14 ноября 18:00", false),
            Game(2, "НГУ", "Авангард", "9 ноября 20:00", false),
            Game(3, "НГУ", "НГТУ", "21 октября 20:00", true),
            Game(4, "НГУ", "НГТУ", "15 октября 19:00", false),
        )
    }
}