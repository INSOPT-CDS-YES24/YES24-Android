package com.subeenie.yes24_android.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.subeenie.yes24_android.data.HomeContentsDTO
import com.subeenie.yes24_android.databinding.ItemHomePreferRvBinding

class HomePreferRvAdapter(context: Context) :
    RecyclerView.Adapter<HomePreferRvAdapter.HomeViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var rvList: List<HomeContentsDTO.Data> = emptyList()
    private var imgList: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomePreferRvBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(imgList[position], rvList[position])
    }

    override fun getItemCount(): Int {
        return rvList.size
    }

    fun setRvList(imgList: List<String>, rvList: List<HomeContentsDTO.Data>) {
        this.rvList = rvList.toList()
        this.imgList = imgList.toList()
        notifyDataSetChanged()
    }

    class HomeViewHolder(private val binding: ItemHomePreferRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(dataimg: String, data: HomeContentsDTO.Data) {
            with(binding){
                ivHomePreferRv.load(dataimg)
                tvHomePreferMusicalName.text = data.title
                tvHomePreferMusicalDate.text = data.dueDate
                tvHomePreferMusical.text = data.genre
            }
        }
    }
}


