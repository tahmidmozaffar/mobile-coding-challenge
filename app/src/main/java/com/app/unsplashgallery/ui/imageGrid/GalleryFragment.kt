package com.app.unsplashgallery.ui.imageGrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import com.app.unsplashgallery.util.CenterSmoothScroller
import com.app.unsplashgallery.ui.imageGrid.adapter.GalleryGridViewAdapter
import com.app.unsplashgallery.R
import com.app.unsplashgallery.databinding.FragmentGalleryBinding
import com.app.unsplashgallery.ui.MainActivity


class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private lateinit var binding: FragmentGalleryBinding
    private lateinit var gridAdapter: GalleryGridViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewModel = (activity as MainActivity).viewModel

        binding.galleryGrid.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 4)
        }

        gridAdapter = GalleryGridViewAdapter(::itemClickAction)
        binding.galleryGrid.adapter = gridAdapter

        viewModel.photosLiveData.observe(viewLifecycleOwner, { images ->
            gridAdapter.submitList(images)
        })

        binding.galleryGrid.postDelayed({
            val smoothScroller: SmoothScroller = CenterSmoothScroller(binding.galleryGrid.context)
            smoothScroller.targetPosition = viewModel.selectedItem
            binding.galleryGrid.layoutManager?.startSmoothScroll(smoothScroller)
        }, 500)
    }

    private fun itemClickAction(position: Int) {
        val bundle = bundleOf("position" to position)
        findNavController().navigate(R.id.goToDetails, bundle)
        (activity as MainActivity).viewModel.selectedItem = position
    }
}