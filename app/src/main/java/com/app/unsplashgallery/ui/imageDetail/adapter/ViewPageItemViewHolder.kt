package com.app.unsplashgallery.ui.imageDetail.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.app.unsplashgallery.R
import com.app.unsplashgallery.domain.model.UnsplashImage
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class ViewPageItemViewHolder(private val itemView: View) {

    private val imageView = itemView.findViewById<ImageView>(R.id.img_main)

    fun bind(image: UnsplashImage) {

        Glide.with(itemView.context)
            .load(Uri.parse(image.urls.small))
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
            )
            .into(imageView)
    }
}