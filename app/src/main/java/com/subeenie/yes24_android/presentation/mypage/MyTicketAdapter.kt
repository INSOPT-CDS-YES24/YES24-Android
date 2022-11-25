package com.subeenie.yes24_android.presentation.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.yes24_android.data.LikeContentsDto
import com.subeenie.yes24_android.data.MyTicketDto
import com.subeenie.yes24_android.databinding.ItemMyPerformanceListBinding

class MyTicketAdapter : ListAdapter<LikeContentsDto.Data, MyTicketAdapter.TicketViewHolder>(
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
        fun onBind(likeContentsDto: LikeContentsDto.Data) {
            binding.like = likeContentsDto
        }
    }

    companion object {
        val DIFFUTIL = object : DiffUtil.ItemCallback<LikeContentsDto.Data>() {
            override fun areItemsTheSame(
                oldItem: LikeContentsDto.Data,
                newItem: LikeContentsDto.Data
            ): Boolean {
                return oldItem.genre == newItem.genre
            }

            override fun areContentsTheSame(
                oldItem: LikeContentsDto.Data,
                newItem: LikeContentsDto.Data
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}