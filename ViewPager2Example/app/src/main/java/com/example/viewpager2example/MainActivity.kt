package com.example.viewpager2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = object : FragmentStateAdapter(this) {
            // the number of fragments
            override fun getItemCount() = 2

            override fun createFragment(position: Int) = when (position) {
                0 -> HomeFragment()
                1 -> DetailFragment()
                else -> HomeFragment()
            }
        }

        // top appBar showing
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Detail"
            }
        }.attach()

    }
}