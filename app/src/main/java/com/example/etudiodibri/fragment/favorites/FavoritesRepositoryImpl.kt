package com.example.etudiodibri.fragment.favorites

import android.content.SharedPreferences
import com.example.etudiodibri.model.GhibliResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class FavoritesRepositoryImpl(private val sharedPrefs: SharedPreferences?, private val gson: Gson): FavoritesRepository {
    override fun pegarFavoritos(): ArrayList<GhibliResponse> {
        val json = sharedPrefs?.getString("favoritos", "")
        val type: Type = object : TypeToken<ArrayList<GhibliResponse>>() {}.type
        return gson.fromJson(json, type)
    }
}