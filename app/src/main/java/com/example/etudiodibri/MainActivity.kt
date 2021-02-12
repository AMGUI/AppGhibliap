package com.example.etudiodibri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.etudiodibri.contratos.ContratoDibri
import com.example.etudiodibri.model.DibreResponse
import com.example.etudiodibri.presenter.PresenterDIbre
import com.example.etudiodibri.repositorio.ImplementRepositorio
import com.example.etudiodibri.view.adapter.DibreAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContratoDibri.View {

    private val filmes : ArrayList<DibreResponse> = arrayListOf()
    private lateinit var presenter : ContratoDibri.Presenter
    private  lateinit var adapterFilme : DibreAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterDIbre(this, ImplementRepositorio())

        adapterFilme = DibreAdapter(filmes)
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

    private fun updatafilmes(data: List<DibreResponse>){
        this.filmes.clear()
        this.filmes.addAll(data)
        this.adapterFilme.notifyDataSetChanged()
    }

    override fun showdados(Dibrelista: List<DibreResponse>) {
        updatafilmes(Dibrelista)
    }


}