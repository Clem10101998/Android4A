package com.github.clem10101998.androidkotlin4a.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.clem10101998.androidkotlin4a.R
import kotlinx.android.synthetic.main.row_layout.view.*

class ListAdapter(private val values: List<Donnees>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //val View: View = itemView.icon


            val txtHeader: TextView = itemView.firstLine
            val txtFooter: TextView = itemView.secondLine

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = values[position]

        holder.txtHeader.text = "Movie's title: " +name.title
        holder.txtFooter.text = "Producer: " +name.producer

    }

    override fun getItemCount(): Int{
        return values.size
    }


}
