package com.henrianthony.myloancalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.henrianthony.myloancalculator.data.AppDatabase
import com.henrianthony.myloancalculator.repositories.LoanRepository

class SimulationsActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var repository: LoanRepository

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulations)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "loan.db"
        ).build()

        repository = LoanRepository(
            database.loanDao()
        )

    }
}