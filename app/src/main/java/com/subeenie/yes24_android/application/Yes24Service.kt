package com.subeenie.yes24_android.application

import com.subeenie.yes24_android.data.DetailDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Yes24Service {

    @Headers("Content-Type:application/json")
    @GET("/api/contents/{pathVariables}/detail")
    // == /api/contents/1/detail 서버측에서 :conteneId를 1로 고정해달라고 했기때문에 아래와 같이 적어도 무방
    suspend fun getYesPick(@Path("pathVariable") path:String): Call<DetailDto>


}