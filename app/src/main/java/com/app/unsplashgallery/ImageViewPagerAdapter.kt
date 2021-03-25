package com.app.unsplashgallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class ImageViewPagerAdapter(
    private val context: Context,
    private val images: List<UnsplashImage>,
) : PagerAdapter() {
    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.viewpage_item, container, false)
        val image = images[position]

        val viewHolder = ViewPageItemViewHolder(itemView)
        viewHolder.bind(image, position)

        container.addView(itemView)

        return itemView
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}