package com.henrianthony.myloancalculator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.henrianthony.myloancalculator.data.AppDatabase
import com.henrianthony.myloancalculator.model.Loan
import com.henrianthony.myloancalculator.repositories.LoanRepository
import kotlinx.coroutines.launch

class SimulationsActivity : androidx.appcompat.app.AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var repository: LoanRepository

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(_root_ide_package_.com.henrianthony.myloancalculator.R.layout.activity_simulations)


        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "loan.db"
        ).build()

        repository = LoanRepository(
            database.loanDao()
        )

        lifecycleScope.launch{
            val loans: List<Loan> = repository.searchAll()

            println(loans.toString())
        }

    }
}