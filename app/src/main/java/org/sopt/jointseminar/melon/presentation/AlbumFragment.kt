package org.sopt.jointseminar.melon.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.jointseminar.melon.databinding.FragmentAlbumBinding
import org.sopt.jointseminar.melon.model.CommentInfo
import org.sopt.jointseminar.melon.presentation.album.adapter.AlbumCommentListAdapter

class AlbumFragment : Fragment() {
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {
        AlbumCommentListAdapter().also {
            it.submitList(listOf(CommentInfo("노래에 맘 터집니다"),
                CommentInfo("명반"),
                CommentInfo("타코앤와사비")))
            binding.rvCommentList.adapter = it
        }

        binding.btnBack.setOnClickListener {
            // TODO 클릭 시 이전화면으로 복귀
        }

        binding.btnPosting.setOnClickListener {
            // TODO 클릭 시 글쓰기 화면으로 이동
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}