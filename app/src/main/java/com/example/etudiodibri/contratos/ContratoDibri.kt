package com.example.etudiodibri.contratos

import com.example.etudiodibri.model.DibreResponse

interface ContratoDibri {
    interface View{
        fun showdados(Dibrelista : List<DibreResponse>)
    }

    interface Presenter{

        fun requistadados()
    }
}