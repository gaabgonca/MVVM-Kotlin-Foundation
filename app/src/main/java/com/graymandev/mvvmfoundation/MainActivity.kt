package com.graymandev.mvvmfoundation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.chetantuteja.easybinding.BindingActivity
import com.google.android.material.navigation.NavigationBarView
import com.graymandev.mvvmfoundation.databinding.ActivityMainBinding
import com.graymandev.mvvmfoundation.view.navigation.ViewPagerAdapter

class MainActivity : BindingActivity<ActivityMainBinding>() {

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

    private val onPageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when (position) {
                0 -> binding.bottomNavigation.menu.findItem(R.id.page_controls).isChecked = true
                1 -> binding.bottomNavigation.menu.findItem(R.id.page_feed).isChecked = true
            }
        }
    }

    //This is called after onCreate, so binding is not null and can be safely used
    override fun init() {
        //Create an adapter
        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        //When clicking a tab, change the fragment to show
        binding.bottomNavigation.setOnItemSelectedListener(onNavigationItemSelectedListener)

        //When sliding from a page to another, update the bottom navigation
        binding.viewPager.registerOnPageChangeCallback(onPageChangeCallback)
    }

    //This happens inside onCreate
    override fun setupViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater);
    }

}