package ru.nsu.fit.nsuvolleyball.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.nsu.fit.nsuvolleyball.R

class MoreFragment: Fragment() {
    private lateinit var viewModel: MoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_more, container, false)
        return view
    }
}