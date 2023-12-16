package com.example.practicanavegacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavegacion1.bombilla.BombillaActivity
import com.example.practicanavegacion1.bombilla.InterruptorBombillaListener
import com.example.practicanavegacion1.databinding.ActivityMainBinding
import com.example.practicanavegacion1.semaforo.SemaforoActivity

class MainActivity : AppCompatActivity(){

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSemaforo.setOnClickListener {
            val intentSemaforo = Intent(this,SemaforoActivity::class.java)
            startActivity(intentSemaforo)
        }

        binding.btnBombilla.setOnClickListener {
            val intentBombilla = Intent(this, BombillaActivity::class.java)
            startActivity(intentBombilla)
        }
    }
}