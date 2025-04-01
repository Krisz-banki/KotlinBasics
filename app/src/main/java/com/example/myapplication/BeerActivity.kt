package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.BeerAdapter
import com.example.myapplication.adapter.ColorAdapter
import com.example.myapplication.adapter.RandomUserAdapter
import com.example.myapplication.model.Beer
import com.example.myapplication.model.BeerResponse
import com.example.myapplication.model.ColorResponse
import com.example.myapplication.model.RUser
import com.example.myapplication.network.BeerService
import com.example.myapplication.network.ColorService
import com.example.myapplication.network.RandomUserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerActivity  : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fetchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_beer)

        recyclerView = findViewById(R.id.beerRecyclerView)
        fetchButton = findViewById(R.id.fetchBeersButton)
        recyclerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            try{
                val beers = fetchBeerList()
                if(!beers.isNullOrEmpty()){
                    recyclerView.adapter = BeerAdapter(beers)
                }
            } catch (e: Exception){
                Log.e("HIBA: BeerListActivity","Hiba a lista megjelenítésében")
            }
        }
    }

    private suspend fun fetchBeerList(): List<Beer>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://punkapi.online/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val BeerService = retrofit.create(BeerService::class.java)

        return withContext(Dispatchers.IO) {
            try{
                val response = BeerService.getBeers()
                response
            } catch(e:Exception){
                Log.e("BeerListActivity","Error fetching user list",e)
                null
            }
        }

    }
}