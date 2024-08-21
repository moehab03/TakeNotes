package com.codexcue.takenotes.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.codexcue.takenotes.R
import com.codexcue.takenotes.databinding.ActivityMainBinding
import com.codexcue.takenotes.ui.activity.adapter.NotesAdapter
import com.codexcue.takenotes.ui.activity.fragment.AddNoteFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteActivity : AppCompatActivity() {
    private val vm: NoteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private val adapter = NotesAdapter(emptyList()) { note ->
        val dialog1 = AlertDialog.Builder(this)
        dialog1.setTitle("Delete")
            .setMessage("Do you want to delete this note?")
            .setPositiveButton(
                "Yes"
            ) { _, _ ->
                vm.deleteNote(note.id)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
            .create()
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        observeToLiveData()
        vm.getNotes()
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener { launchAddNoteFragment() }
    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun launchAddNoteFragment() {
        AddNoteFragment {
            vm.getNotes()
        }.show(
            supportFragmentManager,
            getString(R.string.add_fragment)
        )
    }

    private fun observeToLiveData() {
        vm.notesList.observe(this) {
            if (it.isEmpty()) showAddNotesInUI(true)
            else showAddNotesInUI(false)

            adapter.updateList(it)
        }
    }

    private fun showAddNotesInUI(state: Boolean) {
        if (state)
            binding.apply {
                arrow.visibility = View.VISIBLE
                addNewTV.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        else
            binding.apply {
                recyclerView.visibility = View.VISIBLE
                arrow.visibility = View.GONE
                addNewTV.visibility = View.GONE
            }
    }
}