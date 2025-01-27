package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.model.User

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_list)

        val users = listOf(
            User("Név","Email cím", R.drawable.ic_launcher_background),
            User("Gipsz Jakab","gipszjakab68@gmail.com", R.drawable.ic_launcher_background)
        )

        val recyclerView: RecyclerView = findViewById(R.id.userListRecycleView)
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)
    }
}