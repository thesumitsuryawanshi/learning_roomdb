package com.example.learning_roomdb.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contactTable")
data class Contact(@ColumnInfo(name = "Name") var name: String)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
