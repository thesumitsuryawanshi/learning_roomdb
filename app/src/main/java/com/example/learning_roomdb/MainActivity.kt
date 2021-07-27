package com.example.learning_roomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learning_roomdb.roomdb.ContactDatabase

class MainActivity : AppCompatActivity() {


    lateinit var database: RoomDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //generally one android project should have a single database
        // and should use a singletone database pattern
        //but for the practice instance will use a below pattern

        database =
            Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "ContactDatabase")
                .build()


database.conta
    }
}