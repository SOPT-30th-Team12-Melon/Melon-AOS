package org.sopt.jointseminar.melon.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.data.posting.ResponseHomeFavourite
import org.sopt.jointseminar.melon.data.posting.ResponseRecentMusic
import org.sopt.jointseminar.melon.databinding.FragmentHomeBinding
import org.sopt.jointseminar.melon.presentation.album.AlbumFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("초기화 안됨")
    var favouriteDataSet = mutableListOf<ResponseHomeFavourite>()
    var recentDataSet = mutableListOf<ResponseRecentMusic>()
    private lateinit var homeRecentAdapter: HomeRecentListAdapter
    private lateinit var homeFavouriteAdapter: HomeFavouriteAdapter
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        _binding?.viewModel = homeViewModel
        _binding?.lifecycleOwner = this@HomeFragment

        initFavouriteDataSet()
        initRecentDataSet()
        initHomeFavoriteAdapter()
        initRecentAdapter()
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

    private fun initRecentDataSet() {
        recentDataSet.addAll(
            listOf(
                ResponseRecentMusic(
                    image = R.drawable.img_albumcover,
                    title = "마음을 담아줘",
                    singer = "타코앤제이형"
                ),
                ResponseRecentMusic(
                    image = R.drawable.home_cover_two,
                    title = "Be My Side",
                    singer = "횡치열"
                ),
                ResponseRecentMusic(
                    image = R.drawable.home_img_box,
                    title = "That that",
                    singer = "싸이"
                )
            )
        )
    }

    private fun initHomeFavoriteAdapter() {
        homeFavouriteAdapter = HomeFavouriteAdapter().apply {
            submitList(favouriteDataSet)
        }
        binding.rvRepository.apply {
            adapter = homeFavouriteAdapter
            addItemDecoration(HomeDecorationHorizontal())
        }
    }

    private fun initRecentAdapter() {
        homeRecentAdapter =
            HomeRecentListAdapter { onRecentClick() }.apply { submitList(recentDataSet) }
        binding.rvRecentMusic.apply {
            adapter = homeRecentAdapter
            addItemDecoration(HomeDecorationHorizontal())
        }
    }

    private fun onRecentClick() {
        parentFragmentManager.commit {
            add(R.id.fcv_main, AlbumFragment())
            addToBackStack(null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
