package com.example.etudiodibri.contratos


import com.example.etudiodibri.model.GhibliResponse

interface ContratoGibli {
    interface View{
        fun showdados(Ghiblilista : List<GhibliResponse>)
    }

    interface Presenter{

        fun requistadados()
    }
}