package com.example.steerapp.note

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.steerapp.Home.pertemuan10.TenthActivity
import com.example.steerapp.Home.pertemuan2.SecActivity
import com.example.steerapp.Home.pertemuan3.ThirdActivity
import com.example.steerapp.Home.pertemuan4.FourthActivity
import com.example.steerapp.Home.pertemuan5.FifthActivity
import com.example.steerapp.Home.pertemuan7.SeventhActivity
import com.example.steerapp.Home.pertemuan9.NinthActivity
import com.example.steerapp.R
import com.example.steerapp.data.AppDatabase
import com.example.steerapp.data.entity.NoteEntity
import com.example.steerapp.databinding.FragmentHomeBinding
import com.example.steerapp.databinding.FragmentNotesBinding
import kotlinx.coroutines.launch

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // Standard best practice

        // 1. Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Notes"

        // 2. Setup Floating Action Button
        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }

        // 3. Initialize Core Data Components
        db = AppDatabase.getInstance(requireContext())
        adapter = NoteAdapter(notes, this) // Pass both required parameters here

        // 4. Bind LayoutManager and Adapter to RecyclerView
        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter

        // 5. Add UI Decorations
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvNotes.addItemDecoration(dividerItemDecoration)

        // 6. Fetch Data
        fetchNotes()
    }
    private fun fetchNotes() {
        lifecycleScope.launch {
            val data = db.noteDao().getAll() //pemanggilan query
            notes.clear()
            notes.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }

    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch {
            db.noteDao().delete(note) //Hapus Note
            fetchNotes()              //Fetch lagi data notes terbaru
        }
    }
}