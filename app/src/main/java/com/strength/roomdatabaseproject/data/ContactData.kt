package com.strength.roomdatabaseproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("contactsTable")
data class ContactData(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val number : String
)