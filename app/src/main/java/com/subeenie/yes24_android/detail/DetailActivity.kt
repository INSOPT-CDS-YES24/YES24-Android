package com.subeenie.yes24_android.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}