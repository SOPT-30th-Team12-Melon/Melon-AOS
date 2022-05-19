package org.sopt.jointseminar.melon.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.data.posting.Rank
import org.sopt.jointseminar.melon.data.posting.TopMusicInfo

class HomeViewModel : ViewModel() {
    private var _topMusicList = MutableLiveData<MutableList<TopMusicInfo>>()
    val topMusicList get() = _topMusicList

    init {
        fetchTopMusicList()
    }

    private fun fetchTopMusicList() {
        // TODO remote에서 comment 목록 fetch 하기
        _topMusicList.value = mutableListOf(
            TopMusicInfo(Rank.FIRST, "That that", "싸이", R.drawable.img_favorite),
            TopMusicInfo(Rank.SECOND, "That that", "싸이", R.drawable.img_favorite),
            TopMusicInfo(Rank.THIRD, "That that", "싸이", R.drawable.img_favorite)
        )
    }
}
