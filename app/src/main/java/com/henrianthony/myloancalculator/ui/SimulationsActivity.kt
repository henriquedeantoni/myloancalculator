package com.henrianthony.myloancalculator.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henrianthony.myloancalculator.LoanApplication
import com.henrianthony.myloancalculator.R
import com.henrianthony.myloancalculator.data.MockNews
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

        val buttonReturn = findViewById<Button>(R.id.button_returnMain)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_simulations)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.loadLoans()

        lifecycleScope.launch {
            viewModel.loans.collect { loans ->

                recyclerView.adapter = SimulationsAdapter(loans) { loan ->

                    val fragment = SimulationFragment().apply {
                        arguments = Bundle().apply {
                            putLong("id", loan.id ?: -1L)
                            putString("name", loan.name)
                        }
                    }

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                                R.id.fragment_container,
                            fragment
                        )
                        .addToBackStack(null)
                        .commit()
                }
            }
        }

        buttonReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}