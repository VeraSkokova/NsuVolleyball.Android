package ru.nsu.fit.nsuvolleyball.ui.games

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.nsu.fit.nsuvolleyball.domain.GamesDataSource

class GamesViewModel(application: Application) : AndroidViewModel(application) {
    fun getGames(tab: Int): MutableLiveData<List<GameView>> {
        return MutableLiveData<List<GameView>>().apply {
            value = when (tab) {
                0 -> GamesDataSource.getFutureGames()
                    .map { GamesMapper(getApplication()).toGameView(it) }
                1 -> GamesDataSource.getPastGames()
                    .map { GamesMapper(getApplication()).toGameView(it) }
                else -> emptyList()
            }
        }
    }
}