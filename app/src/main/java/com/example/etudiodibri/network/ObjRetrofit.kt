package com.example.etudiodibri.network

import com.example.etudiodibri.aplication.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ObjRetrofit {
    private fun retrofitClient():Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun obterEndPoit(): Dibre {
        val client  = retrofitClient()

        return client.create(Dibre::class.java)

    }
}