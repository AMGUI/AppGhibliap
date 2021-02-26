package com.example.etudiodibri.fragment.favorites

import com.example.etudiodibri.model.GhibliResponse

class FavoritesContract {
    interface View {
        fun mostraFavoritos(listaFilmes: ArrayList<GhibliResponse>)
    }
    interface Presenter {
        fun pegarFavoritos()
    }
}