package com.subeenie.yes24_android.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LikeContentsDto(
    @SerialName("status")
    val status: Int, // 200
    @SerialName("message")
    val message: String, //마이티켓 정보조회 성공
    @SerialName("data")
    val data: List<Data>
) {
    @Serializable
    data class Data(
        @SerialName("title")
        val title: String,
        @SerialName("genre")
        val genre: String
    )
}