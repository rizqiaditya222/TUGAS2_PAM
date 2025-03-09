package com.example.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val tvNIM = findViewById<TextView>(R.id.tvNIM)
        val tvNama = findViewById<TextView>(R.id.tvNama)

        val result = intent.getDoubleExtra("RESULT", 0.0)
        val nim = intent.getStringExtra("NIM") ?: "NIM tidak diketahui"
        val nama = intent.getStringExtra("NAMA") ?: "Nama tidak diketahui"

        tvHasil.text = "Hasil: $result"
        tvNIM.text = "NIM: $nim"
        tvNama.text = "Nama: $nama"
    }
}
