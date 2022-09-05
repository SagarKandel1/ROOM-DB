package com.example.formtask.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table")
class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val address: String,
    val postal: String,
    val city: String,
    val country: String,
)
