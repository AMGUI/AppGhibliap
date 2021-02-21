package com.example.etudiodibri.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.etudiodibri.R
import com.example.etudiodibri.contratos.ContratoGibli
import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.presenter.PresenterGhibli
import com.example.etudiodibri.repositorio.ImplementRepositorio
import com.example.etudiodibri.view.adapter.GhibliAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContratoGibli.View {

    private val filmes : ArrayList<GhibliResponse> = arrayListOf()
    private lateinit var presenter : ContratoGibli.Presenter
    private  lateinit var adapterFilme : GhibliAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterGhibli(this, ImplementRepositorio())

        adapterFilme = GhibliAdapter(filmes)
        setAdapter()
        presenter.requistadados()
    }

    fun setAdapter(){

      val filme: RecyclerView = listaFilmes

        filme.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = adapterFilme
        }

    }

    private fun updatafilmes(data: List<GhibliResponse>){
        this.filmes.clear()
        this.filmes.addAll(data)
        this.adapterFilme.notifyDataSetChanged()
    }

    override fun showdados(Dibrelista: List<GhibliResponse>) {
        updatafilmes(Dibrelista)
    }


}