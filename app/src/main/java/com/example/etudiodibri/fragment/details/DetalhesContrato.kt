package com.example.etudiodibri.fragment.details

import com.example.etudiodibri.model.GhibliResponse

interface DetalhesContrato {
    interface View {
        fun exibeDadosDetalhes(filme: GhibliResponse?)
        fun voltarTeta()
    }

    interface Presenter {
        fun montaTelaDetalhes(filme: GhibliResponse?)
        fun quandoClicarNoVoltar()
    }
}