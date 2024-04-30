package com.example.myapplication3

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var editTextPhone: EditText
    private lateinit var buttonReserve: Button
    private lateinit var textViewReservationDetails: TextView
    private val reservations = mutableListOf<String>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        datePicker = findViewById(R.id.datePicker)
        editTextPhone = findViewById(R.id.editTextPhone)
        buttonReserve = findViewById(R.id.buttonReserve)
        textViewReservationDetails = findViewById(R.id.textViewReservationDetails)



        buttonReserve.setOnClickListener {
            reserve()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun reserve() {
        val name = editTextName.text.toString()
        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1
        val year = datePicker.year
        val phone = editTextPhone.text.toString()

        val selectedDate = LocalDate.of(year, month, day)
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = selectedDate.format(dateFormatter)

        val reservationDetails = "Nama: $name, $phone,($formattedDate)"
        reservations.add(reservationDetails)


        val allReservations = reservations.joinToString(separator = "\n\n")
        textViewReservationDetails.text = allReservations
    }

}
