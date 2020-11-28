package com.ankush.calculatork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var digit_on_screen = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    val result_id = findViewById<Button>(R.id.result_id)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        result_id.text = "0"

        initializeButtons()

    }

    private fun initializeButtons() {
        functionalButtons()
        operationalButtons()
        numericalButtons()

    }

    private fun numericalButtons() {

        val one_btn = findViewById<Button>(R.id.one_btn)
        one_btn.setOnClickListener{
            appendToDigitOnScreen("1")
        }

        val two_btn = findViewById<Button>(R.id.two_btn)
        two_btn.setOnClickListener{
            appendToDigitOnScreen("2")
        }

        val three_btn = findViewById<Button>(R.id.three_btn)
        three_btn.setOnClickListener{
            appendToDigitOnScreen("3")
        }

        val four_btn = findViewById<Button>(R.id.four_btn)
        four_btn.setOnClickListener{
            appendToDigitOnScreen("4")
        }

        val five_btn = findViewById<Button>(R.id.five_btn)
        five_btn.setOnClickListener{
            appendToDigitOnScreen("5")
        }

        val six_btn = findViewById<Button>(R.id.six_btn)
        six_btn.setOnClickListener{
            appendToDigitOnScreen("6")
        }

        val seven_btn = findViewById<Button>(R.id.seven_btn)
        seven_btn.setOnClickListener{
            appendToDigitOnScreen("7")
        }

        val eight_btn = findViewById<Button>(R.id.eight_btn)
        eight_btn.setOnClickListener{
            appendToDigitOnScreen("8")
        }

        val nine_btn = findViewById<Button>(R.id.nine_btn)
        nine_btn.setOnClickListener{
            appendToDigitOnScreen("9")
        }

        val zero_btn = findViewById<Button>(R.id.zero_btn)
        zero_btn.setOnClickListener{
            appendToDigitOnScreen("0")
        }

        val dot_btn = findViewById<Button>(R.id.dot_btn)
        dot_btn.setOnClickListener{
            appendToDigitOnScreen(".")
        }

    }

    private fun appendToDigitOnScreen(digit: String) {

        digit_on_screen.append(digit)

        result_id.text = digit_on_screen.toString()
    }

    private fun operationalButtons() {

        val addition_btn = findViewById<Button>(R.id.addition_btn)
        addition_btn.setOnClickListener {
            selectOperation('A')
        }

        val subtract_btn = findViewById<Button>(R.id.subtract_btn)
        subtract_btn.setOnClickListener {
            selectOperation('B')
        }

        val divide_btn = findViewById<Button>(R.id.divide_btn)
        divide_btn.setOnClickListener {
            selectOperation('D')
        }

        val multipy_btn = findViewById<Button>(R.id.multipy_btn)
        multipy_btn.setOnClickListener {
            selectOperation('M')
        }

    }

    private fun selectOperation(c: Char) {

        operation = c
        leftHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()
        result_id.text = "0"
    }

    private fun functionalButtons() {

        val clear_everything_btn = findViewById<Button>(R.id.clear_everything_btn)
        clear_everything_btn.setOnClickListener {
            digit_on_screen.clear()
            result_id.text = "0"
        }

        val clear_btn = findViewById<Button>(R.id.clear_btn)
        clear_btn.setOnClickListener {

            if (digit_on_screen.length <= 0) {
                return@setOnClickListener
            } else {
                clearDigit()
            }

        }

        val backspace_btn = findViewById<Button>(R.id.backspace_btn)
        backspace_btn.setOnClickListener {

            if (digit_on_screen.length <= 0) {
                return@setOnClickListener
            } else {
                clearDigit()
            }
        }

        val equal_btn = findViewById<Button>(R.id.equal_btn)
        equal_btn.setOnClickListener {
            performMathOperation()
        }

    }

    private fun performMathOperation() {

        rightHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()

        when (operation) {

            'A' -> {
                val sum = OperationsHelper.add(leftHandSide, rightHandSide)
                result_id.text = sum.toString()
                digit_on_screen.append(sum)
            }

            'S' -> {
                val subtract = OperationsHelper.subtract(leftHandSide, rightHandSide)
                result_id.text = subtract.toString()
                digit_on_screen.append(subtract)
            }

            'M' -> {
                val multiply = OperationsHelper.multiply(leftHandSide, rightHandSide)
                result_id.text = multiply.toString()
                digit_on_screen.append(multiply)
            }

            'D' -> {
                val divide = OperationsHelper.divide(leftHandSide, rightHandSide)
                result_id.text = divide.toString()
                digit_on_screen.append(divide)
            }
        }
    }

    private fun clearDigit() {

        val length = digit_on_screen.length

        digit_on_screen.deleteCharAt(length - 1)
        result_id.text = digit_on_screen.toString()
    }

}