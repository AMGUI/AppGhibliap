package com.example.etudiodibri.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.etudiodibri.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ErroLoadingFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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


}