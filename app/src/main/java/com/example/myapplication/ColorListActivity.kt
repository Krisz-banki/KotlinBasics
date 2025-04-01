package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ColorAdapter
import com.example.myapplication.model.ColorResponse
import com.example.myapplication.network.ColorService
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ColorListActivity : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var fetchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_color_list)
        recyclerView = findViewById(R.id.colorRecyclerView)
        progressBar = findViewById(R.id.progressBar)
        fetchButton = findViewById(R.id.fetchColorsButton)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchButton.setOnClickListener {
            fetchColors()
        }
    }

    private fun fetchColors() {
        progressBar.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val colorService = retrofit.create(ColorService::class.java)
        colorService.getColors().enqueue(object : Callback<ColorResponse> {
            override fun onResponse(call: Call<ColorResponse>, response: Response<ColorResponse>) {
                if (response.isSuccessful) {
                    val colors = response.body()?.data
                    if (colors != null) {
                        recyclerView.adapter = ColorAdapter(colors)
                    }
                } else {
                    Log.e("ColorListActivity", "Error: ${response.errorBody()?.string()}")
                }
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<ColorResponse>, t: Throwable) {
                Log.e("ColorListActivity", "Error fetching colors", t)
                progressBar.visibility = View.GONE
            }
        })
    }
}