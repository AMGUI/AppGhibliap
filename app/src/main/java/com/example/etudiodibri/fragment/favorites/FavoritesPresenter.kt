package com.example.etudiodibri.fragment.favorites

class FavoritesPresenter(
        private val view: FavoritesContract.View,
        private val repository: FavoritesRepository) : FavoritesContract.Presenter {

    override fun pegarFavoritos() {
        val listaFilmes = repository.pegarFavoritos()
        view.mostraFavoritos(listaFilmes)
    }
}