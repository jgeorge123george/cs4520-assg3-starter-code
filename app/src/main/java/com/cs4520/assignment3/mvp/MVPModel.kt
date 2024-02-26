package com.cs4520.assignment3.mvp

class MVPModel : MVPContractInterface.Model {


    override fun add(inputOne: String, inputTwo: String): Double {
        return inputOne.toDouble() + inputTwo.toDouble()
    }

    override fun subtract(inputOne: String, inputTwo: String): Double {
        return inputOne.toDouble() - inputTwo.toDouble()
    }

    override fun multiply(inputOne: String, inputTwo: String): Double {
        return inputOne.toDouble() * inputTwo.toDouble()
    }

    override fun divide(inputOne: String, inputTwo: String): Double {
        return inputOne.toDouble() / inputTwo.toDouble()
    }
}
