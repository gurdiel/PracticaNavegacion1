package com.example.practicanavegacion1.semaforo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.FragmentSemaforoColorBinding
import java.util.zip.Inflater

private const val COLOR_SEMAFORO = "param1"
class SemaforoColorFragment : Fragment() {

    private var _binding: FragmentSemaforoColorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSemaforoColorBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorSemaforo = arguments?.getInt(COLOR_SEMAFORO, Color.RED) ?: Color.RED
        actualizarSemaforo(colorSemaforo)

    }

    private fun actualizarSemaforo(colorSemaforo: Int) {

        binding.semaforo.setBackgroundColor(colorSemaforo)

    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            SemaforoColorFragment().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_SEMAFORO, color)
                }
            }
    }
}