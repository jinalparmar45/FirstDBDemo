package com.example.firstdbdemo

import android.content.Context
import androidx.lifecycle.LiveData

class StudentRepository(context : Context) {
    var db: StudentDAO? = AppDatabase.getInstance(context)?.StudentDAO()

    fun getAllStudents() : LiveData<List<Student>>? {
        return db?.selectStudent()
    }

    fun insertStudent(Student: Student){
        db?.insertStudent(Student)
    }

    fun updateStudent(Student: Student){
        db?.updateStudent(Student)
    }

    fun deleteStudent(Student: Student){
        db?.deleteStudent(Student)
    }

    //insert things in Async
}