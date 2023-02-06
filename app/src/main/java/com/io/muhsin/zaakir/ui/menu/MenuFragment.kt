package com.io.muhsin.zaakir.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.io.muhsin.zaakir.R
import com.io.muhsin.zaakir.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    //private val viewModel by viewModels<MenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation()
    }

    private fun navigation() {
        binding.tvReference.setOnClickListener {
            findNavController().navigate(R.id.referenceFragment)
        }
    }


}