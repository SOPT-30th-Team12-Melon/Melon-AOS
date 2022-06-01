package org.sopt.jointseminar.melon.presentation.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.jointseminar.melon.data.entity.album.AlbumSongInfo
import org.sopt.jointseminar.melon.databinding.ItemMusicHorizontalBinding
import java.text.DecimalFormat

class AlbumSongListAdapter :
    ListAdapter<AlbumSongInfo, AlbumSongListAdapter.CommentViewHolder>(diffCallback) {
    private var artist: String? = null

    class CommentViewHolder(private val binding: ItemMusicHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: AlbumSongInfo, artist: String?) {
            binding.songData = song
            binding.tvArtist.text = artist
            binding.tvSequenceNum.text = DecimalFormat("00").format(song.number)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding =
            ItemMusicHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val data = currentList[position]
        holder.bind(data, artist)
    }

    fun setArtist(artist: String) {
        this.artist = artist
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<AlbumSongInfo>() {
            override fun areItemsTheSame(
                oldItem: AlbumSongInfo,
                newItem: AlbumSongInfo,
            ): Boolean {
                return oldItem.number == newItem.number
            }

            override fun areContentsTheSame(
                oldItem: AlbumSongInfo,
                newItem: AlbumSongInfo,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}