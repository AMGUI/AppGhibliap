package com.example.etudiodibri.view.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.etudiodibri.R
import com.example.etudiodibri.model.DibreResponse

class DibreAdapter(private val dibre :List<DibreResponse>):RecyclerView.Adapter<DibreAdapter.DibreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DibreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_dibre,parent,false)
        return DibreViewHolder(view)
    }

    override fun onBindViewHolder(holder: DibreViewHolder, position: Int) {
        val filme = dibre[position]
        holder.bind(filme)

    }

    override fun getItemCount() = dibre.size

    inner class DibreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name : TextView = itemView.findViewById(R.id.dibreFilmeName)
        fun bind(filme : DibreResponse){
            name.text = filme.title
        }

    }
}