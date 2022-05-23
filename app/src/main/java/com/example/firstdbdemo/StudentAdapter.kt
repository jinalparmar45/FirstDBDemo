package com.example.firstdbdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter (private val studentList: List<Student>) : RecyclerView.Adapter<ViewHolder>() {
private lateinit var  ItemListener : onItemClickListener;
//private lateinit var ItemSwipeListener: onRightSwipeItem;
    interface onItemClickListener{
        fun onClickListener(position : Int)
    }


    fun setItemListener(Listener: onItemClickListener){
        this.ItemListener = Listener;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
           //inflate view and return it
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_items, parent,false)
          return ViewHolder(view, ItemListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val itemVH = studentList[position]
        holder.fname.text = itemVH.FName
        holder.lname.text = itemVH.LName
        holder.grade.text = itemVH.Grade
        //Log.d(" bind student", "${itemVH.StudentId}")
        // add current item to holder
    }

    override fun getItemCount(): Int {
        //return size of the data
        return studentList.size;
    }

}

class ViewHolder(view: View, ItemListener: StudentAdapter.onItemClickListener) : RecyclerView.ViewHolder(view) {
    var fname: TextView = view.findViewById(R.id.itemfirstname)
    var lname: TextView = view.findViewById(R.id.itemlastname)
    var grade: TextView = view.findViewById(R.id.itemgrade)

init{
    itemView.setOnClickListener {
        ItemListener.onClickListener(adapterPosition)
    }


}

}

abstract class onRightSwipeItem :  ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0,ItemTouchHelper.RIGHT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

//        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//            TODO("Not yet implemented")
//        }
}


