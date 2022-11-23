package com.subeenie.yes24_android.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.subeenie.yes24_android.BR
import com.subeenie.yes24_android.databinding.ItemCastBinding
import com.subeenie.yes24_android.detail.data.CastData

class CastAdapter(context: Context) :
    ListAdapter<CastData, CastAdapter.ItemCastViewHolder>(CastDiffUtil) {

    private val inflater by lazy { LayoutInflater.from(context) }

    class ItemCastViewHolder(val binding: ItemCastBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCastViewHolder {
        return ItemCastViewHolder(ItemCastBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ItemCastViewHolder, position: Int) {
        holder.binding.setVariable(BR.cast, getItem(position))
    }

    companion object {
        private object CastDiffUtil : DiffUtil.ItemCallback<CastData>() {
            override fun areItemsTheSame(oldItem: CastData, newItem: CastData): Boolean {
                return false
            }

            override fun areContentsTheSame(oldItem: CastData, newItem: CastData): Boolean {
                return false
            }
        }
    }

}