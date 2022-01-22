package com.example.recyclerviewexample

class MyItemClickListener(val clickListener: (myItem: MyItem) -> Unit) {
    fun onClick(myItem: MyItem) = clickListener(myItem)
}