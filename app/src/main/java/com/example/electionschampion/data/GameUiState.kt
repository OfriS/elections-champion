package com.example.electionschampion.data

import com.example.electionschampion.model.Party
import com.example.electionschampion.model.PlaceResult

enum class Difficulty(val displayName: String, val minimumPopulation: Int) {
    Easy("קל", 10000),
    Medium("בינוני", 5000),
    Hard("קשה", 0),
}

data class GameUiState(
    val difficulty: Difficulty = Difficulty.entries.first(),
    val playingAsParty: Party = Party.entries.first(),

    val dataset: List<PlaceResult> = listOf<PlaceResult>(),
    val displayedPlace: PlaceResult = PlaceResult("", 0, 0, mapOf()),
    val hiddenPlace: PlaceResult = PlaceResult("", 0, 0, mapOf()),
    val score: Int = 0,
)