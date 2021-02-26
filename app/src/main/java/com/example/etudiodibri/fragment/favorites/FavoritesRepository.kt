package com.example.etudiodibri.fragment.favorites

import com.example.etudiodibri.model.GhibliResponse

interface FavoritesRepository {
    fun pegarFavoritos(): ArrayList<GhibliResponse>
}