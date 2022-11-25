package com.subeenie.yes24_android.presentation.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.yes24_android.databinding.ItemMyPerformanceListBinding

class MyTicketAdapter : ListAdapter<MyPageData, MyTicketAdapter.TicketViewHolder>(
    DIFFUTIL
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding =
            ItemMyPerformanceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class TicketViewHolder(
        private val binding: ItemMyPerformanceListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(myPageData: MyPageData) {
            binding.myticket = myPageData
        }
    }

    companion object {
        val DIFFUTIL = object : DiffUtil.ItemCallback<MyPageData>() {
            override fun areItemsTheSame(
                oldItem: MyPageData,
                newItem: MyPageData
            ): Boolean {
                return oldItem.image == newItem.image
            }

            override fun areContentsTheSame(
                oldItem: MyPageData,
                newItem: MyPageData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}