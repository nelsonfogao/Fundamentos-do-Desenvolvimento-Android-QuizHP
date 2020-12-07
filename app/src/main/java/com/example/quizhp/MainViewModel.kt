package com.example.quizhp

import android.content.Intent
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var nome:String = "nome"
    fun alterarNome(nomeNovo:String):String{
        nome = nomeNovo
        return nome
    }

}