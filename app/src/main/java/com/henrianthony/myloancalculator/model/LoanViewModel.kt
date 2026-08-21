package com.henrianthony.myloancalculator.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.henrianthony.myloancalculator.repositories.LoanRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

class LoanViewModel (private val repository: LoanRepository) : ViewModel() {

    fun saveLoan(
        name: String,
        loanAmount: Double,
        taxRate: Double,
        instalments: Double,
        months: Int,
        opening: LocalDate
    ){
        val loan = Loan(name, loanAmount, taxRate, months, opening)

        viewModelScope.launch {
            repository.insertLoan(loan)
        }
    }
}