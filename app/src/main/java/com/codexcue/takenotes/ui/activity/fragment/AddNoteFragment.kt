package com.codexcue.takenotes.ui.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.codexcue.takenotes.data.models.Note
import com.codexcue.takenotes.databinding.FragmentAddNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment(private val refreshList: () -> Unit) : BottomSheetDialogFragment() {
    private val viewModel: AddNoteViewModel by viewModels()
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBtn.setOnClickListener { saveNote() }
    }

    private fun getNoteInfo(): Note {
        return Note(info = binding.titleET.editText!!.text.toString())
    }

    private fun saveNote() {
        if (getNoteInfo().info.isNotEmpty()) {
            viewModel.saveNote(getNoteInfo())
            refreshList.invoke()
            dismissNow()
        }
        else {
            Toast.makeText(requireContext(), "Enter note title first", Toast.LENGTH_SHORT).show()
        }
    }
}