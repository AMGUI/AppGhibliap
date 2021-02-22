package com.example.etudiodibri.presenter

import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.example.etudiodibri.Activity.MainActivity
import com.example.etudiodibri.R

import com.example.etudiodibri.contratos.ContratoGibli

import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.repositorio.GhibliRepositorio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterGhibli(private val view: MainActivity, private val repositorio: GhibliRepositorio):ContratoGibli.Presenter {
    override fun requistadados() {
        val requisitado = repositorio.request()

        requisitado.enqueue(object: Callback<List<GhibliResponse>>{
            override fun onResponse(
                call: Call<List<GhibliResponse>>,
                response: Response<List<GhibliResponse>>
            ) {

                if (response.isSuccessful && response.body() != null) {

                    view.pararLoanding()
                    Log.d("OKAY", response.body().toString())
                    view.showdados(response.body()!!)
                    return
                }

            }

            override fun onFailure(call: Call<List<GhibliResponse>>, t: Throwable) {
                Log.e("ERRO ERMEK", t.message, t)
            }

        })

    }

}