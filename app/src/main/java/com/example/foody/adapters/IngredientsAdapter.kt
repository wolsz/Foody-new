package com.example.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foody.R
import com.example.foody.databinding.IngredientsRowLayoutBinding
import com.example.foody.models.ExtendedIngredient
import com.example.foody.util.Constants.Companion.BASE_IMAGE_URL
import com.example.foody.util.capitalized

class IngredientsAdapter: ListAdapter<ExtendedIngredient, IngredientsAdapter.MyViewHolder>(IngredientsDiffCallback()) {
    class MyViewHolder(val binding: IngredientsRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(IngredientsRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.ingredientImageView.load(BASE_IMAGE_URL + getItem(position).image) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }

        holder.binding.ingredientName.text = getItem(position).name?.capitalized() ?: ""
        holder.binding.ingredientAmount.text = getItem(position).amount.toString()
        holder.binding.ingredientUnit.text = getItem(position).unit
        holder.binding.ingredientConsistency.text = getItem(position).consistency
        holder.binding.ingredientOriginal.text = getItem(position).original
    }
}

class IngredientsDiffCallback: DiffUtil.ItemCallback<ExtendedIngredient>() {
    override fun areItemsTheSame(
        oldItem: ExtendedIngredient,
        newItem: ExtendedIngredient
    ): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(
        oldItem: ExtendedIngredient,
        newItem: ExtendedIngredient
    ): Boolean {
        return oldItem == newItem
    }

}
