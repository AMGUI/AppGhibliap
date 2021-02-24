package com.example.etudiodibri.fragment.movies

import com.example.etudiodibri.model.GhibliResponse

interface MoviesContract {
    interface View {
        fun exibirFilmes(filmes: List<GhibliResponse>)
        fun exibirLoading()
        fun esconderLoading(hasError: Boolean = false)
        fun mostrarDetalhesFilme(filme: GhibliResponse)
    }

    interface Presenter {
        fun requisitarFilmes()
        fun aoClicarNoFilme(filme: GhibliResponse)
    }
}