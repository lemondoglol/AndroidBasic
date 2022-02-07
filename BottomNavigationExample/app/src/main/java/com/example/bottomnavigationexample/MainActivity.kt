package com.example.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()

        // init navigation configuration
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // myNavHostFragment is a type of NavHostFragment
        val navController = findNavController(R.id.myNavHostFragment)
        val appBarConfig = AppBarConfiguration.Builder(bottomNavigationView.menu).build() // without top navigation bar
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}