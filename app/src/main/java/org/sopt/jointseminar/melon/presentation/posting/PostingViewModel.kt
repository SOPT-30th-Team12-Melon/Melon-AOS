package org.sopt.jointseminar.melon.presentation.posting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostingViewModel : ViewModel() {
    var review = MutableLiveData<String>()
    var reviewCount = MutableLiveData<Int>()
    var canRegister = MutableLiveData<Boolean>()
    var countString = MutableLiveData<String>()

    init {
        countString.value="0"
    }

    fun updateCount(){
        if(review.value==null)
            reviewCount.value=0
        else
            reviewCount.value = review.value?.length
    }

    fun checkRegister() : Boolean {
        if(!review.value.isNullOrBlank()){
            canRegister.value=true
            return true
        }
        else
            return false
    }

    fun makeString(){
        countString.value = reviewCount.value.toString()
    }
}