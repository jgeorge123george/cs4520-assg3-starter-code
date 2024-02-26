package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R

class MVPFragment : Fragment(), MVPContractInterface.View {

    private lateinit var inputFieldOne: EditText
    private lateinit var inputFieldTwo: EditText
    private lateinit var resultField: TextView
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var presenter: MVPPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mvp, container, false)

        inputFieldOne = view.findViewById(R.id.input_one)
        inputFieldTwo = view.findViewById(R.id.input_two)
        resultField = view.findViewById(R.id.result)
        addButton = view.findViewById(R.id.add_button)
        subtractButton = view.findViewById(R.id.subtract_button)
        multiplyButton = view.findViewById(R.id.multiply_button)
        divideButton = view.findViewById(R.id.divide_button)

        presenter = MVPPresenter(requireContext(),this)


        addButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            presenter.onAddClicked(inputOne, inputTwo)
        }

        subtractButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            presenter.onSubtractClicked(inputOne, inputTwo)
        }

        multiplyButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            presenter.onMultiplyClicked(inputOne, inputTwo)
        }

        divideButton.setOnClickListener {
            val inputOne = inputFieldOne.text.toString()
            val inputTwo = inputFieldTwo.text.toString()
            presenter.onDivideClicked(inputOne, inputTwo)
        }

        clearInputs()
        return view
    }

    override fun setInputOne(input: String) {
        inputFieldOne.setText(input)
    }

    override fun setInputTwo(input: String) {
        inputFieldTwo.setText(input)
    }

    override fun setResult(result: String) {
        resultField.text = getString(R.string.result, result)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun clearInputs() {
        inputFieldOne.text.clear()
        inputFieldTwo.text.clear()
    }
}
