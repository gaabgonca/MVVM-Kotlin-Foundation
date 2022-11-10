package com.graymandev.mvvmfoundation.view.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.graymandev.mvvmfoundation.view.ButtonControlsFragment
import com.graymandev.mvvmfoundation.view.feed.FeedFragment


class ViewPagerAdapter(appCompatActivity : AppCompatActivity) : FragmentStateAdapter(appCompatActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ButtonControlsFragment()
            1 -> FeedFragment()
            else -> ButtonControlsFragment()
        }
    }
}