package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun performAddition(inputOne: String, inputTwo: String) {
        try {
            val num1 = inputOne.toDouble()
            val num2 = inputTwo.toDouble()
            val sum = Calculation.add(num1, num2)
            _result.value = sum.toString()
        } catch (e: NumberFormatException) {
            _result.value = "Invalid input. Please enter valid numbers."
        }
    }

    fun performSubtract(inputOne: String, inputTwo: String) {
        try {
            val num1 = inputOne.toDouble()
            val num2 = inputTwo.toDouble()
            val result = Calculation.subtract(num1, num2)
            _result.value = result.toString()
        } catch (e: NumberFormatException) {
            _result.value = "Invalid input. Please enter valid numbers."
        }
    }


    fun performMultiply(inputOne: String, inputTwo: String) {
        try {
            val num1 = inputOne.toDouble()
            val num2 = inputTwo.toDouble()
            val result = Calculation.multiply(num1, num2)
            _result.value = result.toString()
        } catch (e: NumberFormatException) {
            _result.value = "Invalid input. Please enter valid numbers."
        }
    }

    fun performDivide(inputOne: String, inputTwo: String) {
        try {
            val num1 = inputOne.toDouble()
            val num2 = inputTwo.toDouble()
            val result = Calculation.divide(num1, num2)
            _result.value = result.toString()
        } catch (e: NumberFormatException) {
            _result.value = "Invalid input. Please enter valid numbers."
        }
    }


}