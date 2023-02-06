package com.io.muhsin.zaakir.ui.results

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.io.muhsin.zaakir.R
import com.io.muhsin.zaakir.databinding.FragmentResultBinding
import com.io.muhsin.zaakir.models.Learning


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
    }

    private fun getData() {
        val learning = arguments?.getSerializable("learning") as Learning
        Log.e("ololo", "onViewCreated: $learning")
        binding.tvTitle.text= learning.title
        binding.tvSubtitle.text = learning.text
    }


}