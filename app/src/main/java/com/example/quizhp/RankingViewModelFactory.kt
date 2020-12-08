package com.example.quizhp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RankingViewModelFactory(var appDatabase: AppDatabase)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(RankingViewModel::class.java))
            return RankingViewModel(appDatabase) as T
        throw IllegalArgumentException("Argumento ilegal.")
    }

}