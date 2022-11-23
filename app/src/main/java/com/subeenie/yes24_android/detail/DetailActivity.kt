package com.subeenie.yes24_android.detail

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.application.ApiFactory
import com.subeenie.yes24_android.data.ContentDetailDto
import com.subeenie.yes24_android.databinding.ActivityDetailBinding
import com.subeenie.yes24_android.detail.adapter.CastAdapter
import com.subeenie.yes24_android.detail.data.CastData
import com.subeenie.yes24_android.detail.viewmodel.DetailViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


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

        ApiFactory.yes24Service.getContentDetail(1).enqueue(
            object : Callback<ContentDetailDto>{
                override fun onResponse(
                    call: Call<ContentDetailDto>,
                    response: Response<ContentDetailDto>
                ) {
                    if(response.isSuccessful){
                        Timber.e(response.toString())
                        Timber.e(response.body().toString())
                    }
                    Timber.e(response.toString())
                }
                override fun onFailure(call: Call<ContentDetailDto>, t: Throwable) {
                    Timber.e(t)
                }
            }


        )

        binding.viewmodel = detailViewModel
        binding.lifecycleOwner = this
        setAdapter()
        addObserve()
        changeToolbar(this)
    }

    private fun setListener() {
        binding.appbarPin.setNavigationOnClickListener {
            //finish()
        }
    }

    private fun setAdapter() {
        adapter = CastAdapter(this)
        binding.rcvCast.adapter = adapter
        adapter.submitList(castList)
        detailViewModel.count = adapter.currentList.size
    }

    /**
     * CollapsingToolbarLayout 위치에 따라서 앱바 속성 변경
     */
    private fun changeToolbar(context: Context) {
        binding.layoutAppbar.addOnOffsetChangedListener(object : OnOffsetChangedListener {
            var scrollRange = -1

            @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                with(binding.appbarPin) {
                    if (scrollRange + verticalOffset == 0) { // Collapse 될떄
                        setBackgroundColor(context.getColor(R.color.white))
                        setTitleTextColor(context.getColor(R.color.black))
                        navigationIcon = context.getDrawable(R.drawable.ic_arrow_big_left)
                    } else { // Expand 될때
                        setBackgroundColor(context.getColor(R.color.transparent))
                        setTitleTextColor(context.getColor(R.color.white))
                        navigationIcon = context.getDrawable(R.drawable.ic_arrow_left_white)
                    }
                }
            }
        })
    }

    private fun addObserve() {
        detailViewModel.posterExpand.observe(this) {
            cropBitmap(R.drawable.img_detail, binding.ivPoster, it)
        }
        detailViewModel.detailExpand.observe(this) {
            cropBitmap(R.drawable.img_poster, binding.ivDetail, it)
        }
    }

    /**
     *  접기/펼치기를 위한 함수
     */
    private fun cropBitmap(image: Int, imageView: ImageView, boolean: Boolean?) {
        val bitmap = BitmapFactory.decodeResource(this.resources, image)
        if (boolean == false) {
            // 강제로 이미지의 높이를 1/4 토막
            val crop = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height / 4)
            imageView.setImageBitmap(crop)
        } else {
            // 원상태로 복구
            val crop = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height)
            imageView.setImageBitmap(crop)
        }
    }


}