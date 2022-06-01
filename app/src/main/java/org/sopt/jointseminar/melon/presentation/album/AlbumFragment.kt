package org.sopt.jointseminar.melon.presentation.album

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.databinding.FragmentAlbumBinding
import org.sopt.jointseminar.melon.presentation.posting.PostingActivity
import org.sopt.jointseminar.melon.util.convertTimeZonToYMD
import java.text.DecimalFormat

class AlbumFragment : Fragment() {
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!
    private val albumViewModel: AlbumViewModel by viewModels()
    private val albumCommentAdapter = AlbumCommentListAdapter()
    private val albumSongListAdapter = AlbumSongListAdapter()
    private val decimalFormat = DecimalFormat("##0.0")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        _binding!!.viewModel = albumViewModel
        _binding!!.lifecycleOwner = this@AlbumFragment

        initView()
        observeComment()

        return binding.root
    }

    private fun initView() {
        binding.rvCommentList.apply {
            adapter = albumCommentAdapter
            val dividerItemDecoration =
                DividerItemDecoration(binding.rvCommentList.context,
                    LinearLayoutManager(requireContext()).orientation)
            addItemDecoration(dividerItemDecoration)
        }

        binding.rvSongList.adapter = albumSongListAdapter

        binding.btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        binding.btnPosting.setOnClickListener {
            startActivity(Intent(requireContext(), PostingActivity::class.java))
        }
    }

    private fun observeComment() {
        albumViewModel.commentList.observe(viewLifecycleOwner) {
            albumCommentAdapter.submitList(it.toMutableList())
        }

        albumViewModel.albumInfo.observe(viewLifecycleOwner) { albumInfo ->
            binding.tvScore.text = decimalFormat.format(albumInfo.score)
            binding.tvReleaseDate.text = convertTimeZonToYMD(albumInfo.releaseDate)

            Glide.with(binding.ivArtistImg.context).load(albumInfo.artistImage)
                .into(binding.ivArtistImg)
            Glide.with(binding.ivAlbum.context).load(albumInfo.coverImage).into(binding.ivAlbum)

            albumSongListAdapter.setArtist(albumInfo.singerName)
            albumSongListAdapter.submitList(albumInfo.songList.toMutableList())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}