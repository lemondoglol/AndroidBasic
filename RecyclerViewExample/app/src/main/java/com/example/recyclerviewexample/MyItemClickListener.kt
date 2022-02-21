package com.example.recyclerviewexample

/**
 * define multiple action listeners contract
 * - will be implemented in Activity/Fragment
 * */
interface MyItemClickListener {
    fun onItemClicked(myItem: MyItem)

    fun onItemTouch(myItem: MyItem)
}