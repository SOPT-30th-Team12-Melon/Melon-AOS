package org.sopt.jointseminar.melon.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.data.entity.music.ResponseHomeFavourite
import org.sopt.jointseminar.melon.databinding.ItemRecommendedMusicSampleListBinding

class HomeFavouriteAdapter :
    ListAdapter<ResponseHomeFavourite.Data, HomeFavouriteAdapter.HomeFavouriteViewHolder>(
        FavouriteComparator
    ) {

    class HomeFavouriteViewHolder(private val binding: ItemRecommendedMusicSampleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseHomeFavourite.Data) {
            binding.favouriteData = data
            binding.tvHashTag = data.hashtag.joinToString("")
            Glide.with(binding.ivMusic.context)
                .load(data.image)
                .into(binding.ivMusic)
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
        return holder.onBind(getItem(position))
    }

    companion object {
        private val FavouriteComparator = object : DiffUtil.ItemCallback<ResponseHomeFavourite.Data>() {
            override fun areItemsTheSame(
                oldItem: ResponseHomeFavourite.Data,
                newItem: ResponseHomeFavourite.Data
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: ResponseHomeFavourite.Data,
                newItem: ResponseHomeFavourite.Data
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
