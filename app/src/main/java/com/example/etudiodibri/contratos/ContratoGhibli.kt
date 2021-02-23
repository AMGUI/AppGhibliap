package com.example.etudiodibri.contratos


import com.example.etudiodibri.fragment.LoandingFragment
import com.example.etudiodibri.model.GhibliResponse

interface ContratoGibli {
    interface View{
        fun showdados(Ghiblilista : List<GhibliResponse>)
        fun pararLoanding()
        fun erroConex()
    }



    interface Presenter{

        fun requistadados()
    }
}