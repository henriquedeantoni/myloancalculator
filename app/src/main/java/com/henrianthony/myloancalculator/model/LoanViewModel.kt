package com.henrianthony.myloancalculator.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.henrianthony.myloancalculator.repositories.LoanRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

class LoanViewModel (private val repository: LoanRepository) : ViewModel() {

    fun saveLoan( loan: Loan
    ){
        viewModelScope.launch {
            repository.insertLoan(loan)
        }
    }

    fun loadLoans(){
        viewModelScope.launch {
            val loans = repository.searchAll()
        }
    }

    fun updateLoan(loan: Loan){
        viewModelScope.launch{
            repository.updateLoan(loan)
        }
    }
}