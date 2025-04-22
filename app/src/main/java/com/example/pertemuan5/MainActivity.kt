package com.example.pertemuan5
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnDatePicker: Button
    private lateinit var btnAlert: Button
    private lateinit var tvSelectedDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        btnDatePicker = findViewById(R.id.btnDatePicker)
        btnAlert = findViewById(R.id.btnAlert)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        // Event Listener untuk Date Picker
        btnDatePicker.setOnClickListener { showDatePicker() }

        // Event Listener untuk Alert Dialog
        btnAlert.setOnClickListener { showAlertDialog() }
    }

    private fun showDatePicker() {
        // Ambil tanggal saat ini
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Tampilkan DatePickerDialog
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // Format tanggal yang dipilih
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            tvSelectedDate.text = "Selected Date: $selectedDate"

            // Tampilkan Toast sebagai konfirmasi
            Toast.makeText(this, "Tanggal dipilih: $selectedDate", Toast.LENGTH_SHORT).show()
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun showAlertDialog() {
        // Buat dan tampilkan Alert Dialog
        AlertDialog.Builder(this)
            .setTitle("Peringatan")
            .setMessage("Ini adalah Alert Dialog!")
            .setPositiveButton("OK") { _, _ ->
                // Aksi setelah klik tombol OK
                Toast.makeText(this, "Anda menekan OK", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Batal") { dialog, _ ->
                // Aksi setelah klik tombol Batal
                dialog.dismiss()
            }
            .show()
    }
}