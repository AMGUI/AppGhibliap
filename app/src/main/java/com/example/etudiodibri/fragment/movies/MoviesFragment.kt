package com.example.etudiodibri.fragment.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.etudiodibri.R
import com.example.etudiodibri.fragment.ErroLoadingFragment
import com.example.etudiodibri.fragment.details.DetalhesFragment
import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.network.ObjRetrofit
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), MoviesContract.View {
    lateinit var moviesAdapter: MoviesAdapter
    lateinit var presenter: MoviesPresenter

    private val filmes: ArrayList<GhibliResponse> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obter Gson
        val gson = Gson()
        // Obter SharedPreferencs
        val sharedPrefs = activity?.getSharedPreferences("studio_ghibli", 0)
        // Obter api
        val api = ObjRetrofit.obterEndPoit()
        // Obter repository e passar api
        val repository = MoviesRepositoryImpl(api, sharedPrefs = sharedPrefs, gson = gson)
        // Iniciar presenter e passar o repository
        presenter = MoviesPresenter(this, repository)
        // Iniciar adapter
        moviesAdapter = MoviesAdapter(filmes) { filme, praSalvar ->
            if (praSalvar)
                presenter.salvarComoFavorito(filme)
            else
                presenter.aoClicarNoFilme(filme)
        }
        // Configurar recyclerView
        setupRecyclerView()
        // Realizar chamada da API
        presenter.requisitarFilmes()
    }

    private fun setupRecyclerView() {
        listaFilmes.apply {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = moviesAdapter
        }
    }

    private fun atualizarFilmes(data: List<GhibliResponse>) {
        this.filmes.clear()
        this.filmes.addAll(data)
        this.moviesAdapter.notifyDataSetChanged()
    }

    override fun exibirFilmes(filmes: List<GhibliResponse>) {
        atualizarFilmes(filmes)
    }

    override fun mostrarDetalhesFilme(filme: GhibliResponse) {
        val fragment = DetalhesFragment.newInstance(filme)
        fragmentManager
                    ?.beginTransaction()
                    ?.add(R.id.fragmentContainer, fragment)
                    ?.addToBackStack("DETALHES_FRAGMENT")
                    ?.commit()
    }

    override fun exibirLoading() {
        if(activity is OnLoadingListener) {
            val listener = activity as OnLoadingListener
            listener.onLoadingChange(isLoading = true)
        }
    }

    override fun esconderLoading(hasError: Boolean) {
        if(activity is OnLoadingListener) {
            val listener = activity as OnLoadingListener
            listener.onLoadingChange(isLoading = false, hasError)
        }
    }

    interface OnLoadingListener {
        fun onLoadingChange(isLoading: Boolean, hasError: Boolean = false)
    }
}