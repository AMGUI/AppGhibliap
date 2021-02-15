package com.example.etudiodibri.network


import com.example.etudiodibri.model.GhibliResponse
import retrofit2.Call
import retrofit2.http.GET

interface Ghibli {
    @GET("films")
    fun getDibre(): Call<List<GhibliResponse>>
}