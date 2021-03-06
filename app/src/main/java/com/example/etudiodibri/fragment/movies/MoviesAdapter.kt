package com.example.etudiodibri.fragment.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.etudiodibri.R
import com.example.etudiodibri.fragment.favorites.FavoritManeger
import com.example.etudiodibri.model.GhibliResponse
import retrofit2.Response

class MoviesAdapter(private val dibre :List<GhibliResponse>, private val onMovieSelect: (filme: GhibliResponse, praSalvar: Boolean) -> Unit):RecyclerView.Adapter<MoviesAdapter.DibreViewHolder>() {

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
        private  val imagemLayout : ImageView = itemView.findViewById(R.id.totoroImg)
        private  val favButton : ImageButton = itemView.findViewById(R.id.favButton)

        fun bind(filme : GhibliResponse){
           // FavoritManeger.favoritList.add(filme)
            name.text = filme.title
            val imageRes = filme.getThumbnail(itemView.context)
            imagemLayout.setImageResource(imageRes)
            itemView.setOnClickListener { onMovieSelect(filme, false) }
            favButton.setOnClickListener { onMovieSelect(filme, true) }
        }
    }
}