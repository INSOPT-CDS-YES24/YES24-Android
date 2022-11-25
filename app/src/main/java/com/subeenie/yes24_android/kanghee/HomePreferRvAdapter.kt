package com.subeenie.yes24_android.kanghee

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.yes24_android.databinding.ItemHomePreferRvBinding

class HomePreferRvAdapter(context: Context) :
    RecyclerView.Adapter<HomePreferRvAdapter.HomeViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var rvList: List<HomePreferRvData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomePreferRvBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(rvList[position])
    }

    override fun getItemCount(): Int {
        return rvList.size
    }

    fun setRvList(rvList: List<HomePreferRvData>) {
        this.rvList = rvList.toList()
        notifyDataSetChanged()
    }

    class HomeViewHolder(private val binding: ItemHomePreferRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomePreferRvData) {
            binding.tvHomePreferMusicalName.text = data.title
            binding.tvHomePreferMusicalDate.text = data.date
        }
    }
}


