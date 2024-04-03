package com.example.notebook.view.fragments.my_notes

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notebook.R
import com.example.notebook.databinding.FragmentListNotesBinding
import com.example.notebook.domain.models.Note
import com.example.notebook.view.fragments.BaseFragment
import com.example.notebook.view.fragments.my_notes.adapter.NotesAdapter
import com.example.notebook.view.interfaces.NotesAdapterListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyNotesFragment: BaseFragment<FragmentListNotesBinding>(FragmentListNotesBinding::inflate),
SearchView.OnQueryTextListener {

    private val viewModel: MyNoteViewModel by viewModels()

    private val notesAdapter by lazy {
        NotesAdapter(
            listener = object : NotesAdapterListener {
                override fun onRootClick(note: Note) {
                    val direction =
                        MyNotesFragmentDirections.actionMyNotesFragmentToDetailsNoteFragment(note)
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
        viewModel.notes.observe(viewLifecycleOwner) {
            notesAdapter.submitList(it)
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
            viewModel.searchNotesByTitle(query).observe(this) { list ->
                notesAdapter.submitList(list)
            }
        }
    }
}