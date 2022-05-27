package com.example.foody.ui.fragments.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foody.databinding.FragmentFavoriteRecipesBinding
import com.example.foody.databinding.FragmentRecipesBinding


class FavoriteRecipesFragment : Fragment() {

    private var _binding: FragmentFavoriteRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteRecipesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}