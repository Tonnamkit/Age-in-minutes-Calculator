package eu.learn.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePick : Button = findViewById(R.id.btnDatePick)

        btnDatePick.setOnClickListener{
            ClickDatePicker()
        }
    }

    fun ClickDatePicker(){
        val myCal = Calendar.getInstance()
        val year = myCal.get(Calendar.YEAR)
        val month = myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view,month,year,dayOfMonth ->


            },
                year,
                month,
                day
            ).show()
        }

    }




//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 Token