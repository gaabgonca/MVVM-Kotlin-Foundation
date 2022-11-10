package com.graymandev.mvvmfoundation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.navigation.NavigationBarView
import com.graymandev.mvvmfoundation.databinding.ActivityMainBinding
import com.graymandev.mvvmfoundation.view.navigation.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding

    private val onNavigationItemSelectedListener =
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_controls -> {
                    binding.viewPager.currentItem = 0
                    return@OnItemSelectedListener true
                }
                R.id.page_feed -> {
                    binding.viewPager.currentItem = 1
                    return@OnItemSelectedListener true
                }
                else -> {
                    false
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        //When clicking a tab, change the fragment to show
        binding.bottomNavigation.setOnItemSelectedListener(onNavigationItemSelectedListener)

        //When sliding from a page to another, update the bottom navigation
        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigation.menu.findItem(R.id.page_controls).isChecked = true
                    1 -> binding.bottomNavigation.menu.findItem(R.id.page_feed).isChecked = true
                }
            }
        })

        setContentView(view)
    }
}