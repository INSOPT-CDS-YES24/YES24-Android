package com.subeenie.yes24_android.detail.util

import androidx.annotation.DrawableRes
import com.subeenie.yes24_android.R

enum class PriceRank(@DrawableRes val imageRes: Int) {
    VIP석(R.drawable.shape_rectangle_red),
    R석(R.drawable.shape_rectangle_purple),
    S석(R.drawable.shape_rectangle_blue),
    A석(R.drawable.shape_rectangle_yellow)
}