package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var openGreetingButton: Button
    private lateinit var openCalculatorButton: Button
    private lateinit var openWeatherButton: Button
    private lateinit var openUserListButton: Button
    private lateinit var openRandomUserListButton: Button
    private lateinit var openCountButton: Button
    private lateinit var openColorListButton: Button
    private lateinit var openBeerListButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        openCalculatorButton = findViewById(R.id.openCalculatorButton)
        openBeerListButton = findViewById(R.id.openBeerListButton)
        openGreetingButton = findViewById(R.id.openGreetingButton)
        openWeatherButton = findViewById(R.id.openWeatherButton)
        openUserListButton = findViewById(R.id.openUserListButton)
        openRandomUserListButton = findViewById(R.id.openRandomUserListButton)
        openCountButton = findViewById(R.id.openCountButton)
        openColorListButton = findViewById(R.id.openColorListButton)

        openCalculatorButton.setOnClickListener{
        val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        openWeatherButton.setOnClickListener{
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        openCountButton.setOnClickListener{
            val intent = Intent(this, CountActivity::class.java)
            startActivity(intent)
        }
        openColorListButton.setOnClickListener{
            val intent = Intent(this, ColorListActivity::class.java)
            startActivity(intent)
        }

        openGreetingButton.setOnClickListener{
            val intent = Intent(this, GreetingsActivity::class.java)
            startActivity(intent)
        }
        openUserListButton.setOnClickListener{
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
        openRandomUserListButton.setOnClickListener{
            val intent = Intent(this, RandomUserListActivity::class.java)
            startActivity(intent)
        }
        openBeerListButton.setOnClickListener{
            val intent = Intent(this, BeerActivity::class.java)
            startActivity(intent)
        }
    }

}
