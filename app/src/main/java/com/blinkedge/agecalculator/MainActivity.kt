package com.blinkedge.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var button_select : Button
    private lateinit var year_visible : TextView



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         innit();
         button_select.setOnClickListener( View.OnClickListener {
             var myCalender = Calendar.getInstance();
             var  years = myCalender.get(Calendar.YEAR);
             var  months = myCalender.get(Calendar.MONTH);
             var  day = myCalender.get(Calendar.DAY_OF_MONTH);
             DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, day ->
                 var  selectedDate = "$day/${month+1}/$year";


                 var sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                 var theDate = sdf.parse(selectedDate);
                 var selectedDateinMin = theDate.time/6000;

                 year_visible.setText(selectedDateinMin.toString());
             },years,months,day).show();
             Toast.makeText(applicationContext,"ads",Toast.LENGTH_SHORT).show()
         })

    }

    private fun innit() {
        button_select = findViewById(R.id.select_date);
        year_visible = findViewById(R.id.currentyear);
    }
}