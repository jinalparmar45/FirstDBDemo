package com.example.firstdbdemo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDAO {
    //create
    @Insert
    fun insertStudent(student : Student)

    //read
    @Query("select * from Student")
    fun selectStudent(): LiveData<List<Student>>


    //update
    @Update
    fun updateStudent(student : Student)

    //delete
    @Delete
    fun deleteStudent(student : Student)
}