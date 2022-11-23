package com.subeenie.yes24_android.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FavorDto(
    @SerialName("status")
    val status: Int, // 200
    @SerialName("message")
    val message: String, // 관심공연 조회 성공
    @SerialName("data")
    val `data`: List<Data>
) {
    @Serializable
    data class Data(
        @SerialName("title")
        val title: String, // 뮤지컬 [삼총사]
        @SerialName("genre")
        val genre: String // 뮤지컬
    )
}