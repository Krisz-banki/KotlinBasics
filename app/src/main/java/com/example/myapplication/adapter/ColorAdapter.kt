package com.example.kotlinbasics.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.kotlinbasics.model.Color


class ColorAdapter(private val colors: List<Color>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val yearText: TextView = itemView.findViewById(R.id.yearText)
        val pantoneText: TextView = itemView.findViewById(R.id.pantoneText)
        val colorView: View = itemView.findViewById(R.id.colorView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_color, parent,
                false
            )
         return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colors[position]
        holder.nameText.text = color.name
        holder.yearText.text = color.year.toString()
        holder.pantoneText.text = color.pantone_value
        holder.colorView.setBackgroundColor(android.graphics.Color.parseColor(color.color))
    }

    override fun getItemCount() = colors.size
}