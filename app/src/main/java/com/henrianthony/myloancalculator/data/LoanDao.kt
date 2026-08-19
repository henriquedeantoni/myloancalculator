package com.henrianthony.myloancalculator.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.henrianthony.myloancalculator.model.Loan

@Dao
interface LoanDao {

    @Insert
    suspend fun insertLoan(loan: Loan)

    @Query("SELECT * FROM loans")
    suspend fun searchAll() : List<Loan>

    @Query("SELECT * FROM loans WHERE id = :id")
    suspend fun searchById(id: Long) : Loan?

    @Update
    suspend fun updateLoan(loan: Loan)

    @Delete
    suspend fun deleteLoan(vararg loan: Loan)
}