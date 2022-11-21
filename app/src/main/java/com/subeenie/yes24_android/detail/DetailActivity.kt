package com.subeenie.yes24_android.detail

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.databinding.ActivityDetailBinding
import com.subeenie.yes24_android.detail.adapter.CastAdapter
import com.subeenie.yes24_android.detail.data.CastData
import com.subeenie.yes24_android.detail.viewmodel.DetailViewModel


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()
    private lateinit var adapter: CastAdapter
    private val castList = listOf<CastData>(
        //더미데이터
        CastData("정욱진", R.drawable.img_cast1),
        CastData("최민우", R.drawable.img_cast2),
        CastData("렌", R.drawable.img_cast3),
        CastData("라키", R.drawable.img_cast4),
        CastData("경윤", R.drawable.img_cast5),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewmodel = detailViewModel
        binding.lifecycleOwner = this
        setAdapter()
        setListeners()
    }

    private fun setAdapter() {
        adapter = CastAdapter(this)
        binding.rcvCast.adapter = adapter
        adapter.submitList(castList)
        detailViewModel.count = adapter.currentList.size
    }

    private fun setListeners() {
        binding.btnPoster.setOnClickListener {
            cropBitmap(R.drawable.img_detail1, binding.ivPoster)
        }
        binding.btnDetail.setOnClickListener {
            cropBitmap(R.drawable.img_detail2, binding.ivDetail)
        }
    }

    private fun cropBitmap(image: Int, imageView: ImageView) {
        val bitmap = BitmapFactory.decodeResource(this.resources, image)
        val crop = Bitmap.createBitmap( // 강제로 이미지의 높이를 1/4 토막
            bitmap,
            0,
            0,
            bitmap.width,
            bitmap.height / 4
        )
        binding.ivDetail.setImageBitmap(crop)

    }


}