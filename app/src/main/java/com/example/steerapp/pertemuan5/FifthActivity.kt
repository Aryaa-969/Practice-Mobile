package com.example.steerapp.pertemuan5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.steerapp.R
import com.example.steerapp.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)


        }

        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            // --- Handling untuk Checkbox ---
            R.id.action_show_hidden -> {
                // Membalikkan status (toggle) dari checked menjadi unchecked, atau sebaliknya
                item.isChecked = !item.isChecked

                val status = if (item.isChecked) "Aktif" else "Tidak Aktif"
                Toast.makeText(this, "Show Hidden Items: $status", Toast.LENGTH_SHORT).show()
                true
            }

            // --- Handling untuk Radio Buttons (Sub-menu Sort By) ---
            R.id.sort_name -> {
                // Mengubah status menjadi tercentang
                item.isChecked = true
                Toast.makeText(this, "Diurutkan berdasarkan Nama", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.sort_date -> {
                item.isChecked = true
                Toast.makeText(this, "Diurutkan berdasarkan Tanggal", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.sort_size -> {
                item.isChecked = true
                Toast.makeText(this, "Diurutkan berdasarkan Ukuran", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}