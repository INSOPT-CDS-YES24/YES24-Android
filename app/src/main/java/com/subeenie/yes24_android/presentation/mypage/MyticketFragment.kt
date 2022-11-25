package com.subeenie.yes24_android.presentation.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.subeenie.yes24_android.R
import com.subeenie.yes24_android.application.ApiFactory
import com.subeenie.yes24_android.data.ContentDetailDto
import com.subeenie.yes24_android.data.LikeContentsDto
import com.subeenie.yes24_android.data.MyTicketDto
import com.subeenie.yes24_android.databinding.FragmentMyticketBinding
import com.subeenie.yes24_android.util.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class MyticketFragment : Fragment() {
    private var _binding: FragmentMyticketBinding? = null
    private val binding get() = _binding!!

    private var myTicketAdapter = MyTicketAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyticketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initNetWork()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rcvPerformance.adapter = myTicketAdapter
        addTicketList()
    }

    private fun initNetWork() {
        // 코루틴이나 엠티뷰가 없어서 데이터바인딩 적용전까지 null값대신 빈 데이터 적용
        ApiFactory.yes24Service.getMyTicketInfo().enqueue(
            object : Callback<MyTicketDto> {
                override fun onResponse(
                    call: Call<MyTicketDto>,
                    response: Response<MyTicketDto>
                ) {
                    if (response.isSuccessful) {
                        val serverData = response.body()!!.data
                        binding.myticket = serverData

                    }
                    Timber.e(response.toString())
                }

                override fun onFailure(call: Call<MyTicketDto>, t: Throwable) {
                    Timber.e(t)
                }
            }
        )
    }

    /*private fun addTicketList() {
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

    }*/

    private fun addTicketList() {
        ApiFactory.yes24Service.getLikeInfo().enqueue(
            object : Callback<LikeContentsDto> {
                override fun onResponse(
                    call: Call<LikeContentsDto>,
                    response: Response<LikeContentsDto>
                ) {
                    if (response.isSuccessful) {
                        myTicketAdapter.submitList(response.body()?.data)
                    }
                    Timber.e(response.toString())
                }

                override fun onFailure(call: Call<LikeContentsDto>, t: Throwable) {
                    Timber.e(t)
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}