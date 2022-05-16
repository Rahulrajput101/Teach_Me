package com.example.androd.teachme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androd.teachme.databinding.FragmentDictionaryBinding
import com.example.androd.teachme.databinding.FragmentMainBinding
import com.example.androd.teachme.viewModel.DictionaryViewModel


class DictionaryFragment : Fragment() {

    private lateinit var binding: FragmentDictionaryBinding
    private lateinit var viewModel: DictionaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(DictionaryViewModel::class.java)

        viewModel.getDictionaryWords()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}