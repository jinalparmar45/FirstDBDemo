package com.example.firstdbdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    var StudentId: Int? = null,
    @ColumnInfo(name = "f_name") var FName:String,
    @ColumnInfo(name = "l_name") var LName:String,
    @ColumnInfo(name = "grade") var Grade: String,
)