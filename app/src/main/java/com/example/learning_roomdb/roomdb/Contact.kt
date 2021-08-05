package com.example.learning_roomdb.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contactTable")
data class Contact
(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val column_Id : Int = 0 ,
     @ColumnInfo(name = "Name") var name: String
)
