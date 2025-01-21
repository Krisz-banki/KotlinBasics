package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.WeatherResponse
import com.example.myapplication.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {
//komment
    private lateinit var textviewTemp: TextView
    private lateinit var textviewTempmin: TextView
    private lateinit var textviewHumidity: TextView
    private lateinit var textviewWindSpeed: TextView
    private lateinit var weatherButton: Button
    private lateinit var EditTextCity: EditText
    private lateinit var resultTextView: TextView
    private val apiKey = "0db176500d087d078df1c33397cc1aa0"
    private var getCity = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)

        textviewTemp = findViewById(R.id.textview_temp)
        textviewTempmin = findViewById(R.id.textview_tempmin)
        textviewHumidity = findViewById(R.id.textview_humidity)
        textviewWindSpeed = findViewById(R.id.textview_windSpeed)
        weatherButton = findViewById(R.id.weatherButton)
        EditTextCity = findViewById(R.id.EditTextCity)
        resultTextView = findViewById(R.id.resultTextView)

        weatherButton.setOnClickListener{
            val cityName = EditTextCity.text

            if (cityName.isNotBlank()) {
                getCity = cityName.toString()
            } else {
                Toast.makeText(this, "Adj meg egy várost!", Toast.LENGTH_SHORT).show()
            }
            fetchWeatherData(getCity)

        }

    }

    private fun fetchWeatherData(varos: String){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        val call = weatherService.getWeather(varos,"metric", apiKey)

        call.enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful){
                    val weatherResponse = response.body()
                    if(weatherResponse != null){
                        val weatherInfo = weatherResponse.main.temp
                        textviewTemp.text = weatherInfo.toString()+"°C"
                        val weatherInfoMin = weatherResponse.main.feels_like
                        textviewTempmin.text = weatherInfoMin.toString()+"°C"
                        val weatherInfoHumidity = weatherResponse.main.humidity
                        textviewHumidity.text = weatherInfoHumidity.toString() + "%"
                        val weatherInfoWindSpeed = weatherResponse.wind.speed
                        textviewWindSpeed.text = weatherInfoWindSpeed.toString() +" km/h"
                        resultTextView.text = getCity
                    }
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("HIBA","Hiba az API kezelés során")
            }
        })
    }


}