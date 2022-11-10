package com.graymandev.mvvmfoundation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.databinding.FragmentFeedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : BindingFragment<FragmentFeedBinding>() {

    override fun init() {

    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFeedBinding {
       return FragmentFeedBinding.inflate(inflater,container,false)
    }
}