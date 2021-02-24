package com.example.etudiodibri.network

import com.example.etudiodibri.application.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ObjRetrofit {
    private fun retrofitClient():Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun obterEndPoit(): Ghibli {
        val client  = retrofitClient()

        return client.create(Ghibli::class.java)

    }
}