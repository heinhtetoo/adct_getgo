package com.heinhtetoo.getgo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heinhtetoo.getgo.R
import com.heinhtetoo.getgo.databinding.ItemPagerIndicatorBinding

class PagerIndicatorAdapter(private val context: Context) :
    RecyclerView.Adapter<PagerIndicatorAdapter.PagerIndicatorViewHolder>() {

    private var items: List<Boolean> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerIndicatorViewHolder {
        return PagerIndicatorViewHolder(parent)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(count: Int) {
        val indicatorList = arrayListOf(true)
        for (i in 1 until count) {
            indicatorList.add(false)
        }
        items = indicatorList
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun indicateAt(position: Int) {
        val oldIndex = items.indexOf(true)
        val newList = ArrayList(items)
        newList[oldIndex] = false
        newList[position] = true
        items = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PagerIndicatorViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onBindViewHolder(
        holder: PagerIndicatorViewHolder, position: Int, payloads: MutableList<Any>
    ) {
        holder.bind(if (payloads.isEmpty()) items[position] else payloads[0] as Boolean)
    }

    inner class PagerIndicatorViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding: ItemPagerIndicatorBinding = ItemPagerIndicatorBinding.bind(itemView)

        constructor(parent: ViewGroup) :
                this(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_pager_indicator, parent, false)
                )

        fun bind(item: Boolean) {
            val background = if (item) R.drawable.dot_selected else R.drawable.dot_default
            binding.indicator.setBackgroundResource(background)
        }
    }
}