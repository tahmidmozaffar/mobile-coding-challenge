package com.app.unsplashgallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.app.unsplashgallery.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private lateinit var binding: FragmentGalleryBinding
    private val viewModel: GalleryViewModel by viewModels()

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
        viewModel.photosLiveData.observe(viewLifecycleOwner, {
            binding.galleryGrid.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 4)
                adapter = GalleryGridViewAdapter(it, ::itemClickAction)
            }
        })

        viewModel.loadImages()

    }

    private fun itemClickAction(position: Int) {
        val bundle = bundleOf("position" to position)
        findNavController().navigate(R.id.goToDetails, bundle)
    }
}