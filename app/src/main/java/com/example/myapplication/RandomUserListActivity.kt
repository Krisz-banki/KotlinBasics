package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.RandomUserAdapter
import com.example.myapplication.model.RUser
import com.example.myapplication.model.RandomUserResponse
import com.example.myapplication.network.RandomUserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random_users)

        val recyclerView: RecyclerView = findViewById(R.id.randomUserListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try{
                val randomUsers = fetchRandomUserList()
                if(!randomUsers.isNullOrEmpty()){
                    recyclerView.adapter = RandomUserAdapter(randomUsers)
                }
            } catch (e: Exception){
                Log.e("HIBA: RandomUserListActivity","Hiba a lista megjelenítésében")
            }
        }
    }

    private suspend fun fetchRandomUserList(): List<RUser>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val randomUserService = retrofit.create(RandomUserService::class.java)

        return withContext(Dispatchers.IO) {
            try{
                val response = randomUserService.getRandomUsers(10)
                response.results
            } catch(e:Exception){
                Log.e("UserListActivity","Error fetching user list",e)
                null
            }
        }

    }
}