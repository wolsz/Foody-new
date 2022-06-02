package com.example.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.data.database.entities.FavoritesEntity
import com.example.foody.databinding.FavoriteRecipesRowLayoutBinding
import com.example.foody.ui.fragments.favorites.FavoriteRecipesFragmentDirections

class FavoriteRecipesAdapter: ListAdapter<FavoritesEntity, FavoriteRecipesAdapter.MyViewHolder>(FavoriteRecipesDiffCallback()) {

    class MyViewHolder(val binding: FavoriteRecipesRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(favoritesEntity: FavoritesEntity) {
            binding.favoritesEntity = favoritesEntity
            binding.executePendingBindings()
        }

        companion object {
            fun from (parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavoriteRecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val selectedRecipe = getItem(position)
        holder.bind(selectedRecipe)

        /**
         * Single Click listener
         */
        holder.binding.favoriteRecipesRowLayout.setOnClickListener {
            val action = FavoriteRecipesFragmentDirections.actionFavoriteRecipesFragmentToDetailsActivity(selectedRecipe.result)
            holder.itemView.findNavController().navigate(action)
        }
    }
}

class FavoriteRecipesDiffCallback: DiffUtil.ItemCallback<FavoritesEntity>() {
    override fun areItemsTheSame(oldItem: FavoritesEntity, newItem: FavoritesEntity): Boolean {
        return oldItem.result.recipeId == newItem.result.recipeId
    }

    override fun areContentsTheSame(oldItem: FavoritesEntity, newItem: FavoritesEntity): Boolean {
        return oldItem.result == newItem.result
    }

}
