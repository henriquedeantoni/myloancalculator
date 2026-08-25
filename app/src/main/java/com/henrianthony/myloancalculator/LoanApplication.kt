package com.henrianthony.myloancalculator

import com.henrianthony.myloancalculator.data.AppDatabase
import android.app.Application
import androidx.room.Room
import com.henrianthony.myloancalculator.repositories.LoanRepository

class LoanApplication : Application() {
    val database by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "loan.db"
        ).build()
    }

    val repository by lazy {
        LoanRepository(database.loanDao())
    }
}