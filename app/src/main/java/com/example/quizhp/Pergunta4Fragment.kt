package com.example.quizhp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_pergunta1.*
import kotlinx.android.synthetic.main.fragment_pergunta3.*
import kotlinx.android.synthetic.main.fragment_pergunta4.*

class Pergunta4Fragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_pergunta4, container, false)
        mainViewModel = ViewModelProvider(requireActivity(), ViewModelFactory()).get(MainViewModel::class.java)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonPergunta4.setOnClickListener {
            if (radioGroupPergunta4.checkedRadioButtonId == -1) {
                Snackbar.make(it, "Selecione uma opção!", Snackbar.LENGTH_SHORT).setTextColor(Color.WHITE)
                        .setBackgroundTint(Color.RED)
                        .show()
            }else {
                if (radioButtonPergunta4A.isChecked) {
                    mainViewModel.respostaErrada()
                    Snackbar.make(it, "Errou!!", Snackbar.LENGTH_SHORT).setTextColor(Color.WHITE)
                            .setBackgroundTint(Color.RED)
                            .show()
                }
                else if(radioButtonPergunta4B.isChecked) {
                    mainViewModel.respostaCerta()
                    Snackbar.make(it, "Acertou!!", Snackbar.LENGTH_SHORT).setTextColor(Color.WHITE)
                            .setBackgroundTint(Color.GREEN)
                            .show()
                }
                else if (radioButtonPergunta4C.isChecked){
                    mainViewModel.respostaErrada()
                    Snackbar.make(it, "Errou!!", Snackbar.LENGTH_SHORT).setTextColor(Color.WHITE)
                            .setBackgroundTint(Color.RED)
                            .show()
                }
                else if(radioButtonPergunta4D.isChecked) {
                    mainViewModel.respostaErrada()
                    Snackbar.make(it, "Errou!!", Snackbar.LENGTH_SHORT).setTextColor(Color.WHITE)
                            .setBackgroundTint(Color.RED)
                            .show()
                }
                findNavController().navigate(R.id.pergunta5Fragment)
            }
        }
    }
}