package com.graymandev.mvvmfoundation.view.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.databinding.FragmentFeedBinding
import com.graymandev.mvvmfoundation.model.database.entities.TimeRecord
import com.graymandev.mvvmfoundation.viewmodel.ButtonControlsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : BindingFragment<FragmentFeedBinding>() {

    private val viewModel: ButtonControlsViewModel by activityViewModels()


    override fun init() {
        val adapter = FeedListAdapter(arrayListOf())
        binding.recyclerView.adapter = adapter
        viewModel.timeRecordsLiveData.observe(viewLifecycleOwner){ recordsList ->
           adapter.updateRecordsList(recordsList)
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFeedBinding {
       return FragmentFeedBinding.inflate(inflater,container,false)
    }
}