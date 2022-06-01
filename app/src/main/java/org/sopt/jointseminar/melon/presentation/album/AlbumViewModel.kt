package org.sopt.jointseminar.melon.presentation.album

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.jointseminar.melon.data.api.ServiceCreator
import org.sopt.jointseminar.melon.data.entity.album.AlbumCommentInfo
import org.sopt.jointseminar.melon.data.entity.album.AlbumInfo
import org.sopt.jointseminar.melon.util.CallExt.enqueueUtil

class AlbumViewModel : ViewModel() {
    private var _commentList = MutableLiveData<MutableList<AlbumCommentInfo>>()
    val commentList get() = _commentList
    val albumInfo = MutableLiveData<AlbumInfo>()
    private val call = ServiceCreator.service

    init {
        fetchAlbumInfo()
        fetchCommentList()
    }

    private fun fetchCommentList() {
        call.getComment("6290145b6af16276098d04d9").enqueueUtil(
            { result ->
                _commentList.value = result.data.map { comment ->
                    comment.convertToAlbumCommentInfo(comment)
                }.toMutableList()
            }, { code ->
                Log.d(TAG, "Failed to fetch comment: $code")
            }
        )
    }

    private fun fetchAlbumInfo() {
        call.getAlbumInfo("6290145b6af16276098d04d9").enqueueUtil(
            { result ->
                albumInfo.value = result.data.convertToAlbumInfo(result.data)
            }, { code ->
                Log.d(TAG, "Failed to fetch comment: $code")
            }
        )
    }

    /** 글쓰기 화면에서 댓글 등록 후 해당 댓글을 _commentList에 추가 */
    fun addComment(comment: AlbumCommentInfo) {
        _commentList.value?.add(comment)
    }

    companion object {
        private const val TAG = "AlbumViewModel"
    }
}