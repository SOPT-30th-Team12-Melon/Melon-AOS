package org.sopt.jointseminar.melon.presentation.posting

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.jointseminar.melon.data.api.Service
import org.sopt.jointseminar.melon.data.api.ServiceCreator
import org.sopt.jointseminar.melon.data.entity.posting.RequestPostingData
import org.sopt.jointseminar.melon.util.CallExt.enqueueUtil

class PostingViewModel : ViewModel() {
    var review = MutableLiveData<String>()
    var reviewCount = MutableLiveData(0)
    var canRegister = MutableLiveData<Boolean>()

    fun updateCount() {
        if (review.value == null) return
        else reviewCount.value = review.value!!.length
    }

    fun checkReviewValidation(): Boolean {
        return if (!review.value.isNullOrBlank()) {
            canRegister.value = true
            true
        } else {
            false
        }
    }

    fun initNetwork(){
        val requestPostingData = RequestPostingData("629611876ec48eefa650e32d", review.value.toString())
        val call = ServiceCreator.service.postComment("6290145b6af16276098d04d9", requestPostingData)

        call.enqueueUtil(
            onSuccess = {
                Log.d("network", "${it.message}")
            },
            onError = {
                Log.d("network", "댓글달기 서버통신에 실패하였습니다.")
            }
        )
    }
}