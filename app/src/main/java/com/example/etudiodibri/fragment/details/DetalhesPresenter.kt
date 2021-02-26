package com.example.etudiodibri.fragment.details

import com.example.etudiodibri.model.GhibliResponse

class DetalhesPresenter(private val view: DetalhesContrato.View): DetalhesContrato.Presenter {
    override fun montaTelaDetalhes(filme: GhibliResponse?) {
        view.exibeDadosDetalhes(filme)
    }

    override fun quandoClicarNoVoltar() {
        view.voltarTeta()
    }
}