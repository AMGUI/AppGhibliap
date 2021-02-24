package com.example.etudiodibri.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.etudiodibri.R
import com.example.etudiodibri.model.GhibliResponse


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ErroLoadingFragment : Fragment() {

    private var filme: GhibliResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            filme = it.getParcelable("FILME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_erro_loading, container, false)
        val imagemView : ImageView = view.findViewById(R.id.totoro_dormindoImgview)
        imagemView.setImageResource(R.drawable.erro_conex)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(filme: GhibliResponse) = ErroLoadingFragment().apply {
            arguments = Bundle().apply {
                putParcelable("FILME", filme)
            }
        }
    }

}