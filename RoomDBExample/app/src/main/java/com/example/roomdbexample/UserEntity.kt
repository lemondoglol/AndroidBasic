package com.example.roomdbexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * use data class for entity
 * table name will be 'UserEntity' if not specified
 * */
@Entity(tableName = "users")
data class UserEntity(
    // if use autoGenerate, then make it's field to var
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String
)