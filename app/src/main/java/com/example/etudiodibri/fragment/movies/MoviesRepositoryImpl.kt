package com.example.etudiodibri.fragment.movies

import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.network.Ghibli
import retrofit2.Call

class MoviesRepositoryImpl(private val api: Ghibli): MoviesRepository {
    override fun requistarFilmes(): Call<List<GhibliResponse>> {
        return api.getDibre()
    }
}