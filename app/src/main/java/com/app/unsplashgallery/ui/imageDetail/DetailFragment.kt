package com.app.unsplashgallery.ui.imageDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.app.unsplashgallery.R
import com.app.unsplashgallery.databinding.FragmentDetailBinding
import com.app.unsplashgallery.ui.SharedViewModel
import com.app.unsplashgallery.ui.imageDetail.adapter.ImageViewPagerAdapter
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewPagerAdapter: ImageViewPagerAdapter
    private val sharedViewModel: SharedViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            sharedViewModel.photosLiveData.observe(
                viewLifecycleOwner,
                { images ->
                    viewPagerAdapter = ImageViewPagerAdapter(requireContext(), images)
                    binding.viewPager.adapter = viewPagerAdapter
                    sharedViewModel.selectedItem?.let {
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
                sharedViewModel.selectedItem = position
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}