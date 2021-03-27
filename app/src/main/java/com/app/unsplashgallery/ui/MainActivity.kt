package com.app.unsplashgallery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.unsplashgallery.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}