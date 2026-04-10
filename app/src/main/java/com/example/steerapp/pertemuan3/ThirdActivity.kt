package com.example.steerapp.pertemuan3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast
import com.example.steerapp.R
import com.example.steerapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnKirim.setOnClickListener {

            // Cek apakah inputan kosong
            if (binding.inputNoTujuan.text.toString().isEmpty()) {
                Toast.makeText(this, "tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                val nama = binding.inputNoTujuan.text
                Toast.makeText(this, "Pesan berhasil di kirim ke $nama", Toast.LENGTH_SHORT).show()


            }
        }
    }
}
