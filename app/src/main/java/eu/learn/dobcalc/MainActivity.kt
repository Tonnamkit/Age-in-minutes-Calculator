package eu.learn.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null
    private var tvAgetoMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePick : Button = findViewById(R.id.btnDatePick)

        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgetoMinutes = findViewById(R.id.tvAgetoMinutes)

        btnDatePick.setOnClickListener{
            ClickDatePicker()
        }
    }

    private fun ClickDatePicker(){
        val myCal = Calendar.getInstance()
        val year = myCal.get(Calendar.YEAR)
        val month = myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view,selectedYear,selectedMonth,selectedDayOfMonth ->

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                tvSelectedDate?.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy" , Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                theDate?.let {
                    val selectedDatetoMinutes = theDate.time /60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDatetoMinutes = currentDate.time / 60000
                        val differenceInMinutes = if (currentDatetoMinutes - selectedDatetoMinutes > 0) currentDatetoMinutes - selectedDatetoMinutes else "Please Select agains"
                        tvAgetoMinutes?.setText(differenceInMinutes.toString())
                    }
                }

            },
                year,
                month,
                day
            )
        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()
        }

    }




//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 Token