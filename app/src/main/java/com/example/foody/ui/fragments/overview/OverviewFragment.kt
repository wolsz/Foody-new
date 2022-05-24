package com.example.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.foody.R
import com.example.foody.databinding.FragmentOverviewBinding
import com.example.foody.models.Result


class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOverviewBinding.inflate(layoutInflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        myBundle?.let {
            binding.mainImageView.load(it.image)
            binding.overviewTitleTextView.text = it.title
            binding.likesTextView.text = it.aggregateLikes.toString()
            binding.timeTextView.text = it.readyInMinutes.toString()
            binding.summaryTextView.text = it.summary

            if (it.vegetarian) {
                binding.vegetarianImageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                binding.vegetarianTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (it.vegan) {
                binding.veganImageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                binding.veganTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (it.glutenFree) {
                binding.glutenFreeImageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                binding.glutenFreeTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (it.dairyFree) {
                binding.dairyFreeImageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                binding.dairyFreeTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (it.veryHealthy) {
                binding.healthyImageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                binding.healthyTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (it.cheap) {
                binding.cheapImageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                binding.cheapTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }


        }
        binding.mainImageView.load(myBundle?.image)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}