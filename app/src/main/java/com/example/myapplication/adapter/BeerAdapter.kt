package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.ColorAdapter.ColorViewHolder
import com.example.myapplication.model.Beer

class BeerAdapter (private val beerList: List<Beer>):
    RecyclerView.Adapter<BeerAdapter.BeerViewHolder>(){

    class BeerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val descriptionText: TextView = itemView.findViewById(R.id.descriptionText)
        val contributedByText: TextView = itemView.findViewById(R.id.contributedByText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder{
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_beer, parent,
                false
            )
        return BeerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int){
        val beer = beerList[position]
        holder.nameText.text = beer.name
        holder.descriptionText.text = beer.description
        holder.contributedByText.text =  beer.contributed_by
    }

    override fun getItemCount() = beerList.size
}