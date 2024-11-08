package com.example.electionschampion.model

data class PlaceResult(
    val placeName: String,
    val population: Int,
    val totalVotes: Int,
    val results: Map<Party, Int>
)