package com.example.practicanavegacion1.semaforo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.practicanavegacion1.R


class btnSemaforoFragment : Fragment() {
    private lateinit var cambioListener: CambioSemaforoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is CambioSemaforoListener){
            cambioListener = context
        } else{
            throw RuntimeException("Must implement StarSignListener")
        }
        //Valdría también lo siguiente
//        if(activity is StarSignListener){
//            starSignListener = activity as StarSignListener
//        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_btn_semaforo, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botonCambia = view.findViewById<Button>(R.id.btnSemaforo)//binding???
        botonCambia.setOnClickListener {
            cambioListener.onClick()
        }
    }
}