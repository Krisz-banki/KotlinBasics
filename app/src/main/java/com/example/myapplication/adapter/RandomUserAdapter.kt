package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.RUser
import com.example.myapplication.model.User

class RandomUserAdapter (private val randomUserList: List<RUser>):
    RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>(){

    class RandomUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val profileImage: ImageView = itemView.findViewById(R.id.imageview_profile)
        val nameText: TextView = itemView.findViewById(R.id.textview_name)
        val emailText: TextView = itemView.findViewById(R.id.textview_email)
        val countryText: TextView = itemView.findViewById(R.id.textview_country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_random_user,parent,false)
        return RandomUserViewHolder(view)
    }
    override fun onBindViewHolder(holder:RandomUserViewHolder, position: Int){
        val randomUser = randomUserList[position]
        holder.nameText.text = randomUser.name.first+" "+randomUser.name.last
        holder.emailText.text = randomUser.email
        holder.countryText.text =  randomUser.location.country

        Glide.with(holder.itemView.context)
            .load(randomUser.picture.medium)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(holder.profileImage)
    }

    override fun getItemCount() = randomUserList.size
}