package com.example.roomdbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var firstNameTextView: TextView
    private lateinit var lastNameTextView: TextView
    private lateinit var insertUserButton: Button
    private lateinit var fetchByLastNameButton: Button

    private val myViewModel: MyViewModel by viewModels {
        UserViewModelFactory((application as UserApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        firstNameTextView = findViewById(R.id.first_name_textView)
        lastNameTextView = findViewById(R.id.last_name_textView)
        insertUserButton = findViewById(R.id.button)
        fetchByLastNameButton = findViewById(R.id.fetch_button)

        // add new user
        insertUserButton.setOnClickListener {
            firstNameTextView.text?.let { firstName ->
                lastNameTextView.text?.let { lastName ->
                    val newUser = UserEntity(
                        firstName = firstName.toString(), lastName = lastName.toString()
                    )
                    myViewModel.insertNewUser(newUser)
                }
            }
        }

        // fetch data from RoomDB
        myViewModel.allUsers.observe(this) {
            textView.text = it.toString()
        }

        // fetch data by last name
        fetchByLastNameButton.setOnClickListener {
            lastNameTextView.text?.let {
                myViewModel.getUsersWithLastName(it.toString())
                myViewModel.usersWithGivenLastName.observe(this) {
                    textView.text = it.toString()
                }
            }
        }
    }
}