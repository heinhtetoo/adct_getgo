package com.heinhtetoo.getgo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heinhtetoo.getgo.databinding.ItemCarFoundBinding
import com.heinhtetoo.getgo.model.CarFound

class CarFoundAdapter(private val listener: CarFoundItemListener) :
    RecyclerView.Adapter<CarFoundViewHolder>() {

    interface CarFoundItemListener {
        fun onItemClick(id: Int)
    }

    private val items = ArrayList<CarFound>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<CarFound>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarFoundViewHolder {
        val binding: ItemCarFoundBinding =
            ItemCarFoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarFoundViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CarFoundViewHolder, position: Int) =
        holder.bind(items[position])
}

class CarFoundViewHolder(
    private val itemBinding: ItemCarFoundBinding,
    private val listener: CarFoundAdapter.CarFoundItemListener
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: CarFound) {
        itemBinding.tvModel.text = item.model
        itemBinding.tvPlateNumber.text = item.plateNumber
        itemBinding.tvType.text = item.type
        itemBinding.tvDistance.text = item.distance
        itemBinding.tvRentalFee.text = item.rentalFee
        itemBinding.tvMileageFee.text = item.mileageFee

        itemBinding.root.setOnClickListener { listener.onItemClick(item.id) }
    }

}