package com.cs4520.assignment3

class Util {

    companion object {
        fun validInput(str : String) : Boolean
        {

            val intRegex = """^-?\d+$""".toRegex() // Integer
            val floatRegex = """^-?\d+\.\d+$""".toRegex() // Float
            val doubleRegex = """^-?\d+(\.\d+)?([eE][+-]?\d+)?$""".toRegex() // Double

            return str.matches(intRegex) || str.matches(floatRegex) || str.matches(doubleRegex)
        }
    }

}