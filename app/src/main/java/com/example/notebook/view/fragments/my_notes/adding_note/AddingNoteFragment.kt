package com.example.notebook.view.fragments.my_notes.adding_note

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notebook.data.entities.Note
import com.example.notebook.databinding.FragmentAddNoteBinding
import com.example.notebook.view.fragments.BaseFragment
import com.example.notebook.view.utils.Constants

class AddingNoteFragment: BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {

    private val viewModel: AddingNoteViewModel by viewModels()

    override fun setListeners() {
        with(binding) {
            imageButtonArrow.setOnClickListener{
                findNavController().navigateUp()
            }

            buttonSave.setOnClickListener{
                saveNote()
                findNavController().navigateUp()
            }
        }
    }

    private fun saveNote() {
        with (binding) {
            if (isNoteNotEmpty()) {
                val note = Note(
                    0,
                    editTitle.text.toString(),
                    editNote.text.toString()
                )

                viewModel.addNote(note)
            } else {
                showToast()
            }
        }
    }

    private fun isNoteNotEmpty(): Boolean = binding.editTitle.text?.isNotEmpty() ?: false
            && binding.editNote.text?.isNotEmpty() ?: false

    private fun showToast() = Toast.makeText(context, Constants.WARNING_ADDING_MESSAGE, Toast.LENGTH_SHORT).show()
}