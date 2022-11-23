package com.subeenie.yes24_android.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YesPickDto(
    @SerialName("status")
    val status: Int, // 200
    @SerialName("success")
    val success: Boolean, // true
    @SerialName("message")
    val message: String, // YesPick 조회 성공
    @SerialName("data")
    val `data`: List<Data>
) {
    @Serializable
    data class Data(
        @SerialName("title")
        val title: String, // 뮤지컬 < 캣츠 > 오리지널 내한 - 서울 ( Musical CATS )
        @SerialName("genre")
        val genre: String, // 뮤지컬
        @SerialName("dueDate")
        val dueDate: String // 2023.01.20 - 2023.03.12
    )
}