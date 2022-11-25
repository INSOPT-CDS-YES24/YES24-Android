package com.subeenie.yes24_android.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyTicketDto(
    @SerialName("status")
    val status: Int, // 200
    @SerialName("message")
    val message: String, //마이티켓 정보조회 성공
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int, // 1
        @SerialName("userId")
        val userId: Int, // 1
        @SerialName("yesPoint")
        val yesPoint: Int, //3127
        @SerialName("saleCoupon")
        val saleCoupon: Int, //0
        @SerialName("booking")
        val booking: Int //0
    )
}