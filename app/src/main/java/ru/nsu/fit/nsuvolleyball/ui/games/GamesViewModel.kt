package ru.nsu.fit.nsuvolleyball.ui.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.nsu.fit.nsuvolleyball.NsuVolleyballApplication
import ru.nsu.fit.nsuvolleyball.data.api.ApiUtils
import ru.nsu.fit.nsuvolleyball.data.network.Resource
import ru.nsu.fit.nsuvolleyball.model.Game

class GamesViewModel(private val tab: Int) : ViewModel() {
    private val mutableLiveData = MutableLiveData<Resource<List<GameView>>>()
    val liveData: LiveData<Resource<List<GameView>>> get() = mutableLiveData

    var disposable: Disposable? = null

    init {
        disposable = ApiUtils.nsuVolleyballApi
            .getGames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    lateinit var games: List<Game>
                    if (tab == 0) {
                        games = response.past
                    } else {
                        games = response.future
                    }
                    mutableLiveData.value = Resource.Success(games
                        .map {
                            GamesMapper(NsuVolleyballApplication.context).toGameView(it)
                        })
                },
                { throwable ->
                    mutableLiveData.value = Resource.Error(throwable.message ?: "Error")
                })
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}