package com.example.firstdbdemo

import androidx.room.*

@Dao
interface StudentDAO {
    //create
    @Insert
    fun insertStudent(student : Student)

    //read
    @Query("select * from Student")
    fun selectStudent():List<Student>

    //update
    @Update
    fun updateStudent(student : Student)

    //delete
    @Delete
    fun deleteStudent(student : Student)
}