package com.example.quizhp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RankingViewModel(appDatabase: AppDatabase) : ViewModel() {
    private val _rankings = MutableLiveData<List<Ranking>>()
    val rankings: LiveData<List<Ranking>>
        get() = _rankings

    init {
        _rankings.value = appDatabase.all()
    }
}