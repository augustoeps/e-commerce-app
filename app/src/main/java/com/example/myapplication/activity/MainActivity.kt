package com.example.myapplication.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.myapplication.R
import com.example.myapplication.SliderAdapter
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.databinding.ActivityIntroBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.SliderModel

class MainActivity : AppCompatActivity() {
    private val viewModel=MainViewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()

    }

    private fun initBanner() {
        binding.progressBarBanner.visibility= View.VISIBLE
        viewModel.banners.observe(this, Observer { items->

        })
    }
    private fun banners(images:List<SliderModel>){
        binding.viewpagerSlider.adapter=SliderAdapter(images,binding.viewpagerSlider)
        binding.viewpagerSlider.clipToPadding=false
        binding.viewpagerSlider.clipChildren=false
        binding.viewpagerSlider.offscreenPageLimit=3
        binding.viewpagerSlider.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
    }
}
