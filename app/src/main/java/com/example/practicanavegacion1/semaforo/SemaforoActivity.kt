package com.example.practicanavegacion1.semaforo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.ActivitySemaforoBinding
import com.example.practicanavegacion1.semaforo.model.Semaforo

class SemaforoActivity : AppCompatActivity(),CambioSemaforoListener {
    lateinit var binding: ActivitySemaforoBinding
    private val semaforo = Semaforo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySemaforoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            val fragmentSemaforoContainer = binding.fragmentColorSemaforo //referenciado el fragmento que queremos actualizar
            val semaforoColorFragment = SemaforoColorFragment()//instanciamos el fragmento que queremos cargar
            supportFragmentManager
                .beginTransaction()
                .add(fragmentSemaforoContainer.id, semaforoColorFragment)
                .commit()
            val fragmentBotonContainer = binding.fragmentBotonSemaforo //referenciado el fragmento que queremos actualizar
            val semaforoBtnFragment = btnSemaforoFragment()//instanciamos el fragmento que queremos cargar
            supportFragmentManager
                .beginTransaction()
                .add(fragmentBotonContainer.id, semaforoBtnFragment)
                .commit()
        }
    }

    override fun onClick() {
        semaforo.avanzar()
        val semaforoColorFragment = SemaforoColorFragment.newInstance(semaforo.color)
        val fragmentSemaforoContainer = binding.fragmentColorSemaforo
        supportFragmentManager
            .beginTransaction()
            .replace(fragmentSemaforoContainer.id, semaforoColorFragment)
            .commit()

    }
}