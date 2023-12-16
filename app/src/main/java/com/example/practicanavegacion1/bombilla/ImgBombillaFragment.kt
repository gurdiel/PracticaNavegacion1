package com.example.practicanavegacion1.bombilla

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.bombilla.model.Bombilla
import com.example.practicanavegacion1.databinding.FragmentImgBombillaBinding


class ImgBombillaFragment : Fragment() {

    private var _binding: FragmentImgBombillaBinding? = null
    private val binding get() = _binding!!
    //variable para el modelo
    private lateinit var bombilla:Bombilla

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bombilla = Bombilla()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentImgBombillaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        actualizarBombilla()
    }

    fun cambiarImg(btn: Int){

        if(btn == R.id.btnEncendido){
            bombilla.encender()
        }else{
            bombilla.apagar()
        }
        actualizarBombilla()

    }

    private fun actualizarBombilla() {
        if(bombilla.estaEncendida()){
            binding.imgBombilla.setImageResource(R.drawable.encendida)
        }else{
            binding.imgBombilla.setImageResource(R.drawable.apagada)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}