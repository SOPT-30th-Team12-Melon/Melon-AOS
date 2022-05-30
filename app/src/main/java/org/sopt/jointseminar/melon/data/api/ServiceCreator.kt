package org.sopt.jointseminar.melon.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "http://takeusbackdev-env.eba-zha4u22c.ap-northeast-2.elasticbeanstalk.com/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : Service = retrofit.create(Service::class.java)
}