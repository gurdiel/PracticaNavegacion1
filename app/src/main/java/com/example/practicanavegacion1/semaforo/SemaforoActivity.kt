package com.example.practicanavegacion1.semaforo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.ActivitySemaforoBinding

class SemaforoActivity : AppCompatActivity() {
    lateinit var binding: ActivitySemaforoBinding
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
}