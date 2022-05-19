package org.sopt.jointseminar.melon.presentation.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.jointseminar.melon.model.CommentInfo

class AlbumViewModel : ViewModel() {
    private var _commentList = MutableLiveData<MutableList<CommentInfo>>()
    val commentList get() = _commentList

    init {
        fetchCommentList()
    }

    private fun fetchCommentList() {
        // TODO remote에서 comment 목록 fetch 하기
        _commentList.value = mutableListOf(CommentInfo("노래에 맘 터집니다"),
            CommentInfo("명반"),
            CommentInfo("타코앤와사비"))
    }

    /** 글쓰기 화면에서 댓글 등록 후 해당 댓글을 _commentList에 추가 */
    fun addComment(commentInfo: CommentInfo) {
        _commentList.value?.add(commentInfo)
    }
}