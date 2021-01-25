package ru.nsu.fit.nsuvolleyball.ui.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.nsu.fit.nsuvolleyball.ui.games.GamesViewModel

class GamesViewModelFactory(private val tab: Int) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        GamesViewModel::class.java -> GamesViewModel(tab)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}
