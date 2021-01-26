package ru.nsu.fit.nsuvolleyball.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.nsu.fit.nsuvolleyball.R

class GalleryAdapter(): RecyclerView.Adapter<GalleryViewHolder>() {
    private var gallery = listOf<GalleryView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(gallery[position])
    }

    override fun getItemCount(): Int = gallery.size

    fun updateGallery(newGallery: List<GalleryView>) {
        gallery = newGallery
        notifyDataSetChanged()
    }
}

class GalleryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val cover: ImageView = itemView.findViewById(R.id.iv_cover)

    fun bind(galleryView: GalleryView) {
        Glide.with(itemView.context)
            .load(galleryView.url)
            .apply(imageOption)
            .into(cover)
    }

    private val imageOption = RequestOptions()
        .placeholder(R.drawable.ic_baseline_photo_camera)
        .fallback(R.drawable.ic_baseline_photo_camera)
        .centerCrop()
}