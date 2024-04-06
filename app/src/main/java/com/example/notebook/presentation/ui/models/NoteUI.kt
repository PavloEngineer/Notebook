package com.example.notebook.presentation.ui.models

import android.os.Parcelable
import com.example.notebook.domain.models.Note
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteUI(
    val id: Int = 0,
    val title: String,
    val text: String,
) : Parcelable {

    fun toNote(): Note {
        return Note(id, title, text)
    }

    companion object {
        fun toNoteUI(note: Note): NoteUI {
            return NoteUI(note.id, note.title, note.text)
        }
    }
}