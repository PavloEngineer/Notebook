package com.example.notebook.view.fragments.my_notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.databinding.ItemNoteBinding
import com.example.notebook.domain.models.Note
import com.example.notebook.view.callBacks.diffutil.NoteDiffUtil
import com.example.notebook.view.interfaces.NotesAdapterListener

class NotesAdapter (
    val listener: NotesAdapterListener
): ListAdapter<Note, NotesAdapter.NotesViewHolder>(NoteDiffUtil()) {

    inner class NotesViewHolder(
        private val binding: ItemNoteBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            with(binding) {
                editTitle.text = note.title
                editNote.text = note.text
                root.setOnClickListener {
                    listener.onRootClick(note)
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