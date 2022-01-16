package com.example.recyclerviewexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // define views inside this item view
    val itemTextView: TextView = itemView.findViewById(R.id.item_textView)
    val itemDescriptionTextView: TextView = itemView.findViewById(R.id.item_description_textView)
}