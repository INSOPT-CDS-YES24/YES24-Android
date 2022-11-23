package com.subeenie.yes24_android.application

import com.subeenie.yes24_android.data.ContentDetailDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Yes24Service {

    @Headers("Content-Type:application/json")
    @GET("/api/contents/{pathVariable}/detail")
    // == /api/contents/1/detail 서버측에서 :conteneId를 1로 고정해달라고 했기때문에 Path 어노테이션없이 주석과 같이 적어도 무방
    fun getContentDetail(@Path("pathVariable") path: Int): Call<ContentDetailDto>

    //TODO DTO생성하고 나머지 API 추가
}