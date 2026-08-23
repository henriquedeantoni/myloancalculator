package com.henrianthony.myloancalculator.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.henrianthony.myloancalculator.LoanApplication
import com.henrianthony.myloancalculator.R
import com.henrianthony.myloancalculator.model.Loan
import com.henrianthony.myloancalculator.model.LoanViewModel
import com.henrianthony.myloancalculator.model.LoanViewModelFactory
import kotlinx.coroutines.launch
import kotlin.getValue

class SimulationsActivity : androidx.appcompat.app.AppCompatActivity() {

    private val viewModel: LoanViewModel by viewModels {
        LoanViewModelFactory(
            (application as LoanApplication).repository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_simulations)

        var loanList: List<Loan>

        lifecycleScope.launch {
            viewModel.loans.collect { loans ->

                loanList = loans
            }
        }

        viewModel.loadLoans()
    }

}