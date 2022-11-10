package com.graymandev.mvvmfoundation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.databinding.FragmentFeedBinding
import com.graymandev.mvvmfoundation.viewmodel.ButtonControlsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : BindingFragment<FragmentFeedBinding>() {

    private val viewModel: ButtonControlsViewModel by viewModels()

    override fun init() {
        viewModel.timeRecordsLiveData.observe(viewLifecycleOwner){ recordsList ->
            binding.firstText.text = recordsList.getOrNull(0)?.dateTime ?: "NO DATA"
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFeedBinding {
       return FragmentFeedBinding.inflate(inflater,container,false)
    }
}