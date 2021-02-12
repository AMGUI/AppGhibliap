package com.example.etudiodibri.repositorio

import com.example.etudiodibri.model.DibreResponse
import com.example.etudiodibri.network.ObjRetrofit
import retrofit2.Call

class ImplementRepositorio: DibreRepositorio {
    override fun request(): Call<List<DibreResponse>> {
    return ObjRetrofit.obterEndPoit().getDibre()
    }

}