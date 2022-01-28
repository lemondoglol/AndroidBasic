package com.example.navigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        // set appBar. (find in activity_main.xml)
        // navController needs to be defined here since in onCreate won't be ready to
        // set up the NavController there
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.fragmentContainerView))
    }

    // support NavigationController Back action
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentContainerView).navigateUp()
    }
}