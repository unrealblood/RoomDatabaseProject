package com.strength.roomdatabaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import com.strength.roomdatabaseproject.data.ContactData
import com.strength.roomdatabaseproject.data.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var contactDatabase : ContactDatabase

    //views
    private lateinit var mainTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactDatabase = ContactDatabase.getDatabase(this@MainActivity)

        mainTextView = findViewById(R.id.main_text_view)

        //insert in contacts Database
        GlobalScope.launch {
            contactDatabase.contactDao().insertContact(ContactData(1, "Tarun", "66666", Date()))
        }

        mainTextView.setOnClickListener {
            contactDatabase.contactDao().getContacts().observe(this, Observer {
                mainTextView.text = it.toString()
            })
        }
    }
}