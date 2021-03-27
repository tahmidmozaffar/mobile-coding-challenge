package com.app.unsplashgallery.ui.imageDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.app.unsplashgallery.ui.imageDetail.adapter.ImageViewPagerAdapter
import com.app.unsplashgallery.R
import com.app.unsplashgallery.databinding.FragmentDetailBinding
import com.app.unsplashgallery.ui.MainActivity
import com.app.unsplashgallery.ui.MainViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewPagerAdapter: ImageViewPagerAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        println("Detail fragment onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = (activity as MainActivity).viewModel

        activity?.let {
            mainViewModel.photosLiveData.observe(
                viewLifecycleOwner,
                { images ->
                    viewPagerAdapter = ImageViewPagerAdapter(requireContext(), images)
                    binding.viewPager.adapter = viewPagerAdapter
                    mainViewModel?.selectedItem?.let {
                        binding.viewPager.currentItem = it
                    }

                })
        }


        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                mainViewModel.selectedItem = position
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })
    }
}