package com.example.etudiodibri.fragment.movies

import com.example.etudiodibri.model.GhibliResponse
import retrofit2.Call

interface MoviesRepository {
    fun requistarFilmes(): Call<List<GhibliResponse>>
}