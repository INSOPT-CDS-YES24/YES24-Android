package com.subeenie.yes24_android.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.subeenie.yes24_android.databinding.ItemHomeSimilarRvBinding

class HomeSimilarRvApater(context: Context) :
    RecyclerView.Adapter<HomeSimilarRvApater.HomeViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var rvList: List<HomeSimilarRvData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeSimilarRvBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(rvList[position])
    }

    override fun getItemCount(): Int {
        return rvList.size
    }

    fun setRvList(rvList: List<HomeSimilarRvData>) {
        this.rvList = rvList.toList()
        notifyDataSetChanged()
    }

    class HomeViewHolder(private val binding: ItemHomeSimilarRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeSimilarRvData) {
            with(binding){
                ivHomeSimilarRv.load(data.poster)
                tvHomeSimilarMusical.text = data.genre
                tvHomeSimilarMusicalName.text = data.title
                tvHomeSimilarMusicalDate.text = data.date
            }
        }
    }
}