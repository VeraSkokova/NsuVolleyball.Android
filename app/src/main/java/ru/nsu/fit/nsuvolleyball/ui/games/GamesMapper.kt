package ru.nsu.fit.nsuvolleyball.ui.games

import android.content.Context
import ru.nsu.fit.nsuvolleyball.R
import ru.nsu.fit.nsuvolleyball.model.Game

class GamesMapper(val context: Context) {
    fun toGameView(game: Game): GameView {
        return GameView(
            context.getString(R.string.games_vs, game.firstTeam, game.secondTeam),
            game.date,
            when (game.isHome) {
                true -> R.drawable.ic_home_black_24dp
                false -> R.drawable.ic_car
            }
        )
    }
}