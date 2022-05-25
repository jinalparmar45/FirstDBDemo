package com.example.firstdbdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel (app: Application): AndroidViewModel(app) {
    private  val repo : StudentRepository
    lateinit var allstudents: LiveData<List<Student>>
    init {
        repo= StudentRepository(app)
        allstudents = repo.getAllStudents()!!
    }

    fun getallstudents() = viewModelScope.launch {
        repo.getAllStudents()
    }

    fun insertstudents(student: Student) = viewModelScope.launch {
        repo.insertStudent(student)
    }
    fun updatestudents(student: Student) = viewModelScope.launch {
        repo.updateStudent(student)
    }
    fun deletestudents(student: Student) = viewModelScope.launch {
        repo.deleteStudent(student)
    }
}