package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class GreetingsActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var greetingButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greetings)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        nameEditText = findViewById(R.id.nameEditText)
        greetingButton = findViewById(R.id.greetingButton)
        resultTextView = findViewById(R.id.resultTextView)

        greetingButton.setOnClickListener {
            val name = nameEditText.text
            if (name.isNotBlank()) {
                val greetingText = when {
                    name.length <= 3 -> "Helló $name! De rövid neved van!"
                    name.length >= 10 -> "Helló $name! De hosszú neved van!"
                    else -> "Helló $name!"
                }
                hideKeyboard()
                nameEditText.text.clear()
                resultTextView.text = greetingText
            } else {
                Toast.makeText(this, "Add meg a neved!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(nameEditText.windowToken, 0)
    }

}