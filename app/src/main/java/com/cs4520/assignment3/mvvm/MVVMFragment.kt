package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.Util


class MVVMFragment : Fragment() {

    private lateinit var viewModel: CalculatorViewModel

    private lateinit var inputFieldOne: EditText
    private lateinit var inputFieldTwo: EditText
    private lateinit var resultField: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_mvvm, container, false)

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        inputFieldOne = view.findViewById(R.id.input_one)
        inputFieldTwo = view.findViewById(R.id.input_two)
        resultField = view.findViewById(R.id.result)

        val addButton: Button = view.findViewById(R.id.add_button)




        addButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            if (Util.validInput(inputOne) && Util.validInput(inputTwo)) {
                viewModel.performAddition(inputOne, inputTwo)
                clearInputs()
            } else {
                showToast()
            }

        }

        val subtractButton: Button = view.findViewById(R.id.subtract_button)
        subtractButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            if (Util.validInput(inputOne) && Util.validInput(inputTwo)) {
                viewModel.performSubtract(inputOne, inputTwo)
                clearInputs()
            } else {
                showToast()
            }
        }

        val multiplyButton: Button = view.findViewById(R.id.multiply_button)
        multiplyButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            if (Util.validInput(inputOne) && Util.validInput(inputTwo)) {
                viewModel.performMultiply(inputOne, inputTwo)
                clearInputs()
            } else {
                showToast()
            }
        }

        val divideButton: Button = view.findViewById(R.id.divide_button)
        divideButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            if (Util.validInput(inputOne) && Util.validInput(inputTwo)) {
                viewModel.performDivide(inputOne, inputTwo)
                clearInputs()
            } else {
                showToast()
            }
        }

        viewModel.result.observe(viewLifecycleOwner) { result ->
            resultField.text = getString(R.string.result, result)
        }

        return view
    }

    fun clearInputs() {
        inputFieldOne.text.clear()
        inputFieldTwo.text.clear()
    }

    private fun showToast() {
        val toast = Toast.makeText(
            context,
            getString(R.string.input_error_please_enter_numeric_values), Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }
}