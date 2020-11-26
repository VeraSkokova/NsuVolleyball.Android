package ru.nsu.fit.nsuvolleyball.ui.games

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.nsuvolleyball.R

class GamesAdapter() : RecyclerView.Adapter<GameViewHolder>() {
    private var games = listOf<GameView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size

    fun bindGames(newGames: List<GameView>) {
        games = newGames
        notifyDataSetChanged()
    }
}

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val teamsView = itemView.findViewById<TextView>(R.id.tv_teams)
    private val dateTimeView = itemView.findViewById<TextView>(R.id.tv_datetime)
    private val homeImage = itemView.findViewById<ImageView>(R.id.iv_home)

    fun bind(game: GameView) {
        teamsView.text = game.teams
        dateTimeView.text = game.date
        homeImage.apply {
            setImageResource(game.placeImage)
            imageTintList = ColorStateList.valueOf(Color.GRAY)
        }
    }
}