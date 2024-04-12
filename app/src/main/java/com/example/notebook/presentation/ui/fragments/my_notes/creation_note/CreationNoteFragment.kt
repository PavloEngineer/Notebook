package com.example.notebook.presentation.ui.fragments.my_notes.creation_note

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notebook.R
import com.example.notebook.databinding.FragmentAddNoteBinding
import com.example.notebook.presentation.ui.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreationNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {

    private val viewModel: CreationNoteViewModel by viewModels()

    override fun setListeners() {
        with(binding) {
            imageButtonArrow.setOnClickListener {
                findNavController().navigateUp()
            }

            buttonSave.setOnClickListener {
                saveNote()
            }
        }
    }

    private fun saveNote() {
        with(binding) {
            if (!isNoteEmpty()) {
                viewModel.addNote(editTitle.text.toString(), editNote.text.toString())
                findNavController().navigateUp()
            } else {
                Toast.makeText(
                    requireContext(),
                    R.string.warning_adding_message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isNoteEmpty(): Boolean =
        binding.editTitle.text.isNullOrEmpty() || binding.editNote.text.isNullOrEmpty()
}