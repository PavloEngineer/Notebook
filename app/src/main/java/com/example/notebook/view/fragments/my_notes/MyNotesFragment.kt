package com.example.notebook.view.fragments.my_notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notebook.App
import com.example.notebook.R
import com.example.notebook.data.Repositories
import com.example.notebook.data.note.entities.Note
import com.example.notebook.databinding.FragmentListNotesBinding
import com.example.notebook.view.fragments.BaseFragment
import com.example.notebook.view.fragments.my_notes.adapter.NotesAdapter
import com.example.notebook.view.interfaces.NotesAdapterListener

class MyNotesFragment: BaseFragment<FragmentListNotesBinding>(FragmentListNotesBinding::inflate) {

    private val viewModel: MyNoteViewModel by viewModels()

    private val notesAdapter = NotesAdapter(
        listener = object : NotesAdapterListener {
            override fun onClick(note: Note) {
                val direction =
                    MyNotesFragmentDirections.actionMyNotesFragmentToDetailsNoteFragment(note)
                findNavController().navigate(direction)
            }
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Repositories.init(requireContext())
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.notes.observe(viewLifecycleOwner) {
            notesAdapter.submitList(it)
        }
    }

    override fun setListeners() {
        binding.buttonAddNote.setOnClickListener {
            it.findNavController().navigate(R.id.action_myNotesFragment_to_addingNoteFragment)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerNotes.adapter = notesAdapter
        binding.recyclerNotes.layoutManager = LinearLayoutManager(requireContext())
    }
}