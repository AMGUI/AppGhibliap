package com.example.etudiodibri.fragment.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etudiodibri.R
import com.example.etudiodibri.model.GhibliResponse
import kotlinx.android.synthetic.main.fragment_detalhes.*
import com.bumptech.glide.Glide

class DetalhesFragment : Fragment(), DetalhesContrato.View {

    private lateinit var presenter: DetalhesContrato.Presenter

    private var filme: GhibliResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = DetalhesPresenter(this)
        arguments?.let { filme = it.getParcelable(ARG_FILME) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detalhes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.montaTelaDetalhes(filme)
        animeDetailsBackButton.setOnClickListener { presenter.quandoClicarNoVoltar() }
    }

    override fun exibeDadosDetalhes(filme: GhibliResponse?) {
        filme?.let {
            animeDetailsTitle.text = it.title
            animeDetailsDescription.text = it.description
            Glide.with(this).load(it.getThumbnail(requireContext())).into(animeDetailsTrailer)
        }
    }

    override fun voltarTeta() {
        fragmentManager?.popBackStack()
    }

    companion object {
        private const val ARG_FILME = "FILME";
        fun newInstance(filme: GhibliResponse) =
        DetalhesFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_FILME, filme)
            }
        }
    }
}