package com.example.etudiodibri.network

import com.example.etudiodibri.model.DibreResponse
import retrofit2.Call
import retrofit2.http.GET

interface Dibre {
    @GET("films")
    fun getDibre(): Call<List<DibreResponse>>
}