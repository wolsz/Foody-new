package com.example.foody.ui.fragments.foodjoke

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.foody.R
import com.example.foody.databinding.FragmentFoodJokeBinding
import com.example.foody.databinding.FragmentRecipesBinding
import com.example.foody.viewmodels.MainViewModel

class FoodJokeFragment : Fragment() {

    private val mainViewModel by viewModels<MainViewModel> ()

    private var _binding: FragmentFoodJokeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFoodJokeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}