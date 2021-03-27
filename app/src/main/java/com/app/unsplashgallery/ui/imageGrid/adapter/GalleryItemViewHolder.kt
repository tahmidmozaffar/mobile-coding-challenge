package com.app.unsplashgallery.ui.imageGrid.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app.unsplashgallery.R
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class GalleryItemViewHolder(
    itemView: View,
    private val onClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val imgView = itemView.findViewById<ImageView>(R.id.gridItemImg)

    fun bind(image: UnsplashImage, position: Int) {

        Glide.with(itemView.context)
            .load(Uri.parse(image.urls.thumb))
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
            )
            .into(imgView)
        itemView.setOnClickListener { onClick(position) }
    }
}