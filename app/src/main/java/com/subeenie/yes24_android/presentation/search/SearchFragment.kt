package com.subeenie.yes24_android.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.databinding.FragmentSearchBinding
import com.subeenie.yes24_android.presentation.mypage.MyTicketAdapter
import com.subeenie.yes24_android.util.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
    }
}