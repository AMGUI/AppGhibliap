package com.example.etudiodibri.fragment.movies

import android.util.Log
import com.example.etudiodibri.model.GhibliResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesPresenter(private val view: MoviesContract.View, private val repository: MoviesRepository) : MoviesContract.Presenter {

    override fun requisitarFilmes() {
        view.exibirLoading()
        val request = repository.requistarFilmes()
        request.enqueue(object : Callback<List<GhibliResponse>> {
            override fun onResponse(call: Call<List<GhibliResponse>>, response: Response<List<GhibliResponse>>) {


                if (response.isSuccessful && response.body() != null) {
                    view.exibirFilmes(response.body()!!)
                    view.esconderLoading()
                } else {
                    Log.e("API", "Erro ao obter dados")
                    view.esconderLoading(true)
                }
            }

            override fun onFailure(call: Call<List<GhibliResponse>>, t: Throwable) {
                Log.e("API", t.message, t)
                view.esconderLoading(true)
            }
        })
    }

    override fun aoClicarNoFilme(filme: GhibliResponse) {
        view.mostrarDetalhesFilme(filme)
    }

    override fun salvarComoFavorito(filme: GhibliResponse) {
        repository.salvarComoFavorito(filme)
    }
}