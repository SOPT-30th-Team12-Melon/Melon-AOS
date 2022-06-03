package org.sopt.jointseminar.melon.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.data.entity.music.ResponseRecentMusicData
import org.sopt.jointseminar.melon.databinding.ItemRecentMusicSampleListBinding

class HomeRecentListAdapter(private val onAlbumClick: () -> Unit) :
    ListAdapter<ResponseRecentMusicData.Data, HomeRecentListAdapter.RecentMusicViewHolder>(
        RecentMusicComparator
    ) {

    class RecentMusicViewHolder(private val binding: ItemRecentMusicSampleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseRecentMusicData.Data, onAlbumClick: () -> Unit) {
            binding.recentMusicData = data
            Glide.with(binding.ivAlbum.context)
                .load(data.image)
                .into(binding.ivAlbum)
            binding.root.setOnClickListener {
                onAlbumClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentMusicViewHolder {
        val binding = ItemRecentMusicSampleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecentMusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentMusicViewHolder, position: Int) {
        return holder.onBind(getItem(position), onAlbumClick)
    }

    companion object {
        private val RecentMusicComparator = object : DiffUtil.ItemCallback<ResponseRecentMusicData.Data>() {
            override fun areItemsTheSame(
                oldItem: ResponseRecentMusicData.Data,
                newItem: ResponseRecentMusicData.Data
            ): Boolean {
                return oldItem.albumId == newItem.albumId
            }

            override fun areContentsTheSame(
                oldItem: ResponseRecentMusicData.Data,
                newItem: ResponseRecentMusicData.Data
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
