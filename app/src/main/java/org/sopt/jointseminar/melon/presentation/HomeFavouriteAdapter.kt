package org.sopt.jointseminar.melon.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.databinding.ItemRecommendedMusicSampleListBinding

class HomeFavouriteAdapter(private val onFavouriteClick: () -> Unit) :
    ListAdapter<ResponseHomeFavourite, HomeFavouriteAdapter.HomeFavouriteViewHolder>(
        FavouriteComparator
    ) {

    class HomeFavouriteViewHolder(private val binding: ItemRecommendedMusicSampleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseHomeFavourite, onFavouriteCick: () -> Unit) {
            binding.favouriteData = data
            Log.d("data.image", "${data.image}")
            Glide.with(binding.root)
                .load(data.image)
                .into(binding.ivMusic)
            binding.root.setOnClickListener {
                onFavouriteCick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFavouriteViewHolder {
        val binding = ItemRecommendedMusicSampleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeFavouriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFavouriteViewHolder, position: Int) {
        return holder.onBind(getItem(position), onFavouriteClick)
    }

    companion object {
        private val FavouriteComparator = object : DiffUtil.ItemCallback<ResponseHomeFavourite>() {
            override fun areItemsTheSame(
                oldItem: ResponseHomeFavourite,
                newItem: ResponseHomeFavourite
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: ResponseHomeFavourite,
                newItem: ResponseHomeFavourite
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
