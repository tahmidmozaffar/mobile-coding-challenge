package com.app.unsplashgallery.ui.imageGrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import com.app.unsplashgallery.util.CenterSmoothScroller
import com.app.unsplashgallery.ui.imageGrid.adapter.GalleryGridViewAdapter
import com.app.unsplashgallery.R
import com.app.unsplashgallery.databinding.FragmentGalleryBinding
import com.app.unsplashgallery.ui.MainActivity
import com.app.unsplashgallery.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class GalleryFragment : Fragment(R.layout.fragment_gallery), GalleryView {

    private val galleryViewModel: GalleryViewModel by viewModel()
    private var mainViewModel: MainViewModel? = null

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

        mainViewModel = (activity as MainActivity).viewModel

        binding.galleryGrid.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 4)
        }

        gridAdapter = GalleryGridViewAdapter(::itemClickAction)
        binding.galleryGrid.adapter = gridAdapter

        mainViewModel?.photosLiveData?.observe(viewLifecycleOwner, { images ->
            gridAdapter.submitList(images)
        })

        galleryViewModel.updateScrollState(mainViewModel?.selectedItem, this)
        mainViewModel?.selectedItem = null
    }

    private fun itemClickAction(position: Int) {
        (activity as MainActivity).viewModel.selectedItem = position
        findNavController().navigate(R.id.goToDetails)
    }

    override fun onPause() {
        super.onPause()
        (activity as MainActivity).viewModel.scrollState =
            binding.galleryGrid.layoutManager?.onSaveInstanceState()
    }

    override fun restoreScrollPosition() {
        mainViewModel?.scrollState?.let {
            binding.galleryGrid.layoutManager?.onRestoreInstanceState(it)
        }

    }

    override fun scrollToLastSelectedItem() {
        mainViewModel?.selectedItem?.let {
            binding.galleryGrid.postDelayed({
                val smoothScroller: SmoothScroller =
                    CenterSmoothScroller(binding.galleryGrid.context)
                smoothScroller.targetPosition = it
                binding.galleryGrid.layoutManager?.startSmoothScroll(smoothScroller)
            }, 500)
        }
    }
}