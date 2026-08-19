package com.henrianthony.myloancalculator.repositories

import com.henrianthony.myloancalculator.data.LoanDao
import com.henrianthony.myloancalculator.model.Loan

class LoanRepository (
    private val loanDao: LoanDao
) {
    suspend fun insertLoan(loan: Loan) {
        loanDao.insertLoan(loan)
    }

    suspend fun searchAll(): List<Loan> {
        return loanDao.searchAll()
    }

    suspend fun searchById(id: Long): Loan?{
        return loanDao.searchById(id)
    }

    suspend fun updateLoan(loan: Loan){
        loanDao.updateLoan(loan)
    }

    suspend fun deleteLoan(loan: Loan){
        loanDao.deleteLoan(loan)
    }
}