package org.sopt.jointseminar.melon.presentation.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.jointseminar.melon.databinding.FragmentAlbumBinding
import org.sopt.jointseminar.melon.presentation.posting.PostingActivity

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
        binding.rvCommentList.apply {
            adapter = albumCommentAdapter
            val dividerItemDecoration =
                DividerItemDecoration(binding.rvCommentList.context, LinearLayoutManager(requireContext()).orientation)
            addItemDecoration(dividerItemDecoration)
        }

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