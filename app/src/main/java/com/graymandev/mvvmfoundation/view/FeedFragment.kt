package com.graymandev.mvvmfoundation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.R
import com.graymandev.mvvmfoundation.databinding.FragmentButtonControlsBinding
import com.graymandev.mvvmfoundation.databinding.FragmentFeedBinding

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