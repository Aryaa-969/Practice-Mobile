package com.example.steerapp

import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.steerapp.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        //Kondisi jika isLogin bernilai true
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            //Panggil Intent untuk ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.Username.text.toString()
            val password = binding.Password.text.toString()

            // Logika: Username sama dengan Password
            if (username.isNotEmpty() && username == password) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()

                //finishAffinity()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Menutup AuthActivity agar tidak bisa kembali dengan tombol back
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Gagal Login")
                    .setMessage("Silahkan Cobal Lagi?")
                    .setPositiveButton("Ya") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setNegativeButton("Batal") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}