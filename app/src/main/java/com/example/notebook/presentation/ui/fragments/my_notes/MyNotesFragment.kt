package com.example.notebook.presentation.ui.fragments.my_notes

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notebook.R
import com.example.notebook.databinding.FragmentListNotesBinding
import com.example.notebook.presentation.ui.fragments.BaseFragment
import com.example.notebook.presentation.ui.fragments.my_notes.adapter.NotesAdapter
import com.example.notebook.presentation.ui.interfaces.NotesAdapterForClickListener
import com.example.notebook.presentation.ui.models.NoteUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyNotesFragment: BaseFragment<FragmentListNotesBinding>(FragmentListNotesBinding::inflate),
SearchView.OnQueryTextListener {

    private val viewModel: MyNoteViewModel by viewModels()

    private val notesAdapter by lazy {
        NotesAdapter(
            listener = object : NotesAdapterForClickListener {
                override fun onItemClick(noteUI: NoteUI) {
                    val direction =
                        MyNotesFragmentDirections.actionMyNotesFragmentToDetailsNoteFragment(noteUI)
                    findNavController().navigate(direction)
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            viewModel.allNotes.collect { notes ->
                notesAdapter.submitList(notes)
            }
        }
    }

    override fun setListeners() {
        with(binding) {
            editTextSearch.setIconifiedByDefault(false)
            buttonAddNote.setOnClickListener {
                it.findNavController().navigate(R.id.action_myNotesFragment_to_addingNoteFragment)
            }

            buttonSearch.setOnClickListener {
                toggleVisibility(textHeader)
                toggleVisibility(editTextSearch)
            }

            editTextSearch.setOnQueryTextListener(this@MyNotesFragment)
        }
    }

    private fun toggleVisibility(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }

    private fun setupRecyclerView() {
        binding.recyclerNotes.adapter = notesAdapter
        binding.recyclerNotes.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchNotes(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        searchNotes(newText)
        return true
    }

    private fun searchNotes(query: String?) {
        query?.let {
            lifecycleScope.launch {
                viewModel.searchNotesByTitle(query).collect { notes ->
                    notesAdapter.submitList(notes)
                }
            }
        }
    }
}
