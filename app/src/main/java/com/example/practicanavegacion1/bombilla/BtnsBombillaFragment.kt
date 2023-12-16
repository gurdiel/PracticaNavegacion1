package com.example.practicanavegacion1.bombilla

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.FragmentBtnsBombillaBinding
import com.example.practicanavegacion1.databinding.FragmentImgBombillaBinding
import java.lang.RuntimeException

class BtnsBombillaFragment : Fragment() {
    private lateinit var observadorInterruptor: InterruptorBombillaListener //es de tipo de la interface
    private var _binding: FragmentBtnsBombillaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBtnsBombillaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is InterruptorBombillaListener){
            observadorInterruptor = context
        }else{
            throw RuntimeException("$context must implement InterruptorBombillaListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //al boton apagar asociale un listener
        binding.btnApagado.setOnClickListener {
            observadorInterruptor.onClickButton(it.id)
            interruptor()
        }
        binding.btnEncendido.setOnClickListener {
            boton -> observadorInterruptor.onClickButton(boton.id)
            interruptor()
        }
    }

    private fun interruptor() {
        val listaBotones = listOf<Button>(
            binding.btnApagado,
            binding.btnEncendido,
            )
        listaBotones.forEach{
            it.isEnabled = !it.isEnabled
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}