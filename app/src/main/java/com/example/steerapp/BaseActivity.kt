package com.example.steerapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.steerapp.Home.HomeFragment
import com.example.steerapp.Massage.MessageFragment
import com.example.steerapp.More.MoreFragment
import com.example.steerapp.databinding.ActivityBaseBinding
import com.example.steerapp.databinding.ActivityMainBinding
import com.example.steerapp.note.NotesFragment

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.apply {
//            title = "Activity Base"
//            subtitle = "Ini adalah subtitle"
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
//        }

        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment())
                    true
                }
                R.id.notes -> {
                    replaceFragment(NotesFragment())
                    true
                }
                else ->false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            //.addToBackStack(null) -> ini kita nonaktifkan agar saat back langsung keluar aplikasi
            .commit()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                onBackPressedDispatcher.onBackPressed()
//                true
//            }
//
//            R.id.action_search -> {
//                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//            // --- Handling untuk Checkbox ---
//            R.id.action_show_hidden -> {
//                // Membalikkan status (toggle) dari checked menjadi unchecked, atau sebaliknya
//                item.isChecked = !item.isChecked
//
//                val status = if (item.isChecked) "Aktif" else "Tidak Aktif"
//                Toast.makeText(this, "Show Hidden Items: $status", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//            // --- Handling untuk Radio Buttons (Sub-menu Sort By) ---
//            R.id.sort_name -> {
//                // Mengubah status menjadi tercentang
//                item.isChecked = true
//                Toast.makeText(this, "Diurutkan berdasarkan Nama", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//            R.id.sort_date -> {
//                item.isChecked = true
//                Toast.makeText(this, "Diurutkan berdasarkan Tanggal", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//            R.id.sort_size -> {
//                item.isChecked = true
//                Toast.makeText(this, "Diurutkan berdasarkan Ukuran", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//            R.id.action_settings -> {
//                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}