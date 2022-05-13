package com.bristot.listinha.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bristot.listinha.R
import com.bristot.listinha.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private var binding: MainFragmentBinding? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSubscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun onSubscribe() {
        with(viewModel) {
            data.observe(this@MainFragment.viewLifecycleOwner) { data ->
                println(data)
                binding?.message?.text = data
            }
            onRandom()
        }
    }
}