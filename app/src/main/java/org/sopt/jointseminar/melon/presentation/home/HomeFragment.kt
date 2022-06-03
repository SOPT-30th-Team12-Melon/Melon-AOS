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
import org.sopt.jointseminar.melon.data.api.ServiceCreator
import org.sopt.jointseminar.melon.data.entity.music.ResponseHomeFavouriteData
import org.sopt.jointseminar.melon.data.entity.music.ResponseRecentMusicData
import org.sopt.jointseminar.melon.databinding.FragmentHomeBinding
import org.sopt.jointseminar.melon.presentation.album.AlbumFragment
import org.sopt.jointseminar.melon.util.CallExt.enqueueUtil
import org.sopt.jointseminar.melon.util.CustomDecoration
import org.sopt.jointseminar.melon.util.showToast
import retrofit2.Call

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("초기화 안됨")
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

        initFavouriteMusicData()
        initRecentMusicNetWort()
        return binding.root
    }

    private fun initFavouriteMusicData() {
        initHomeFavoriteAdapter()
        homeFavouriteAdapter.submitList(
            listOf(
                ResponseHomeFavouriteData.Data(
                    title = "이번주 인기 플레이리스트",
                    image = "https://is5-ssl.mzstatic.com/image/thumb/Music125/v4/35/9f/83/359f83b3-1423-3153-1641-98e948b7fc65/cover_-_EDAM_5_LILAC.jpg/600x600bb.jpg",
                    body = "POP갬성 폭발 분위기 끝장난다 그죠?",
                    hashtag = listOf("분위기", "밥송")
                ),
                ResponseHomeFavouriteData.Data(
                    title = "오늘의 감상 테마",
                    image = "https://is5-ssl.mzstatic.com/image/thumb/Music125/v4/35/9f/83/359f83b3-1423-3153-1641-98e948b7fc65/cover_-_EDAM_5_LILAC.jpg/600x600bb.jpg",
                    body = "청춘 드라마 주인공처럼",
                    hashtag = listOf("기분전환", "기분안좋아지기")
                ),
            )
        )
    }

    private fun initRecentMusicNetWort() {
        val call: Call<ResponseRecentMusicData> =
            ServiceCreator.service.getRecentMusic("all")

        call.enqueueUtil(
            onSuccess = {
                initRecentAdapter()
                homeRecentAdapter.submitList(it.data.toMutableList())
            },
            onError = {
                requireContext().showToast("최신음악 서버 연결에 실패하셨습니다.")
            }
        )
    }

    private fun initHomeFavoriteAdapter() {
        homeFavouriteAdapter = HomeFavouriteAdapter()
        binding.rvRepository.apply {
            adapter = homeFavouriteAdapter
            addItemDecoration(CustomDecoration())
        }
    }

    private fun initRecentAdapter() {
        homeRecentAdapter = HomeRecentListAdapter { onRecentClick() }
        binding.rvRecentMusic.apply {
            adapter = homeRecentAdapter
            addItemDecoration(CustomDecoration())
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
