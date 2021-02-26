package com.example.etudiodibri.fragment.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.etudiodibri.R
import com.example.etudiodibri.fragment.movies.MoviesAdapter
import com.example.etudiodibri.model.GhibliResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment: Fragment(), FavoritesContract.View {

    private lateinit var presenter: FavoritesPresenter
    private lateinit var filmesAdapter: MoviesAdapter
    private val filmes: ArrayList<GhibliResponse> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gson = Gson()
        val sharedPrefs = activity?.getSharedPreferences("studio_ghibli", 0)
        val repository = FavoritesRepositoryImpl(sharedPrefs, gson)
        presenter = FavoritesPresenter(this, repository)
        filmesAdapter = MoviesAdapter(filmes) { _, _ ->  }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        presenter.pegarFavoritos()
    }

    override fun mostraFavoritos(listaFilmes: ArrayList<GhibliResponse>) {
        atualizarFilmes(listaFilmes)
    }

    private fun setupRecyclerView() {
        listaFavoritos.apply {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = filmesAdapter
        }
    }

    private fun atualizarFilmes(data: ArrayList<GhibliResponse>) {
        this.filmes.clear()
        this.filmes.addAll(data)
        this.filmesAdapter.notifyDataSetChanged()
    }
}