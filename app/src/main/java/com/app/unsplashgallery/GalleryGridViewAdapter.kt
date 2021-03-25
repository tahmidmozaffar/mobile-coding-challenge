package com.app.unsplashgallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class GalleryGridViewAdapter(
    private val itemClickAction: (position: Int) -> Unit
) : PagedListAdapter<UnsplashImage, GalleryItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_grid_item, parent, false)
        return GalleryItemViewHolder(itemView, itemClickAction)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) =
        holder.bind(getItem(position)!!, position)

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<UnsplashImage>() {
            override fun areItemsTheSame(oldItem: UnsplashImage, newItem: UnsplashImage): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UnsplashImage,
                newItem: UnsplashImage
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}