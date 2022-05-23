package com.example.firstdbdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class AddStudent : AppCompatActivity() {
    var repo = StudentRepository(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val addBTN : Button = findViewById(R.id.add)
        val fname :EditText = findViewById(R.id.fName)
        val lname :EditText = findViewById(R.id.lName)
        val grade :EditText = findViewById(R.id.Grade)
       //if message == update-> set edit view text
        if (intent.getStringExtra("message").equals("Update")){
            fname.setText( intent.getStringExtra("fname"))
            lname.setText(intent.getStringExtra("lname"))
            grade.setText( intent.getStringExtra("grade"))
        }

        //and set add butn to update

        Log.d("Message" , "${intent.getStringExtra("message")} // ${intent.getStringExtra("StudentID")}")



        addBTN.setOnClickListener(){
            if(intent.getStringExtra("message").equals("Insert")){
                Log.d("add student", " listener called")

                val student = Student(  FName = fname.text.toString(), LName = lname.text.toString(), Grade = grade.text.toString())
                repo.insertStudent(student)
                Log.d("add student", " listener called  ${fname.text.toString()}")
            }else{
//StudentId= intent.getStringExtra("StudentID")?.toInt()
                val student = Student( StudentId= intent.getStringExtra("StudentID")?.toInt(), FName = fname.text.toString(), LName = lname.text.toString(), Grade = grade.text.toString())
                repo.updateStudent(student)
            }
            var main = Intent(this, MainActivity::class.java)
            this.startActivity(main);
        }
    }
}

