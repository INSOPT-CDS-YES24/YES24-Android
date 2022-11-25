package com.subeenie.yes24_android.kanghee

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.subeenie.yes24_android.databinding.ItemHomeRecommnedVpBinding

class HomeViewPagerAdapter(context: Context) :
    RecyclerView.Adapter<HomeViewPagerAdapter.HomeViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var vpList: List<HomeViewPagerData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeRecommnedVpBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(vpList[position])
    }

    override fun getItemCount(): Int {
        return vpList.size
    }

    fun setVpList(vpList: List<HomeViewPagerData>) {
        this.vpList = vpList.toList()
        notifyDataSetChanged()
    }

    class HomeViewHolder(
        private val binding: ItemHomeRecommnedVpBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeViewPagerData) {
            binding.ivHomeRecommendVp.load(data.img)
            binding.tvHomeRecommendVpTitle.text = data.title
            binding.tvHomeRecommendVpDate.text = data.date
            binding.tvHomeRecommendVpPlace.text = data.place
        }
    }
}
