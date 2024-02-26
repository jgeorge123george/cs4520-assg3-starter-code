package com.cs4520.assignment3.mvp

import android.widget.Toast
import com.cs4520.assignment3.Util
import android.content.Context
import android.view.Gravity
import com.cs4520.assignment3.R


class MVPPresenter(private val context: Context,_view: MVPContractInterface.View): MVPContractInterface.Presenter {

    private var view: MVPContractInterface.View = _view
    private var model: MVPContractInterface.Model = MVPModel();

    override fun onAddClicked(inputOne: String, inputTwo: String) {
        if( Util.validInput(inputOne) && Util.validInput(inputTwo)){
            val result = model.add(inputOne,inputTwo)
            view.setResult(result.toString())
            view.clearInputs()
        }else{
            showToast()
        }
    }

    override fun onSubtractClicked(inputOne: String, inputTwo: String) {
        if( Util.validInput(inputOne) && Util.validInput(inputTwo)){
            val result = model.subtract(inputOne,inputTwo)
            view.setResult(result.toString())
            view.clearInputs()
        }else{
            showToast()
        }
    }

    override fun onMultiplyClicked(inputOne: String, inputTwo: String) {
        if( Util.validInput(inputOne) && Util.validInput(inputTwo)){
            val result = model.multiply(inputOne,inputTwo)
            view.setResult(result.toString())
            view.clearInputs()
        }else{
            showToast()
        }
    }

    override fun onDivideClicked(inputOne: String, inputTwo: String) {
        if( Util.validInput(inputOne) && Util.validInput(inputTwo)){
            val result = model.divide(inputOne,inputTwo)
            view.setResult(result.toString())
            view.clearInputs()
        }else{
            showToast()
        }
    }

    private fun showToast() {
        val toast = Toast.makeText(context,
            context.getString(R.string.input_error_please_enter_numeric_values), Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }
}