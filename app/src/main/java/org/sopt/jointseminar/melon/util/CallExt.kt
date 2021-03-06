package org.sopt.jointseminar.melon.util

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object CallExt {
    fun <ResponseType> Call<ResponseType>.enqueueUtil(
        onSuccess: (ResponseType) -> Unit,
        onError: ((stateCode: Int) -> Unit)? = null
    ) {
        this.enqueue(object : Callback<ResponseType> {
            override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
                if (response.isSuccessful) {
                    onSuccess.invoke(response.body() ?: return)
                    Log.d("networktest", "success")
                } else {
                    onError?.invoke(response.code())
                    Log.d("networktest", "fail")
                }
            }

            override fun onFailure(call: Call<ResponseType>, t: Throwable) {
                Log.d("networktest", "error:$t")
            }
        })
    }
}