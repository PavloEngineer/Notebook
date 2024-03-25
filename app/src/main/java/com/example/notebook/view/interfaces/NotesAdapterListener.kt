package com.example.notebook.view.interfaces

import com.example.notebook.data.note.entities.Note

interface NotesAdapterListener {

    // TODO: better name
    fun onClick(note: Note)
}