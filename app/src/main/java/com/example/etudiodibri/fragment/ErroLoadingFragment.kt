package com.example.etudiodibri.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.etudiodibri.R

class ErroLoadingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_erro_loading, container, false)
        val imagemView : ImageView = view.findViewById(R.id.totoro_dormindoImgview)
        imagemView.setImageResource(R.drawable.erro_conex)

        return view
    }
}