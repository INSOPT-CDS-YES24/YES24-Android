package com.subeenie.yes24_android.detail.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:load_price_rank")
fun ImageView.loadPriceRank(foodName: String) {
    this.setImageResource(PriceRank.valueOf(foodName).imageRes)
}
