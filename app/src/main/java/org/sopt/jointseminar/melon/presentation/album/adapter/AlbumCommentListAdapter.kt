package org.sopt.jointseminar.melon.presentation.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.jointseminar.melon.databinding.ItemCommentBinding
import org.sopt.jointseminar.melon.model.CommentInfo

class AlbumCommentListAdapter :
    ListAdapter<CommentInfo, AlbumCommentListAdapter.CommentViewHolder>(diffCallback) {
    class CommentViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: CommentInfo) {
            binding.commentData = comment
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
        private val diffCallback = object : DiffUtil.ItemCallback<CommentInfo>() {
            override fun areItemsTheSame(oldItem: CommentInfo, newItem: CommentInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CommentInfo, newItem: CommentInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}