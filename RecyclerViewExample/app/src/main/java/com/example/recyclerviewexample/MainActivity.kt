package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val dataList = ArrayList<MyItem>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.itemList_recyclerView)
        for (i in 0..8) dataList.add(MyItem(i, "description $i"))

        // define listener actions
        val myClickListeners = object : MyItemClickListener {
            override fun onItemClicked(myItem: MyItem) {
                Toast.makeText(
                    this@MainActivity, "{${myItem.id}} clicked", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemTouch(myItem: MyItem) {
                Toast.makeText(
                    this@MainActivity, "{${myItem.id}} pressed", Toast.LENGTH_SHORT
                ).show()
            }

        }

        // grid layout
        val manager = GridLayoutManager(
            this, 2, GridLayoutManager.VERTICAL, false
        )
        val adapter = RecyclerViewAdapter(myClickListeners)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager

        /**
         * bind simple ItemTouchHelper to RecyclerView, swipe left or right to remove item
         */
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // remove item when swipe to left or right
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                dataList.removeAt(viewHolder.adapterPosition)
//                recyclerView.adapter?.notifyDataSetChanged()
                adapter.submitList(ArrayList(dataList)) // use submitList if using DiffUtils
            }
        }).attachToRecyclerView(recyclerView)

        findViewById<Button>(R.id.add_button).setOnClickListener {
            dataList.add(MyItem(25, "new item"))
            // submitList won't do anything for adding element in the list
            adapter.submitList(ArrayList(dataList))
        }
    }
}