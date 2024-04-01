package com.example.notebook.view.interfaces

import com.example.notebook.domain.models.Note

interface NotesAdapterListener {

    fun onRootClick(note: Note)
}