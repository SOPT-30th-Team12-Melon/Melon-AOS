package org.sopt.jointseminar.melon.presentation.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.data.entity.album.AlbumCommentInfo
import org.sopt.jointseminar.melon.databinding.ItemCommentBinding

class AlbumCommentListAdapter :
    ListAdapter<AlbumCommentInfo, AlbumCommentListAdapter.CommentViewHolder>(diffCallback) {
    class CommentViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: AlbumCommentInfo) {
            binding.comment = comment
            Glide.with(binding.ivUserImg.context).load(comment.authorImage).into(binding.ivUserImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val data = currentList[position]
        holder.bind(data)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<AlbumCommentInfo>() {
            override fun areItemsTheSame(
                oldItem: AlbumCommentInfo,
                newItem: AlbumCommentInfo,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: AlbumCommentInfo,
                newItem: AlbumCommentInfo,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}