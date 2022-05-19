package org.sopt.jointseminar.melon.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.databinding.FragmentHomeBinding
import org.sopt.jointseminar.melon.presentation.album.AlbumFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("초기화 안됨")
    var favouriteDataSet = mutableListOf<ResponseHomeFavourite>()
    private lateinit var homeFavouriteAdapter: HomeFavouriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        initFavouriteDataSet()
        initAdapter()
        return binding.root
    }

    private fun initFavouriteDataSet() {
        favouriteDataSet.addAll(
            listOf(
                ResponseHomeFavourite(
                    title = "이번 주 인기 플레이리스트",
                    image = R.drawable.img_favorite,
                    content = "POP 갬성 폭발 분위기 끝내주는",
                    hashTag = "#분위기 #팝송"
                ),
                ResponseHomeFavourite(
                    title = "배가 너무 고프고",
                    image = R.drawable.img_favorite,
                    content = "너무 졸리다..",
                    hashTag = "#피곤 #할 게 넘 많다"
                )
            )
        )
    }

    private fun initAdapter() {
        homeFavouriteAdapter = HomeFavouriteAdapter { onFavouriteClick() }
        binding.rvRepository.adapter =
            homeFavouriteAdapter.apply { submitList(favouriteDataSet) }
    }

    private fun onFavouriteClick() {
        parentFragmentManager.commit {
            replace<AlbumFragment>(R.id.fcv_main)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
