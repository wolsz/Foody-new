package com.example.foody.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.example.foody.R
import com.example.foody.bindingadapters.RecipesRowBinding
import com.example.foody.databinding.FragmentOverviewBinding
import com.example.foody.models.Result
import com.example.foody.util.Constants.Companion.RECIPES_RESULT_KEY
import org.jsoup.Jsoup


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
        val myBundle: Result? = args?.getParcelable(RECIPES_RESULT_KEY)

        myBundle?.let {
            binding.mainImageView.load(it.image)
            binding.overviewTitleTextView.text = it.title
            binding.likesTextView.text = it.aggregateLikes.toString()
            binding.timeTextView.text = it.readyInMinutes.toString()
            RecipesRowBinding.parseHtml(binding.summaryTextView, it.summary)
//            binding.summaryTextView.text = it.summary?.let { it1 -> Jsoup.parse(it1).text() }

            updateColors(it.vegetarian, binding.vegetarianTextView, binding.vegetarianImageView)
            updateColors(it.vegan, binding.veganTextView, binding.veganImageView)
            updateColors(it.glutenFree, binding.glutenFreeTextView, binding.glutenFreeImageView)
            updateColors(it.dairyFree, binding.dairyFreeTextView, binding.dairyFreeImageView)
            updateColors(it.veryHealthy, binding.healthyTextView, binding.healthyImageView)
            updateColors(it.cheap, binding.cheapTextView, binding.cheapImageView)

        }
        binding.mainImageView.load(myBundle?.image)

        return binding.root
    }

    private fun updateColors(stateIsOn: Boolean, textView: TextView, imageView: ImageView) {
        if (stateIsOn) {
            imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}