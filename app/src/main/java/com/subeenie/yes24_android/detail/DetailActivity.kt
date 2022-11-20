package com.subeenie.yes24_android.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.databinding.ActivityDetailBinding
import com.subeenie.yes24_android.detail.adapter.CastAdapter
import com.subeenie.yes24_android.detail.data.CastData

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var adapter: CastAdapter
    private val castList = listOf<CastData>(
        CastData("정욱진",R.drawable.img_cast1),
        CastData("최민우",R.drawable.img_cast2),
        CastData("렌",R.drawable.img_cast3),
        CastData("라키",R.drawable.img_cast4),
        CastData("경윤",R.drawable.img_cast5),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.castcount = castList.size
        adapter = CastAdapter(this)
        binding.rcvCast.adapter = adapter
        adapter.submitList(castList)
    }



}