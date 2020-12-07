package com.example.quizhp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        mainViewModel = ViewModelProvider(requireActivity(), ViewModelFactory()).get(MainViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonIniciar.setOnClickListener{
            if(editTextNome.text.isNullOrEmpty()){
                Toast.makeText(requireActivity(),"Digite seu nome!", Toast.LENGTH_LONG).show()
            }else {
                var nomeNovo = editTextNome.text.toString()
                mainViewModel.alterarNome(nomeNovo)
                findNavController().navigate(R.id.pergunta1Fragment)
            }
        }
    }
}