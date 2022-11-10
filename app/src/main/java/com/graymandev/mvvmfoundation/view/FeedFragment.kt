package com.graymandev.mvvmfoundation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.graymandev.mvvmfoundation.R
import com.graymandev.mvvmfoundation.databinding.FragmentButtonControlsBinding
import com.graymandev.mvvmfoundation.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private var _binding : FragmentFeedBinding? = null
    private val binding get() : FragmentFeedBinding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}