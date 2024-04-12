package com.example.notebook.presentation.ui.fragments.my_notes.details_note

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notebook.R
import com.example.notebook.databinding.FragmentDetailsNoteBinding
import com.example.notebook.presentation.ui.fragments.BaseFragment
import com.example.notebook.presentation.utils.SnackbarManager.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    override fun setListeners() {
        with(binding) {
            buttonDelete.setOnClickListener {
                doActionOnDelete()
            }

            buttonSave.setOnClickListener {
                doActionOnUpdate()
            }

            imageButtonArrow.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun doActionOnDelete() {
        viewModel.deleteNote(args.note)
        showSnackbar(requireView(), getString(R.string.message_delete)) { findNavController().navigateUp() }
    }

    private fun doActionOnUpdate() {
        val updatedNote = args.note.copy(id = args.note.id, title = binding.editTitle.text.toString(), text = binding.editNote.text.toString())
        viewModel.updateNote(updatedNote)
        showSnackbar(requireView(), getString(R.string.message_update))  { findNavController().navigateUp() }
    }
}