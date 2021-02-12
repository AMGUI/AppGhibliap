package com.example.etudiodibri.repositorio

import com.example.etudiodibri.model.DibreResponse
import retrofit2.Call
import retrofit2.http.GET

interface DibreRepositorio {
    fun request() : Call<List<DibreResponse>>
}