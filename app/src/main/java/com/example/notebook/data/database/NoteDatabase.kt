package com.example.notebook.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    fun closeDatabase(){
        this.close()
    }

//    companion object {
//
//        private val NAME_DATABASE = "note_database"
//
//        @Volatile
//        private var INSTANCE: NoteDatabase? = null
//
//        fun initialDatabase(context: Context): NoteDatabase {
//            INSTANCE?.let {
//                return INSTANCE as NoteDatabase
//            }
//
//            val tempInstance = buildDatabase(context)
//            INSTANCE = tempInstance
//            return tempInstance
//        }
//
//        private fun buildDatabase(context: Context): NoteDatabase {
//            synchronized(this) {
//                return Room.databaseBuilder(
//                    context.applicationContext,
//                    NoteDatabase::class.java,
//                    NAME_DATABASE
//                ).build()
//            }
//        }
//    }
}