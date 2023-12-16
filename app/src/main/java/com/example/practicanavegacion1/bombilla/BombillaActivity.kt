package com.example.practicanavegacion1.bombilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.ActivityBombillaBinding
import com.example.practicanavegacion1.databinding.ActivityMainBinding

class BombillaActivity : AppCompatActivity(), InterruptorBombillaListener{

    lateinit var binding: ActivityBombillaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBombillaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onClickButton(@IdRes btnId:Int) {
        Log.d("BombillaActivty","Botón interriptor puslado")
        val imgBombillaFragment = supportFragmentManager
            .findFragmentById(R.id.fragBombilla) as ImgBombillaFragment
        imgBombillaFragment.cambiarImg(btnId)
    }

}