package org.sopt.jointseminar.melon.data.entity.posting

import com.google.gson.annotations.SerializedName

data class ResponsePostingData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
){
    data class Data(
        @SerializedName("_id")
        val id : String
    )
}
