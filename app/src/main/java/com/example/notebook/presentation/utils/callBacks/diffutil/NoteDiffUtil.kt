package com.example.notebook.presentation.utils.callBacks.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.notebook.presentation.ui.models.NoteUI

class NoteDiffUtil: DiffUtil.ItemCallback<NoteUI>() {

    override fun areItemsTheSame(oldItem: NoteUI, newItem: NoteUI): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NoteUI, newItem: NoteUI): Boolean = oldItem == newItem
}