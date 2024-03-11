package com.example.notebook.view.interfaces

import com.example.notebook.data.entities.Note

interface NotesAdapterListener {

    fun onClick(note: Note)
}