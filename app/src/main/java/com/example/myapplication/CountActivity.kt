package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.network.CountService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountActivity : AppCompatActivity() {
    private lateinit var textviewCount: TextView
    private lateinit var countButton: Button
    private val apiKey = "?count"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_count)

        textviewCount = findViewById(R.id.result)
        countButton = findViewById(R.id.countButton)

        countButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val count = fetchCount()
                    if (count != null) {
                        textviewCount.text = "Count: $count"
                    } else {
                        textviewCount.text = "Hiba történt a számláló lekérésekor."
                    }
                } catch (e: Exception) {
                    Log.e("HIBA: Count", "Hiba a számláló megjelenítésében")
                    textviewCount.text = "Hiba történt a számláló megjelenítésében."
                }
            }
        }
    }

    private suspend fun fetchCount(): Int? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://banki13.komarom.net/2024/schleglk/controllers/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val countService = retrofit.create(CountService::class.java)

        return withContext(Dispatchers.IO) {
            try {
                val response = countService.getCount(apiKey)
                response.results
            } catch (e: Exception) {
                Log.e("CountActivity", "Error fetching count ", e)
                null
            }
        }
    }
}
