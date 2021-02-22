package com.example.etudiodibri.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.etudiodibri.R
import com.example.etudiodibri.contratos.ContratoGibli
import com.example.etudiodibri.fragment.LoandingFragment
import com.example.etudiodibri.model.GhibliResponse
import com.example.etudiodibri.presenter.PresenterGhibli
import com.example.etudiodibri.repositorio.ImplementRepositorio
import com.example.etudiodibri.view.adapter.GhibliAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContratoGibli.View {

    private val filmes : ArrayList<GhibliResponse> = arrayListOf()
    private lateinit var presenter : ContratoGibli.Presenter
    private  lateinit var adapterFilme : GhibliAdapter
    lateinit var loandingFragento: LoandingFragment
   lateinit var frame_loading : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fraguimento do Totoro andando (Loand)

        val trasacao = supportFragmentManager.beginTransaction()
        loandingFragento = LoandingFragment()
        trasacao.add(R.id.frame_loading,loandingFragento)
        trasacao.commit()

        //=====================================

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

    fun pararLoanding(){
        this.frame_loading = findViewById(R.id.frame_loading)
        this.loandingFragento.onStop()
        this.frame_loading.setVisibility(View.GONE)


    }


}