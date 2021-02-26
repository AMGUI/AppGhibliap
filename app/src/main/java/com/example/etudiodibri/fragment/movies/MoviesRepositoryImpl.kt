package com.example.etudiodibri.fragment.movies

import android.content.SharedPreferences
import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.network.Ghibli
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import java.lang.reflect.Type
import java.util.ArrayList

class MoviesRepositoryImpl(private val api: Ghibli, private val sharedPrefs: SharedPreferences?, private val gson: Gson): MoviesRepository {
    override fun requistarFilmes(): Call<List<GhibliResponse>> {
        return api.getDibre()
    }

    override fun salvarComoFavorito(filme: GhibliResponse) {
        val listaFilmes = getArrayList()
        if(getArrayList().isEmpty()) {
            saveArrayList(arrayListOf(filme))
        } else {
            listaFilmes.add(filme)
            saveArrayList(listaFilmes)
        }
    }

    private fun saveArrayList(list: ArrayList<GhibliResponse>) {
        val editor: SharedPreferences.Editor? = sharedPrefs?.edit()
        val json: String = gson.toJson(list)
        editor?.putString("favoritos", json)
        editor?.apply()
    }

    private fun getArrayList(): ArrayList<GhibliResponse> {
        val json = sharedPrefs?.getString("favoritos", "[]")
        val type: Type = object : TypeToken<ArrayList<GhibliResponse>>() {}.type
        return gson.fromJson(json, type)
    }
}