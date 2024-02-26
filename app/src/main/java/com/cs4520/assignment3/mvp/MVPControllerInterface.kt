package com.cs4520.assignment3.mvp

interface MVPContractInterface {

    interface View {
        fun setInputOne(input: String)
        fun setInputTwo(input: String)
        fun setResult(result: String)
        fun showError(message: String)
        fun clearInputs()
    }

    interface Presenter {
        fun onAddClicked(inputOne: String, inputTwo: String)
        fun onSubtractClicked(inputOne: String, inputTwo: String)
        fun onMultiplyClicked(inputOne: String, inputTwo: String)
        fun onDivideClicked(inputOne: String, inputTwo: String)
    }

    interface Model {
        fun add(inputOne: String, inputTwo: String) : Double
        fun subtract(inputOne: String, inputTwo: String): Double
        fun multiply(inputOne: String, inputTwo: String) : Double
        fun divide(inputOne: String, inputTwo: String) : Double
    }

}