package com.subeenie.yes24_android.detail.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton
import com.subeenie.yes24_android.R


@BindingAdapter("app:load_price_rank")
fun ImageView.loadPriceRank(foodName: String) {
    this.setImageResource(PriceRank.valueOf(foodName).imageRes)
}

@BindingAdapter("app:img_res")
fun ImageView.loadCastPicture(resId: Int) {
    this.setImageResource(resId)
}

/**
 * 사용가능한 할인쿠폰 2개 에서 '2' 부분만 파란색 적용
 */
@BindingAdapter("app:spannable_text")
fun TextView.setSpannable(text: String) {
    val str = SpannableString(text)
    str.setSpan(
        ForegroundColorSpan(Color.parseColor("#508BFF")),
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
        this.text = context.getString(R.string.expand)
        this.icon = context.getDrawable(R.drawable.ic_collapse)
    } else {
        this.text = context.getString(R.string.collapse)
        this.icon = context.getDrawable(R.drawable.ic_expand)
    }
}
