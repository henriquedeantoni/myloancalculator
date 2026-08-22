package com.henrianthony.myloancalculator.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.henrianthony.myloancalculator.repositories.LoanRepository

class LoanViewModelFactory(
    private val repository: LoanRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(LoanViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return LoanViewModelFactory(repository) as T
        }

        throw IllegalArgumentException(
            "ViewModel unknown"
        )
    }
}