package ru.nsu.fit.nsuvolleyball.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.nsuvolleyball.R

class GalleryFragment: Fragment() {
    private lateinit var galleryViewModel: GalleryViewModel

    private val galleryAdapter = GalleryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_gallery, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            adapter = galleryAdapter
        }
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        galleryViewModel.liveData.observe(viewLifecycleOwner, { resource ->
            if (resource != null) {
                resource.data?.let {
                    galleryAdapter.updateGallery(it)
                } ?: run {
                    Toast.makeText(context, R.string.loading_error, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}