package com.example.quizhp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_resultado.*

class ResultadoFragment : Fragment() {
    private lateinit var rankingViewModel: RankingViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_resultado, container, false)
        mainViewModel = ViewModelProvider(requireActivity(), ViewModelFactory()).get(MainViewModel::class.java)
        rankingViewModel =
                ViewModelProvider(
                        this,
                        RankingViewModelFactory(AppDatabase.getInstance())
                )
                        .get(RankingViewModel::class.java)

        rankingViewModel.rankings
                .observe(viewLifecycleOwner) {
                    if (!it.isNullOrEmpty())
                        adaptarListView(it)
                }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var nome = mainViewModel.mostrarNome()
        textViewNome.text = nome
        buttonWikia.setOnClickListener{
            val webIntent: Intent = Uri.parse("https://harrypotter.fandom.com/pt-br/wiki/P%C3%A1gina_Principal").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)

            }
            startActivity(webIntent)
        }
        mainViewModel.pontos.observe(viewLifecycleOwner){
            textViewPontos.text = it?.toString()
            if(it <= 3){
                textViewResultado.text = "Parece que Você ainda é trouxa, pegue o vira-tempo e veja mais coisas de Harry Potter"
            }else if(it in 4..6){
                textViewResultado.text = "Você sabe mais que a maioria, mas para ser um grande bruxo, ainda falta"
            }else if(it in 7..9){
                textViewResultado.text = "Parabéns, você sabe bastante de Harry Potter, está no caminho certo para virar um auror"
            }else{
                textViewResultado.text = "Parabéns, você sabe tudo de HP, você é um bruxo de primeira!!"
            }
        }
    }

    private fun adaptarListView(listaDeRanking: List<Ranking>) {
        listViewRanking.adapter =
                RankingRecyclerAdapter(listaDeRanking)
        listViewRanking.layoutManager = LinearLayoutManager(requireContext())
    }
}