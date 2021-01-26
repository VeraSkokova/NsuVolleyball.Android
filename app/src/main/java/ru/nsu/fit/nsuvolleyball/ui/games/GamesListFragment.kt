package ru.nsu.fit.nsuvolleyball.ui.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.nsuvolleyball.R
import ru.nsu.fit.nsuvolleyball.ui.utils.GamesViewModelFactory

class GamesListFragment : Fragment() {
    private lateinit var gamesViewModel: GamesViewModel

    private val gamesAdapter = GamesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_games_list, container, false)

        val tab = arguments?.getInt(TAB) ?: 0
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = gamesAdapter
        }
        gamesViewModel =
            ViewModelProvider(this, GamesViewModelFactory(tab)).get(GamesViewModel::class.java)
        gamesViewModel.liveData.observe(viewLifecycleOwner, Observer { resource ->
            if (resource != null) {
                resource.data?.let {
                    gamesAdapter.bindGames(it)
                } ?: run {
                    Toast.makeText(context, R.string.loading_error, Toast.LENGTH_SHORT).show()
                }
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