package org.sopt.jointseminar.melon.presentation.home

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
        _topMusicList.value = mutableListOf(
            TopMusicInfo(Rank.FIRST, "That that", "싸이", R.drawable.home_img_box),
            TopMusicInfo(Rank.SECOND, "봄여름가을겨울", "빅뱅", R.drawable.home_img_box_two),
            TopMusicInfo(Rank.THIRD, "Love dive", "아이브", R.drawable.home_img_box_third)
        )
    }
}
