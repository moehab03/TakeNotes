package com.codexcue.takenotes.ui.activity.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.codexcue.takenotes.data.models.Note
import com.codexcue.takenotes.databinding.NoteLayoutBinding

class NotesAdapter(
    private var list: List<Note>,
    private val onNoteClick: (note: Note) -> Unit
) :
    Adapter<NotesAdapter.NotesViewHolder>() {
    class NotesViewHolder(val binding: NoteLayoutBinding) : ViewHolder(binding.root) {

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Note>) {
        this.list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = list[position]
        holder.apply {
            binding.root.setOnClickListener { onNoteClick.invoke(note) }
            binding.noteTitle.text = note.info
        }
    }
}