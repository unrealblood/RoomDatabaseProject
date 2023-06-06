package com.strength.roomdatabaseproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.strength.roomdatabaseproject.DatabaseConverters

@Database(entities = [ContactData::class], version = 1)
@TypeConverters(DatabaseConverters::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO

    companion object {
        @Volatile
        private var INSTANCE : ContactDatabase? = null

        fun getDatabase(context : Context) : ContactDatabase {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java,  "contactsDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}