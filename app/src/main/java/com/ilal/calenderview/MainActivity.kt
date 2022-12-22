package com.ilal.calenderview

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilal.calenderview.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnKalendar.setOnClickListener {
            setDate()
        }
        setToolbar()
    }

    private fun setToolbar(){
        supportActionBar?.title = "Kalender"
        supportActionBar?.subtitle = "Tutorial mencoba berbagai fitur"
    }

    private fun setDate(){
        val datePicker = Calendar.getInstance()
        val timePicker = Calendar.getInstance()

        val date = DatePickerDialog.OnDateSetListener {
                view, year, month, day ->
            datePicker[Calendar.YEAR] = year
            datePicker[Calendar.MONTH] = month
            datePicker[Calendar.DAY_OF_MONTH] = day
            val dateFormat = "EEE, d MMM yyyy"
            val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
            binding.date.text = simpleDateFormat.format(datePicker.time)

            val time = TimePickerDialog.OnTimeSetListener {
                    view, hour, minute ->
                timePicker[Calendar.HOUR_OF_DAY] = hour
                timePicker[Calendar.MINUTE] = minute
                val dateFormat = "h:mm a"
                val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
                binding.time.text = simpleDateFormat.format(timePicker.time)
            }

            TimePickerDialog(
                this@MainActivity, time,
                timePicker[Calendar.HOUR_OF_DAY],
                timePicker[Calendar.MINUTE],
                true
            ).show()
        }

        DatePickerDialog(
            this@MainActivity,date,
            datePicker[Calendar.YEAR],
            datePicker[Calendar.MONTH],
            datePicker[Calendar.DAY_OF_MONTH]
        ).show()
    }

}