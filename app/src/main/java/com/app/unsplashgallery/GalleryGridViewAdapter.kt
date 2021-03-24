package com.app.unsplashgallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GalleryGridViewAdapter(
    private val images: List<UnsplashImage>,
    private val itemClickAction: (position: Int) -> Unit
) : RecyclerView.Adapter<GalleryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_grid_item, parent, false)
        return GalleryItemViewHolder(itemView, itemClickAction)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) =
        holder.bind(images[position], position)

    override fun getItemCount(): Int = images.size
}