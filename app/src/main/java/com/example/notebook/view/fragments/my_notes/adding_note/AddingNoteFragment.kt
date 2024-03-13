package com.example.notebook.view.fragments.my_notes.adding_note

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notebook.R
import com.example.notebook.data.note.entities.Note
import com.example.notebook.databinding.FragmentAddNoteBinding
import com.example.notebook.view.fragments.BaseFragment
import com.example.notebook.view.utils.Constants
import com.example.notebook.view.utils.Constants.DEFAULT_ID

class AddingNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {

    private val viewModel: AddingNoteViewModel by viewModels()

    override fun setListeners() {
        with(binding) {
            imageButtonArrow.setOnClickListener {
                findNavController().navigateUp()
            }

            buttonSave.setOnClickListener {
                saveNote()
                findNavController().navigateUp()
            }
        }
    }

    private fun saveNote() {
        with(binding) {
            if (isNoteNotEmpty()) {
                val note = Note(
                    DEFAULT_ID,
                    editTitle.text.toString(),
                    editNote.text.toString()
                )

                viewModel.addNote(note)
            } else {
                Toast.makeText(
                    requireContext(),
                    R.string.warning_adding_message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isNoteNotEmpty(): Boolean =
        binding.editTitle.text?.isNotEmpty() == true && binding.editNote.text?.isNotEmpty() == true
}