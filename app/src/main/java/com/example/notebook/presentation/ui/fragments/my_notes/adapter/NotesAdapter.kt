package com.example.notebook.presentation.ui.fragments.my_notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.databinding.ItemNoteBinding
import com.example.notebook.presentation.utils.callBacks.diffutil.NoteDiffUtil
import com.example.notebook.presentation.ui.interfaces.NotesAdapterForClickListener
import com.example.notebook.presentation.ui.models.NoteUI

class NotesAdapter (
    val listener: NotesAdapterForClickListener
): ListAdapter<NoteUI, NotesAdapter.NotesViewHolder>(NoteDiffUtil()) {

    inner class NotesViewHolder(
        private val binding: ItemNoteBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(noteUI: NoteUI) {
            with(binding) {
                editTitle.text = noteUI.title
                editNote.text = noteUI.text
                root.setOnClickListener {
                    listener.onItemClick(noteUI)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(
            inflate,
            parent,
            false
        )
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NotesViewHolder,
        position: Int
    ) = holder.bind(getItem(position))
}