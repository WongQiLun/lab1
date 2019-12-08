package com.android.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var textPrice: TextView
    lateinit var  textDown :TextView
    lateinit var textInterestRate :TextView
    lateinit var textPeriod:TextView
    lateinit var textLoan:TextView
    lateinit var textInterest:TextView
    lateinit var  textMonthly:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton: Button = findViewById(R.id.buttonCalculate)
        val resetButton :Button =findViewById(R.id.buttonReset)
        resetButton.setOnClickListener{reset()}

        calculateButton.setOnClickListener{calculate()}
         textPrice = findViewById(R.id.editTextCarPrice)
        textDown= findViewById( R.id.editTextDownPayment)
        textInterestRate = findViewById(R.id.editTextInterestRate)
        textPeriod  = findViewById(R.id.editTextLoanPeriod)
         textLoan = findViewById(R.id.textViewLoan)
        textInterest = findViewById(R.id.textViewInterest)
        textMonthly = findViewById(R.id.textViewMonthlyRepayment)
    }

    private fun reset() {
        textPrice.text=null
        textDown.text=null
        textInterestRate.text= null
        textPeriod.text = null
        textLoan.text = getString(R.string.loan)
        textInterest.text = getString(R.string.interest)
        textMonthly.text = getString(R.string.monthly_repayment)
    }

    private fun calculate(){


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
