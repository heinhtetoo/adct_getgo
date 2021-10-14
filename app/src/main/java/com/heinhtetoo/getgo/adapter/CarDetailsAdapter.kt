package com.heinhtetoo.getgo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heinhtetoo.getgo.databinding.ItemCarDetailsBinding

class CarDetailsAdapter() :
    RecyclerView.Adapter<CarDetailsViewHolder>() {

    private val items = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarDetailsViewHolder {
        val binding: ItemCarDetailsBinding =
            ItemCarDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CarDetailsViewHolder, position: Int) =
        holder.bind(items[position])
}

class CarDetailsViewHolder(
    private val itemBinding: ItemCarDetailsBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: String) {}

}