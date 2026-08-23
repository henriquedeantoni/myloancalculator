package com.henrianthony.myloancalculator.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.henrianthony.myloancalculator.repositories.LoanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class LoanViewModel (private val repository: LoanRepository) : ViewModel() {

    private val _loans = MutableStateFlow<List<Loan>>(emptyList())

    private val _loan = MutableStateFlow<Loan?>(null)

    val loans: StateFlow<List<Loan>> = _loans

    val loan: StateFlow<Loan?> = _loan

    fun saveLoan( loan: Loan
    ){
        viewModelScope.launch {
            repository.insertLoan(loan)
        }
    }

    fun loadLoans(){
        viewModelScope.launch {
            _loans.value = repository.searchAll()
        }
    }

    fun updateLoan(loan: Loan){
        viewModelScope.launch{
            _loan.value = repository.updateLoan(loan)
        }
    }
}