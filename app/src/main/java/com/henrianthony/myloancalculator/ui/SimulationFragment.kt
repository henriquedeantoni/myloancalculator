package com.henrianthony.myloancalculator.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.henrianthony.myloancalculator.R

class SimulationFragment : Fragment(R.layout.fragments_simulation) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getLong("id", -1L) ?: -1L
        val name = arguments?.getString("name")

        val idView = view.findViewById<TextView>(_root_ide_package_.com.henrianthony.myloancalculator.R.id.tituloDetalhe)
        val nameView = view.findViewById<TextView>(_root_ide_package_.com.henrianthony.myloancalculator.R.id.resumoDetalhe)

        idView.text = id.toString()
        nameView.text = name ?: ""
    }
}