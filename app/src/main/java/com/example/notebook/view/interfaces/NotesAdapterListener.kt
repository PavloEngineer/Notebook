package com.example.notebook.view.interfaces

import com.example.notebook.data.note.entities.Note

interface NotesAdapterListener {

    fun onClick(note: Note)
}