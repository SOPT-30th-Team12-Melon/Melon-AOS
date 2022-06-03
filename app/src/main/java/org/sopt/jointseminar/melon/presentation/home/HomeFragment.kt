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
import org.sopt.jointseminar.melon.data.entity.music.ResponseHomeFavourite
import org.sopt.jointseminar.melon.data.entity.music.ResponseRecentMusic
import org.sopt.jointseminar.melon.databinding.FragmentHomeBinding
import org.sopt.jointseminar.melon.presentation.album.AlbumFragment
import org.sopt.jointseminar.melon.util.CallExt.enqueueUtil
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

        initFavouriteMusicNetWork()
        initRecentMusicNetWort()
        initRecentAdapter()
        return binding.root
    }

    private fun initFavouriteMusicNetWork() {
        val call: Call<ResponseHomeFavourite> =
            ServiceCreator.service.getFavoriteMusic()
        call.enqueueUtil(
            onSuccess = {
                initHomeFavoriteAdapter()
                homeFavouriteAdapter.submitList(it.data.toMutableList())
            },
            onError = {
                requireContext().showToast("추천음악 서버 연결에 실패하셨습니다.")
            }
        )
    }

    private fun initRecentMusicNetWort() {
        val call: Call<ResponseRecentMusic> =
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
            addItemDecoration(HomeDecorationHorizontal())
        }
    }

    private fun initRecentAdapter() {
        homeRecentAdapter = HomeRecentListAdapter { onRecentClick() }
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
