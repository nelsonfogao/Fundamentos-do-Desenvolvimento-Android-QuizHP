package com.example.quizhp

class AppDatabase {

    private var rankings: MutableList<Ranking> = mutableListOf(
            Ranking("Pedro", 10),
            Ranking("João", 7),
            Ranking("Marcos", 3)

    )

    fun all(): List<Ranking> {
        return rankings
    }

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(): AppDatabase {
            if (instance == null)
                instance = AppDatabase()
            return instance as AppDatabase
        }
    }

}