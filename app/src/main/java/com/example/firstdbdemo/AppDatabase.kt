package com.example.firstdbdemo

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
//1.annotation  2. entities
@Database(entities = [Student::class],version = 1,exportSchema = false )
//3.abstract class with extends roomdatabase
abstract class AppDatabase: RoomDatabase() {

    //4. abstract function for DAO
    abstract fun StudentDAO(): StudentDAO

    //5.Singleton object
    companion object{
        var INSTANCE : AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {

            if(INSTANCE == null){
                synchronized(AppDatabase::class){
                    //aquiring instancce of room DB
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "studen.db"
                        ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE;
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}