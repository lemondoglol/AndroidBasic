package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val dataList = ArrayList<MyItem>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.itemList_recyclerView)
        for (i in 0..8) dataList.add(MyItem(i, "description $i"))

        // define listener actions
        val myClickListener = MyItemClickListener {
            Toast.makeText(this, "ID: ${it.id} clicked", Toast.LENGTH_LONG).show()
        }
        val manager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        val adapter = RecyclerViewAdapter(myClickListener)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager

        findViewById<Button>(R.id.add_button).setOnClickListener {
            dataList.add(MyItem(25, "new item"))
            // submitList won't do anything for adding element in the list
            adapter.submitList(ArrayList(dataList))
        }
    }
}