package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val dataList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..8) dataList.add(i)

        val adapter = RecyclerViewAdapter()
        findViewById<RecyclerView>(R.id.itemList_recyclerView).adapter = adapter
        adapter.dataList = this.dataList

        findViewById<Button>(R.id.add_button).setOnClickListener {
            dataList.add(25)
            adapter.notifyDataSetChanged()
        }
    }
}