package com.app.unsplashgallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.unsplashgallery.databinding.FragmentDetailBinding
import com.app.unsplashgallery.databinding.FragmentGalleryBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position")

        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)

            viewModel.photosLiveData.observe(viewLifecycleOwner, { images ->
                val viewPagerAdapter = ImageViewPagerAdapter(requireContext(), images)
                binding.viewPager.adapter = viewPagerAdapter
                position?.let { binding.viewPager.currentItem = position }
            })
        }
    }
}