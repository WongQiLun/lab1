package com.android.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton: Button = findViewById(R.id.buttonCalculate)


        calculateButton.setOnClickListener{calculate()}
    }

    private fun calculate(){
        val textPrice : TextView = findViewById(R.id.editTextCarPrice)
        val textDown : TextView = findViewById( R.id.editTextDownPayment)
        val textInterestRate :  TextView = findViewById(R.id.editTextInterestRate)
        val textPeriod :TextView = findViewById(R.id.editTextLoanPeriod)
        val textLoan :TextView = findViewById(R.id.textViewLoan)
        val textInterest : TextView = findViewById(R.id.textViewInterest)
        val textMonthly :TextView = findViewById(R.id.textViewMonthlyRepayment)

       val price: Double = textPrice.text.toString().toDouble()
        val downPayment : Double =textDown.text.toString().toDouble()
        val InterestRate  : Double  = textInterestRate.text.toString().toDouble() /100
        val period :Double= textPeriod.text.toString().toDouble()

        val loan: Double = price - downPayment
        val Interest :Double = loan * InterestRate *period
        val monthlyRepay : Double = (loan + Interest ) / period/12
         textLoan.text = "Loan : $loan"
        textInterest .text ="Interest : $Interest"
        textMonthly.text = """Monthly Replayment :$monthlyRepay"""




    }
}
