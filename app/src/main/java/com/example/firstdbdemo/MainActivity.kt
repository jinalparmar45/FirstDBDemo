package com.example.firstdbdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val repo by lazy { StudentRepository(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val plusbutton:View =  findViewById(R.id.PlusButton)
        val recyclerview :RecyclerView = findViewById(R.id.Recycler)

//        var listStudent = ArrayList<Student>()
//
//        for(i in 1..20){
//            listStudent.add(Student("a"+i,"b"+1, "A"))
//        }

       var  listStudent: MutableList<Student> = repo.getAllStudents() as MutableList<Student>

        Log.d("ListStudent::" , "${listStudent.size}")
        recyclerview.layoutManager = LinearLayoutManager(this)
        val studenAdapter = StudentAdapter(listStudent)
        studenAdapter.setItemListener(object: StudentAdapter.onItemClickListener{
            override fun onClickListener(position: Int) {
                var addStudent = Intent(this@MainActivity, AddStudent::class.java)
                addStudent.putExtra("message", "Update");
                addStudent.putExtra("StudentID", ""+listStudent.get(position).StudentId);
                addStudent.putExtra("fname", ""+listStudent.get(position).FName);
                addStudent.putExtra("lname", ""+listStudent.get(position).LName);
                addStudent.putExtra("grade", ""+listStudent.get(position).Grade);
                this@MainActivity .startActivity(addStudent);
                Log.d("OnClick", "${listStudent.get(position).StudentId}  // ${listStudent.get(position)}")
            }

        })



        recyclerview.adapter = studenAdapter
        val ItemSwipeListener = object : onRightSwipeItem(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Log.d("Delete", "Swiped")
                val position = viewHolder.adapterPosition;
                val Student = listStudent.get(position);
                repo.deleteStudent(Student);
                listStudent.removeAt(position);
                recyclerview.adapter?.notifyItemRemoved(position)
                Log.d("Delete", "${Student.StudentId} ${Student.FName}")
//                val stid = viewHolder.itemView..text.toString().toInt()
//                val fn = viewHolder.itemView.findViewById<TextView>(R.id.fname).text.toString()
//                val ln = viewHolder.itemView.findViewById<TextView>(R.id.lName).text.toString()
            }

        }
        val ItemTouchHelper : ItemTouchHelper = ItemTouchHelper(ItemSwipeListener)
        ItemTouchHelper.attachToRecyclerView(recyclerview)

        plusbutton.setOnClickListener(){
            var addStudent = Intent(this, AddStudent::class.java)
            addStudent.putExtra("message", "Insert");
            this.startActivity(addStudent);
        }
    }

}