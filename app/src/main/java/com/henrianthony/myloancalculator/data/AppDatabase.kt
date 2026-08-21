package com.henrianthony.myloancalculator.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.henrianthony.myloancalculator.model.Loan

@Database(
    entities = [Loan::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(LocalDateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loanDao(): LoanDao
}