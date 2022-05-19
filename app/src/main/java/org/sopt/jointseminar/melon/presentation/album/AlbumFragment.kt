package org.sopt.jointseminar.melon.presentation.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.jointseminar.melon.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!
    private val albumViewModel: AlbumViewModel by viewModels()
    private val albumCommentAdapter = AlbumCommentListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)

        initView()
        observeComment()

        return binding.root
    }

    private fun initView() {
        binding.rvCommentList.adapter = albumCommentAdapter

        binding.btnBack.setOnClickListener {
            // TODO 클릭 시 이전화면으로 복귀
        }

        binding.btnPosting.setOnClickListener {
            // TODO 클릭 시 글쓰기 화면으로 이동
        }
    }

    private fun observeComment() {
        albumViewModel.commentList.observe(viewLifecycleOwner) {
            albumCommentAdapter.submitList(it.toMutableList())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}