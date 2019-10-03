package com.example.tugas2

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var edDate : EditText? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edDate = this.editDate

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet (
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ){
                cal.set(Calendar.YEAR,year)
                cal.set(Calendar.MONTH,monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                updateDateInView()

            }
        }

        edDate!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick (view:View){
                DatePickerDialog (this@MainActivity,dateSetListener,

                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })
    }

    private fun updateDateInView (){
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat (myFormat, Locale.US)

        edDate!!.setText(sdf.format(cal.getTime()))
    }
}
