package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class RecyclerViewAdapter(private val clickListener: MyItemClickListener)
    : ListAdapter<MyItem, ItemViewHolder>(MyItemDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view_holder, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemTextView.text = "Current Item Number: ${item.id}"
        holder.itemTextView.setOnClickListener {
            clickListener.onClick(item)
        }
        holder.itemDescriptionTextView.text = "Description: ${item.description}"
    }

}

class MyItemDiffCallBack : DiffUtil.ItemCallback<MyItem>() {
    override fun areItemsTheSame(oldItem: MyItem, newItem: MyItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyItem, newItem: MyItem): Boolean {
        return oldItem == newItem
    }

}