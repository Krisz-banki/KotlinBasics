package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    private lateinit var secondNumber: EditText
    private lateinit var firstNumber: EditText
    private lateinit var delete: Button
    private lateinit var sum: Button
    private lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firstNumber = findViewById(R.id.firstNumber)
        secondNumber = findViewById(R.id.secondNumber)
        delete = findViewById(R.id.delete)
        sum = findViewById(R.id.sum)
        result = findViewById(R.id.result)

        sum.setOnClickListener{
            val firstNumber = firstNumber.text.toString().toInt()
            val secondNumber = secondNumber.text.toString().toInt()
            result.text = "Eredmény: "+(firstNumber+secondNumber)
            hideKeyboard();
        }
        delete.setOnClickListener{
            firstNumber.text.clear()
            secondNumber.text.clear()
            result.text = "Eredmény: -"
            hideKeyboard();
        }
    }

    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(firstNumber.windowToken, 0)
        imm.hideSoftInputFromWindow(secondNumber.windowToken, 0)
    }
}