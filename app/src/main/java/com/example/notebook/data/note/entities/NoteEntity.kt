package com.example.notebook.data.note.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notebook.domain.models.Note

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val text: String,
) {
        fun toNote(): Note  {
            val note = Note(this.title, this.text)
            note.id = this.id
            return note
        }

    companion object {
        fun toNoteEntity(note: Note) = NoteEntity (
            note.id,
            note.title,
            note.text
        )
    }


//    @PrimaryKey(autoGenerate = true)
//    @IgnoredOnParcel
//    var id: Int = 0
}