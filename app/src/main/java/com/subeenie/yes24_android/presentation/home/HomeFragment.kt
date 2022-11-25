package com.subeenie.yes24_android.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.subeenie.yes24_android.application.ApiFactory
import com.subeenie.yes24_android.application.Yes24Service
import com.subeenie.yes24_android.data.HomeContentsDTO
import com.subeenie.yes24_android.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.subeenie.yes24_android.presentation.detail.DetailActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding!!)
    private val yes24Service: Yes24Service = ApiFactory.yes24Service
    private val mocList = listOf<HomeSimilarRvData>(
        HomeSimilarRvData(
            "연극 [화원]",
            "2023.01.20 - 2023.03.12",
            "연극",
            "http://tkfile.yes24.com/upload2/PerfBlog/202210/20221021/20221021-43846.jpg"
        ),
        HomeSimilarRvData(
            "2022 뮤지컬 [미드나잇: 액터뮤지션]",
            "2022.09.29 - 2022.12.26",
            "뮤지컬",
            "https://w.namu.la/s/7398be1cb7897e07a6b1ef7666e399282d330174b4958d4dbfeecbffbff1e825b3bd79026b305c72b6e2e4d9899120239b22b8c7ed55d7acb077bd92bfd238d14b930d7d40370241d452066817095e21bbbbc792df172da2227ebfb23715bc73"
        ),
        HomeSimilarRvData(
            "뮤지컬 [모딜리아]",
            "2022.10.20 - 2023 01.26",
            "뮤지컬",
            "http://tkfile.yes24.com/upload2/PerfBlog/202209/20220913/20220913-43127.jpg"
        ),
        HomeSimilarRvData(
            "2022 푸에르자부르타 웨이라 인 서울",
            "2022.09.29 - 2022.12.25",
            "뮤지컬",
            "http://ticketimage.interpark.com/Play/image/large/22/22007215_p.gif"
        )
    )
    private val imgList = listOf<String>( //내려올 때
        "http://ticketimage.interpark.com/TCMS3.0/MProd/ProdBridge/2209/220908020834_22009029.gif",
        "http://ticketimage.interpark.com/Play/image/large/22/22014931_p.gif",
        "https://img.etoday.co.kr/pto_db/2014/05/20140507105327_445898_595_842.jpg",
        "http://ticketimage.interpark.com/TCMS3.0/MProd/ProdBridge/2208/220802020122_22009732.gif"
    )

    private val mocListVp = listOf<HomeViewPagerData>(
        HomeViewPagerData(
            "뮤지컬 [삼총사]",
            "http://tkfile.yes24.com/upload2/PerfBlog/202211/20221107/20221107-43061.jpg",
            "2022.09.29 - 2022.12.26",
            "유니버셜 아트센터 대극장"
        ),
        HomeViewPagerData(
            "마틸다",
            "http://ticketimage.interpark.com/TCMS3.0/MProd/ProdBridge/2207/220725030304_22009226.gif",
            "2022.10.05 - 2023.02.26",
            "대성 디큐브 아트센터"
        ),
        HomeViewPagerData(
            "스위니토드",
            "http://tkfile.yes24.com/upload2/PerfBlog/201908/20190805/20190805-34435_1.jpg",
            "2022.12.01 - 2023.03.05",
            "샤롯데씨어터"
        ),
        HomeViewPagerData(
            "물랑루즈!",
            "https://w.namu.la/s/c74e44b3bb87c51550e176a4acf09d07b5526d9e78282aa69ac5b2521c59832c5fc70e8aa9b628ded6e15f1223fa517f4eccfe89f504bde31cd3bd0487814b88bca3f0dd4511c6ce0d1369197e40e8367e2b505d9d8823a9040720e92bbce6f9",
            "2022.12.20 - 2023.03.05",
            "블루스퀘어 신한카드홀"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = HomeViewPagerAdapter(requireContext())
        val preferRvAdapter = HomePreferRvAdapter(requireContext())
        val similarRvApater = HomeSimilarRvApater(requireContext())

        binding.rvHomePrefer.layoutManager = LinearLayoutManager(requireActivity()).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
        binding.rvHomeSimillar.layoutManager = LinearLayoutManager(requireActivity()).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

        binding.vpHomeRecommend.adapter = viewPagerAdapter
        binding.rvHomePrefer.adapter = preferRvAdapter
        binding.rvHomeSimillar.adapter = similarRvApater

        similarRvApater.setRvList(mocList)
        viewPagerAdapter.setVpList(mocListVp)

        binding.btnHomeCategoryClassic.setOnClickListener {
            // 바텀네비게이션 테스트, 버그 테스트겸 하나 넣었음 나중에 삭제해도 상관없음!!
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        yes24Service.getContentsInfo().enqueue(object : Callback<HomeContentsDTO> {
            override fun onResponse(
                call: Call<HomeContentsDTO>,
                response: Response<HomeContentsDTO>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        preferRvAdapter.setRvList(imgList, it.data)
                    }
                }
            }

            override fun onFailure(call: Call<HomeContentsDTO>, t: Throwable) {
                Log.e("Home", t.toString())
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initAdpater(){

    }
}