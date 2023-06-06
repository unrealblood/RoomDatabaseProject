package com.strength.roomdatabaseproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(contact : ContactData)

    @Delete
    suspend fun deleteContact(contactData: ContactData)

    @Update
    suspend fun updateContact(contact : ContactData)

    @Query("SELECT * from contactsTable")
    fun getContacts() : LiveData<List<ContactData>>

}