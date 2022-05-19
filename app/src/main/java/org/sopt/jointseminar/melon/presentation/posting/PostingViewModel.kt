package org.sopt.jointseminar.melon.presentation.posting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
}