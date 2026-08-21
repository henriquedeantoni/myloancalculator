package com.henrianthony.myloancalculator

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.henrianthony.myloancalculator.data.AppDatabase
import com.henrianthony.myloancalculator.model.Loan
import com.henrianthony.myloancalculator.repositories.LoanRepository
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.time.LocalDate
import java.util.Locale

class SimulateLoanActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var repository: LoanRepository

    var locale = Locale.getDefault()

    val format = NumberFormat.getNumberInstance(locale)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_simulate_loan)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "loan.db"
        ).build()

        repository = LoanRepository(
            database.loanDao()
        )

        val loanNameView = findViewById<TextView>(R.id.text_assetName)
        val loanAmountView = findViewById<TextView>(R.id.text_loanAmount)
        val monthsView = findViewById<TextView>(R.id.text_loanPeriod)

        val buttonSaveSimulation = findViewById<Button>(R.id.button_saveSimulation)

        buttonSaveSimulation.setOnClickListener {

            val name = loanNameView.text.toString()
            val amount = format.parse(loanAmountView.text.toString())?.toDouble()
            val taxRate = 0.016
            val months = format.parse(monthsView.text.toString())?.toInt()
            val opening = LocalDate.now();

            val loan = Loan(
                name,
                amount,
                taxRate,
                months,
                opening
                );

            lifecycleScope.launch {
                repository.insertLoan(loan)
            }
        }
    }
}