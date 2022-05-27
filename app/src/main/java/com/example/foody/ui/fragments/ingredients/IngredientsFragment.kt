package com.example.foody.ui.fragments.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foody.adapters.IngredientsAdapter
import com.example.foody.databinding.FragmentIngredientsBinding
import com.example.foody.models.Result
import com.example.foody.util.Constants.Companion.RECIPES_RESULT_KEY

class IngredientsFragment : Fragment() {

    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }

    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPES_RESULT_KEY)

        setupRecyclerView(binding.root)
        myBundle?.extendedIngredients.let { mAdapter.submitList(it) }

        return binding.root
    }

    private fun setupRecyclerView(view: View) {
        binding.ingredientsRecyclerview.adapter = mAdapter
        binding.ingredientsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}