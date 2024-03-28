package com.example.notebook.view.fragments.my_notes.details_note

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notebook.R
import com.example.notebook.data.note.entities.Note
import com.example.notebook.databinding.FragmentDetailsNoteBinding
import com.example.notebook.view.fragments.BaseFragment
import com.example.notebook.view.utils.extensions.toEditable

class DetailsNoteFragment :
    BaseFragment<FragmentDetailsNoteBinding>(FragmentDetailsNoteBinding::inflate) {

    private val viewModel: DetailsNoteViewModel by viewModels()

    private val args: DetailsNoteFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillNote()
    }

    private fun fillNote() {
        with(binding) {
            editNote.text = args.note.text.toEditable()
            editTitle.text = args.note.title.toEditable()
        }
    }

    override fun setListeners() {
        with(binding) {
            buttonDelete.setOnClickListener {
                doActionOnDelete()
                findNavController().navigateUp()
            }

            buttonSave.setOnClickListener {
                doActionOnUpdate()
                findNavController().navigateUp()
            }

            imageButtonArrow.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun doActionOnDelete() {
        viewModel.deleteNote(args.note)
        Toast.makeText(activity, R.string.message_delete, Toast.LENGTH_SHORT).show()
    }

    private fun doActionOnUpdate() {
        val note = Note(binding.editTitle.text.toString(), binding.editNote.text.toString())
        note.id = args.note.id
        viewModel.updateNote(note)
        Toast.makeText(activity, R.string.message_update, Toast.LENGTH_SHORT).show()
    }
}