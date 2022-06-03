package org.sopt.jointseminar.melon.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.data.entity.music.ResponseHomeFavouriteData
import org.sopt.jointseminar.melon.databinding.ItemRecommendedMusicSampleListBinding

class HomeFavouriteAdapter :
    ListAdapter<ResponseHomeFavouriteData.Data, HomeFavouriteAdapter.HomeFavouriteViewHolder>(
        FavouriteComparator
    ) {

    class HomeFavouriteViewHolder(private val binding: ItemRecommendedMusicSampleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseHomeFavouriteData.Data) {
            binding.favouriteData = data
            val s2 = data.hashtag.joinToString(prefix = "#", separator = " #")
            binding.tvHashTag.text = s2
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
        private val FavouriteComparator =
            object : DiffUtil.ItemCallback<ResponseHomeFavouriteData.Data>() {
                override fun areItemsTheSame(
                    oldItem: ResponseHomeFavouriteData.Data,
                    newItem: ResponseHomeFavouriteData.Data
                ): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areContentsTheSame(
                    oldItem: ResponseHomeFavouriteData.Data,
                    newItem: ResponseHomeFavouriteData.Data
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}
