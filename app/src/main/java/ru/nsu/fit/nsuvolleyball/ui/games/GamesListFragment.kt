package ru.nsu.fit.nsuvolleyball.ui.games

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

class GamesListFragment: Fragment() {
    private lateinit var gamesViewModel: GamesViewModel

    private val gamesAdapter = GamesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_games_list, container, false)

        gamesViewModel = ViewModelProvider(this).get(GamesViewModel::class.java)
        val tab = arguments?.getInt(TAB) ?: 0
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = gamesAdapter
        }
        gamesViewModel.getGames(tab).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                gamesAdapter.bindGames(it)
            }
        })

        return view
    }

    companion object {
        const val TAB = "tab"

        fun newInstance(tab: Int): GamesListFragment {
            val fragment = GamesListFragment()
            val args = Bundle()
            args.putInt(TAB, tab)
            fragment.arguments = args
            return fragment
        }
    }
}