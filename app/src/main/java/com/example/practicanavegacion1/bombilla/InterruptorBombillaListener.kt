package com.example.practicanavegacion1.bombilla

import androidx.annotation.IdRes


interface InterruptorBombillaListener {

    fun onClickButton(@IdRes btnId:Int)//Le pasamos algo? imagen o algo?
}