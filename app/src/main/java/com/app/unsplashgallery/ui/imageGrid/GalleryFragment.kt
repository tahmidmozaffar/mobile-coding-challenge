package com.app.unsplashgallery.ui.imageGrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import com.app.unsplashgallery.R
import com.app.unsplashgallery.databinding.FragmentGalleryBinding
import com.app.unsplashgallery.domain.repository.UnsplashRepository
import com.app.unsplashgallery.ui.SharedViewModel
import com.app.unsplashgallery.ui.imageGrid.adapter.GalleryGridViewAdapter
import com.app.unsplashgallery.util.CenterSmoothScroller
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.parameter.parametersOf


@KoinApiExtension
class GalleryFragment : Fragment(R.layout.fragment_gallery), GalleryView {

    private val galleryViewModel: GalleryViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by inject { parametersOf(get<UnsplashRepository>()) }

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

        binding.galleryGrid.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 4)
        }

        gridAdapter = GalleryGridViewAdapter(::itemClickAction)
        binding.galleryGrid.adapter = gridAdapter

        sharedViewModel.photosLiveData.observe(viewLifecycleOwner, { images ->
            gridAdapter.submitList(images)
        })

        galleryViewModel.updateScrollState(sharedViewModel.selectedItem, this)

        //we need to clear last selected item to maintain scroll position
        // after screen rotation and random scroll changes
        sharedViewModel.selectedItem = null
    }

    private fun itemClickAction(position: Int) {
        sharedViewModel.selectedItem = position
        findNavController().navigate(R.id.goToDetails)
    }

    override fun onPause() {
        super.onPause()
        sharedViewModel.scrollState =
            binding.galleryGrid.layoutManager?.onSaveInstanceState()
    }

    override fun restoreScrollPosition() {
        sharedViewModel.scrollState?.let {
            binding.galleryGrid.layoutManager?.onRestoreInstanceState(it)
        }

    }

    override fun scrollToLastSelectedItem() {
        sharedViewModel.selectedItem?.let {
            binding.galleryGrid.postDelayed({
                val smoothScroller: SmoothScroller =
                    CenterSmoothScroller(binding.galleryGrid.context)
                smoothScroller.targetPosition = it
                binding.galleryGrid.layoutManager?.startSmoothScroll(smoothScroller)
            }, 500)
        }
    }
}