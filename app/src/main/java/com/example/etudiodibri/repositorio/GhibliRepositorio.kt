package com.example.etudiodibri.repositorio


import com.example.etudiodibri.model.GhibliResponse
import retrofit2.Call
import retrofit2.http.GET

interface GhibliRepositorio {
    fun request() : Call<List<GhibliResponse>>
}