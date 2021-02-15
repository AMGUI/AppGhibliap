package com.example.etudiodibri.repositorio


import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.network.ObjRetrofit
import retrofit2.Call

class ImplementRepositorio: GhibliRepositorio {
    override fun request(): Call<List<GhibliResponse>> {
    return ObjRetrofit.obterEndPoit().getDibre()
    }

}