package com.henrianthony.myloancalculator

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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

    val currencyFormat = NumberFormat.getCurrencyInstance(locale)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_simulate_loan)

        val seekBarLoanPeriod = findViewById<SeekBar>(R.id.seekBar_loanPeriod)

        val textValuePeriod = findViewById<TextView>(R.id.text_valuePeriod)

        val seekBarLoanAmount = findViewById<SeekBar>(R.id.seekBar_loanAmount)

        val textValueAmount = findViewById<EditText>(R.id.text_valueAmount)

        val main = findViewById<View>(R.id.main_simulateLoan)

        main.setOnClickListener {
            main.requestFocus()
        }

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "loan.db"
        ).build()

        repository = LoanRepository(
            database.loanDao()
        )

        val loanNameView = findViewById<TextView>(R.id.text_assetName)

        val buttonSaveSimulation = findViewById<Button>(R.id.button_saveSimulation)

        buttonSaveSimulation.setOnClickListener {

            val name = loanNameView.text.toString()
            val amount = parseCurrency(textValueAmount.text.toString())  //format.parse(textValueAmount.text.toString())?.toDouble()
            val taxRate = 0.016
            val months = format.parse(textValuePeriod.text.toString())?.toInt()
            val opening = LocalDate.now()

            val loan = Loan(
                name,
                amount,
                taxRate,
                months,
                opening
                );

            // show dialog message to save loan on db
            val saveDialog = AlertDialog.Builder(this)
                .setTitle("Save Simulation")
                .setMessage("Would you like save this simulation?")
                .setPositiveButton("Yes") { _,_ ->

                    // insert on db
                    try{
                        lifecycleScope.launch {
                            repository.insertLoan(loan)
                        }
                    } catch (e : Exception){
                        errorDialogMessage(e.message)
                    }
                }
                .setNegativeButton("No") { dialog, _ -> dialog.dismiss()
                }
                .show()
        }

        seekBarLoanPeriod.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(
                seekBarLoanPeriod: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ){
                textValuePeriod.text = "$progress months"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?){
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?){
            }
        })

        val minAmount = 1000
        val maxAmount = 1000000
        val amountStep = 100

        seekBarLoanAmount.min = 0
        seekBarLoanAmount.max =
            (maxAmount - minAmount) / amountStep

        // Valor inicial: R$ 1.000
        seekBarLoanAmount.progress = 0

        // Exibe o valor inicial
        textValueAmount.setText(currencyFormat.format(minAmount))

        // --------------------------------
        // Alteração do SeekBar do valor
        // --------------------------------

        seekBarLoanAmount.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {

                    val amount =
                        minAmount + (progress * amountStep)

                    textValueAmount.setText(currencyFormat.format(amount))

                }

                override fun onStartTrackingTouch(
                    seekBar: SeekBar?
                ) {
                }

                override fun onStopTrackingTouch(
                    seekBar: SeekBar?
                ) {
                }
            }
        )
    }

    fun parseCurrency(value: String): Double? {
        return try {
            val numberFormat = NumberFormat.getCurrencyInstance(
                locale
            )

            numberFormat.parse(value)?.toDouble()
        } catch (e: Exception) {
            null
        }
    }

    fun errorDialogMessage(message: String?) {
        val newDialog = AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage("Error on save Loan \n$message")
            .setPositiveButton("Yes") { _,_ ->

            }.create()

        newDialog.setOnShowListener {
            newDialog.window?.decorView?.bringToFront()
        }
        newDialog.show()
    }

}