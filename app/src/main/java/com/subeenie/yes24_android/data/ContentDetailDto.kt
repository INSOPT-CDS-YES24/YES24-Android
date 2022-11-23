package com.subeenie.yes24_android.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentDetailDto(
    @SerialName("status")
    val status: Int, // 200
    @SerialName("message")
    val message: String, // 상세정보 조회 성공
    @SerialName("data")
    val `data`: Data
) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int, // 1
        @SerialName("title")
        val title: String, // 뮤지컬 [삼총사]
        @SerialName("genre")
        val genre: String, // 뮤지컬
        @SerialName("dueDate")
        val dueDate: String, // 2022.09.16 - 2022.11.06
        @SerialName("location")
        val location: String, // 유니버설아트센터 대극장
        @SerialName("actor")
        val actor: List<String>,
        @SerialName("coupon")
        val coupon: Int, // 2
        @SerialName("vipSeat")
        val vipSeat: Int, // 150000
        @SerialName("rSeat")
        val rSeat: Int, // 120000
        @SerialName("sSeat")
        val sSeat: Int, // 90000
        @SerialName("aSeat")
        val aSeat: Int, // 70000
        @SerialName("host")
        val host: String, // (주)글로벌컨텐츠_삼총사
        @SerialName("callCenter")
        val callCenter: String, // 클립서비스 1577-3363 / 글로벌컨텐츠 02-2051-1698
        @SerialName("ageLimit")
        val ageLimit: String // 8세 이상 관람가 (미취학 아동 입장 불가)
    )
}