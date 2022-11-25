package com.subeenie.yes24_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.subeenie.yes24_android.databinding.ActivityMainBinding
import com.subeenie.yes24_android.kanghee.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayFragment()
    }

    private fun displayFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.home_container, HomeFragment())
            .commit()
    }
}