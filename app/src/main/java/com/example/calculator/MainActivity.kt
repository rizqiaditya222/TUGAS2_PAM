package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Angka1 = findViewById<EditText>(R.id.etAngka1)
        val Angka2 = findViewById<EditText>(R.id.etAngka2)
        val pilihanOperasi = findViewById<RadioGroup>(R.id.radioGroup)
        val tombolHitung = findViewById<Button>(R.id.btnCalculate)

        tombolHitung.setOnClickListener {
            val angka1 = Angka1.text.toString().toDoubleOrNull()
            val angka2 = Angka2.text.toString().toDoubleOrNull()

            if (angka1 == null || angka2 == null) {
                Toast.makeText(this, "Angka tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hasil = when (pilihanOperasi.checkedRadioButtonId) {
                R.id.rbTambah -> angka1 + angka2
                R.id.rbKurang -> angka1 - angka2
                R.id.rbKali -> angka1 * angka2
                R.id.rbBagi -> if (angka2 != 0.0) angka1 / angka2 else null
                else -> null
            }

            if (hasil == null) {
                Toast.makeText(this, "Operasi tidak valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intentHasil = Intent(this, Activity2::class.java).apply {
                putExtra("HASIL", hasil)
                putExtra("NIM", "225150200111012")
                putExtra("NAMA", "Rizqi Aditya")
            }
            startActivity(intentHasil)
        }
    }
}
