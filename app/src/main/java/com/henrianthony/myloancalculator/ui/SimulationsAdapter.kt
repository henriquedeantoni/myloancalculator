package com.henrianthony.myloancalculator.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.henrianthony.myloancalculator.R
import com.henrianthony.myloancalculator.model.Loan

class SimulationsAdapter(
    private val loans: List<Loan>,
    private val onClick: (Loan) -> Unit
) : RecyclerView.Adapter<SimulationsAdapter.LoanViewHolder>() {

    class LoanViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val name: TextView =
            itemView.findViewById(R.id.text_assetValueName)

        val amount: TextView =
            itemView.findViewById(R.id.text_loanAmountValue)

        val months: TextView =
            itemView.findViewById(R.id.text_loanPeriodValue)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LoanViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.fragments_simulation,
                parent,
                false
            )

        return LoanViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: LoanViewHolder,
        position: Int
    ) {

        val loan = loans[position]

        holder.name.text = loan.name
        holder.amount.text = "Valor: ${loan.loanAmount}"
        holder.months.text = "Parcelas: ${loan.months}"

        holder.itemView.setOnClickListener {
            onClick(loan)
        }
    }

    override fun getItemCount(): Int {
        return loans.size
    }
}