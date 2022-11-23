package com.subeenie.yes24_android.presentation.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.databinding.FragmentMyticketBinding
import com.subeenie.yes24_android.util.BaseFragment


class MyticketFragment : BaseFragment<FragmentMyticketBinding>(R.layout.fragment_myticket) {
    private var myTicketAdapter = MyTicketAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initAdapter()
    }

    private fun initAdapter() {
        binding.rcvPerformance.adapter = myTicketAdapter
        addTicketList()
    }

    private fun addTicketList() {
        myTicketAdapter.submitList(
            listOf(
                MyPageData(
                    R.drawable.ic_performance_three, "뮤지컬", "뮤지컬 [드라큘라]"
                ),
                MyPageData(
                    R.drawable.ic_performance, "뮤지컬", "뮤지컬 [드라큘라]"
                ),
                MyPageData(
                    R.drawable.ic_performance_two, "뮤지컬", "뮤지컬 [드라큘라]"
                ),
                MyPageData(
                    R.drawable.ic_performance_three, "뮤지컬", "뮤지컬 [드라큘라]"
                ),
                MyPageData(
                    R.drawable.ic_performance_two, "뮤지컬", "뮤지컬 [드라큘라]"
                ),

                )
        )

    }

}