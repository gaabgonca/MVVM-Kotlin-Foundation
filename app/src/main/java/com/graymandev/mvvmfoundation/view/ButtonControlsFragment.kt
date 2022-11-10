package com.graymandev.mvvmfoundation.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.graymandev.mvvmfoundation.databinding.FragmentButtonControlsBinding

class ButtonControlsFragment : Fragment() {

    private var _binding : FragmentButtonControlsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ButtonControlsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentButtonControlsBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        binding.getDataButton.setOnClickListener{
            Toast.makeText(activity, "Getting data from server...", Toast.LENGTH_SHORT).show()
        }

        binding.wipeDataButton.setOnClickListener{
            Toast.makeText(activity, "Deleting data from db...", Toast.LENGTH_SHORT).show()
        }

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonControlsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}