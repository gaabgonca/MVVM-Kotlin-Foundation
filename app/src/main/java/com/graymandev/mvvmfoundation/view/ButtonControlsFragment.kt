package com.graymandev.mvvmfoundation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.databinding.FragmentButtonControlsBinding
import com.graymandev.mvvmfoundation.viewmodel.ButtonControlsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ButtonControlsFragment : BindingFragment<FragmentButtonControlsBinding>() {

    private val viewModel: ButtonControlsViewModel by activityViewModels()


    override fun init() {
        binding.addRecordButton.setOnClickListener{
            viewModel.recordNow {
                Toast.makeText(activity, "Time recorded", Toast.LENGTH_SHORT).show()
            }
        }

        binding.wipeDataButton.setOnClickListener{
            viewModel.deleteAllRecords {
                Toast.makeText(activity, "Deleted all records", Toast.LENGTH_SHORT).show()
            }
        }

        binding.getDataButton.setOnClickListener{
            viewModel.getAllRecords {
                Toast.makeText(activity, "Loaded records from database", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentButtonControlsBinding {
       return FragmentButtonControlsBinding.inflate(inflater,container,false)
    }

}

