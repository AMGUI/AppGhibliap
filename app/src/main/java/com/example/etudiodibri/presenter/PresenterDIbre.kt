package com.example.etudiodibri.presenter

import android.util.Log
import com.example.etudiodibri.MainActivity
import com.example.etudiodibri.contratos.ContratoDibri
import com.example.etudiodibri.model.DibreResponse
import com.example.etudiodibri.repositorio.DibreRepositorio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterDIbre(private val view: MainActivity, private val repositorio: DibreRepositorio):ContratoDibri.Presenter {
    override fun requistadados() {
        val requisitado = repositorio.request()
        requisitado.enqueue(object: Callback<List<DibreResponse>>{
            override fun onResponse(
                call: Call<List<DibreResponse>>,
                response: Response<List<DibreResponse>>
            ) {

                if (response.isSuccessful && response.body() != null) {
                    Log.d("OKAY", response.body().toString())
                    view.showdados(response.body()!!)
                    return
                }

            }

            override fun onFailure(call: Call<List<DibreResponse>>, t: Throwable) {
                Log.e("ERRO ERMEK", t.message, t)
            }

        })

    }

}