package com.graymandev.mvvmfoundation.view

import androidx.lifecycle.ViewModelProvider
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.databinding.FragmentButtonControlsBinding
import com.graymandev.mvvmfoundation.viewmodel.ButtonControlsViewModel

class ButtonControlsFragment : BindingFragment<FragmentButtonControlsBinding>() {

    private lateinit var viewModel: ButtonControlsViewModel


    override fun init() {
        viewModel = ViewModelProvider(this).get(ButtonControlsViewModel::class.java)
        binding.getDataButton.setOnClickListener{
            Toast.makeText(activity, "Getting data from server...", Toast.LENGTH_SHORT).show()
            viewModel.printText("ViewModel works ")
        }

        binding.wipeDataButton.setOnClickListener{
            Toast.makeText(activity, "Deleting data from db...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentButtonControlsBinding {
       return FragmentButtonControlsBinding.inflate(inflater,container,false)
    }

}

