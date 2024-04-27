package com.example.registrationform

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var button: Button
    lateinit var textview: TextView
    lateinit var textview1: TextView
    lateinit var spinner: Spinner
    var data = arrayOf("Male", "Female", "Others")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.dob)
        textview = findViewById(R.id.datetextview)


        textview1 = findViewById(R.id.gender)
        spinner = findViewById(R.id.spinner)

        var adapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_item, data
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        button.setOnClickListener {
            loadCalendar()
        }

    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                textview.text = ": $dayOfMonth/${monthOfYear + 1}/$year"
            }, year, month, day
        )


        datePickerDialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        textview1.text=parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

