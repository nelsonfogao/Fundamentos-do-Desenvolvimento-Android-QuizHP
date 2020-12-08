package com.example.quizhp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var nome = "nome"
    var pontos = MutableLiveData<Int>()
    init {
        pontos.value = 0
    }
    fun alteraNome(novoNome:String){
        nome = novoNome
    }
    fun mostrarNome():String{
        return nome
    }
    fun respostaCerta():Int{
        pontos.value = pontos.value?.plus(1)
        return pontos.value!!
    }
    fun respostaErrada():Int{
        pontos.value = pontos.value
        return pontos.value!!
    }
    fun mostrarPontos():Int{
        return pontos.value!!
    }

}