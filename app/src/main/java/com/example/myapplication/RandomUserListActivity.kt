package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.model.RandomUserResponse
import com.example.myapplication.model.User
import com.example.myapplication.model.WeatherResponse
import com.example.myapplication.network.RandomUserService
import com.example.myapplication.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_users)


//        val recyclerView: RecyclerView = findViewById(R.id.userListRecycleView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = UserAdapter(users)
    }

    private fun fetchRandomUserList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me*")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val RandomUserService = retrofit.create(RandomUserService::class.java)

        val call = RandomUserService.getRandomUsers(10)

        call.enqueue(object : Callback<RandomUserResponse> {
            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ) {
                if (response.isSuccessful) {
                    val randomUserResponse = response.body()
                    if(randomUserResponse != null){
                        Log.e("Eredmény: ",randomUserResponse.results.toString())
                    }
                }
            }

            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                Log.e("HIBA", "Hiba az API kezelés során")
            }
        })
    }
}