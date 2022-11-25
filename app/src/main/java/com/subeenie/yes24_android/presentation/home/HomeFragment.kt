package com.subeenie.yes24_android.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.subeenie.yes24_android.databinding.FragmentHomeBinding
import com.subeenie.yes24_android.presentation.detail.DetailActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding!!)
    private val mocList = listOf<HomeSimilarRvData>(
        HomeSimilarRvData("레베카","2022.10.12"),
        HomeSimilarRvData("브론테","2022.10.12"),
        HomeSimilarRvData("브로드웨이","2022.10.12"),
        HomeSimilarRvData("졸리다","2022.10.12"),
        HomeSimilarRvData("되려나","2022.10.12"),
        HomeSimilarRvData("레베카","2022.10.12")

    )
    private val mocList2 = listOf<HomePreferRvData>(
        HomePreferRvData("레베카","2022.10.12"),
        HomePreferRvData("브론테","2022.10.12"),
        HomePreferRvData("브로드웨이","2022.10.12"),
        HomePreferRvData("졸리다","2022.10.12"),
        HomePreferRvData("되려나","2022.10.12"),
        HomePreferRvData("레베카","2022.10.12")

    )
    private val mocListVp = listOf<HomeViewPagerData>(
        HomeViewPagerData("레베가","https://mblogthumb-phinf.pstatic.net/20160807_25/poofto_1470501977575ECM2M_JPEG/mugc-1.jpg?type=w800","2022.10.12","세종홀"),
        HomeViewPagerData("졸리다","https://mblogthumb-phinf.pstatic.net/20160807_25/poofto_1470501977575ECM2M_JPEG/mugc-1.jpg?type=w800","2022.10.12","세종홀"),
        HomeViewPagerData("레베가","https://mblogthumb-phinf.pstatic.net/20160807_25/poofto_1470501977575ECM2M_JPEG/mugc-1.jpg?type=w800","2022.10.12","세종홀"),
        HomeViewPagerData("브론테","https://mblogthumb-phinf.pstatic.net/20160807_25/poofto_1470501977575ECM2M_JPEG/mugc-1.jpg?type=w800","2022.10.12","세종홀"),
                HomeViewPagerData("레베가","https://mblogthumb-phinf.pstatic.net/20160807_25/poofto_1470501977575ECM2M_JPEG/mugc-1.jpg?type=w800","2022.10.12","세종홀")
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

        binding.rvHomePrefer.layoutManager = LinearLayoutManager(requireActivity()).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        binding.rvHomeSimillar.layoutManager = LinearLayoutManager(requireActivity()).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        binding.vpHomeRecommend.adapter = viewPagerAdapter
        binding.rvHomePrefer.adapter = preferRvAdapter
        binding.rvHomeSimillar.adapter = similarRvApater

        similarRvApater.setRvList(mocList)
        preferRvAdapter.setRvList(mocList2)
        viewPagerAdapter.setVpList(mocListVp)

        binding.btnHomeCategoryClassic.setOnClickListener {
            // 바텀네비게이션 테스트, 버그 테스트겸 하나 넣었음 나중에 삭제해도 상관없음!!
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}