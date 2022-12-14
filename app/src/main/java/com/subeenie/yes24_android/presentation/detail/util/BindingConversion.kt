package com.subeenie.yes24_android.presentation.detail.util

import android.annotation.SuppressLint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton
import com.subeenie.yes24_android.R
import java.text.DecimalFormat


@BindingAdapter("app:load_price_rank")
fun ImageView.loadPriceRank(priceName: String) {
    this.setImageResource(PriceRank.valueOf(priceName).imageRes)
}

@BindingAdapter("app:load_actor_image")
fun ImageView.loadActorImage(actorName: String) {
    this.setImageResource(ActorInfo.valueOf(actorName).imageRes)
}

/**
 * 사용가능한 할인쿠폰 2개 에서 '2' 부분만 파란색 적용
 */
@BindingAdapter("app:spannable_text")
fun TextView.setSpannable(text: String) {
    val str = SpannableString(text)
    str.setSpan(
        ForegroundColorSpan(context.getColor(R.color.yes_24_main)),
        text.length - 2,
        text.length - 1,
        Spanned.SPAN_EXCLUSIVE_INCLUSIVE
    )
    this.text = str
}

/**
 * 접기 / 펼치기 버튼 변경
 */
@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("app:expand_button")
fun MaterialButton.expandButton(expand: Boolean) {
    if (expand) {
        this.text = context.getString(R.string.collapse)
        this.icon = context.getDrawable(R.drawable.ic_collapse)
    } else {
        this.text = context.getString(R.string.expand)
        this.icon = context.getDrawable(R.drawable.ic_expand)
    }
}

/**
 * 천단위 콤마
 */
@BindingAdapter("app:seat_price")
fun TextView.reformatPrice(price: Int) {
    val decimal = DecimalFormat("#,###")
    this.text = String.format(context.getString(R.string.price), decimal.format(price))
}

/**
 * / 기준으로 소비자상담 텍스트 줄바꿈
 */
@BindingAdapter("app:call_text")
fun TextView.reformatCall(call: String) {
    val strBuilder = StringBuilder()
    strBuilder.append(call)
    call.forEachIndexed { index, c ->
        if (c == '/') {
            strBuilder.insert(index - 1, "\n")
        }
    }
    this.text = strBuilder.toString()
}