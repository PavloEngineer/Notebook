package com.example.notebook.view.fragments.my_notes.details_note

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notebook.data.note.entities.Note
import com.example.notebook.databinding.FragmentDetailsNoteBinding
import com.example.notebook.view.fragments.BaseFragment

class DetailsNoteFragment: BaseFragment<FragmentDetailsNoteBinding>(FragmentDetailsNoteBinding::inflate) {

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
                viewModel.deleteNote(args.note)
                findNavController().navigateUp()
                Toast.makeText(context, "Successful deleted!", Toast.LENGTH_SHORT).show()
            }

            buttonSave.setOnClickListener {
                with(binding) {
                    val note = Note(args.note.id, editTitle.text.toString(), editNote.text.toString())
                    viewModel.updateNote(note)
                    findNavController().navigateUp()
                }
            }

            imageButtonArrow.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}