package com.example.electionschampion.ui

import androidx.lifecycle.ViewModel
import com.example.electionschampion.data.DataSource
import com.example.electionschampion.data.Difficulty
import com.example.electionschampion.data.GameUiState
import com.example.electionschampion.model.Party
import com.example.electionschampion.model.PlaceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.InputStream

fun calculateVoterPercentage(placeResult: PlaceResult, party: Party): Double {
    return placeResult.results[party]!!.toDouble() / placeResult.totalVotes * 100
}

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private fun getRandomPlace(toExclude: PlaceResult? = null): PlaceResult {
        return toExclude?.let { toExclude ->
            _uiState.value.dataset.filter { it.placeName != toExclude.placeName }.random()
        } ?: _uiState.value.dataset.random()
    }

    fun initializeApp(dataStream: InputStream) {
        // Load the data source.
        DataSource.load(dataStream)
    }

    fun initializeGame() {
        // Update the game's dataset.
        _uiState.update { currentState ->
            currentState.copy(
                dataset = DataSource.getResults()
                    .filter { it -> it.population > _uiState.value.difficulty.minimumPopulation },
            )
        }

        // Choose random places for the game's initial state.
        val displayedPlace = getRandomPlace()
        val hiddenPlace = getRandomPlace(displayedPlace)
        _uiState.update { currentState ->
            currentState.copy(
                displayedPlace = displayedPlace,
                hiddenPlace = hiddenPlace,
                score = 0
            )
        }
    }

    fun getDisplayedPercentage(): Double {
        return calculateVoterPercentage(
            _uiState.value.displayedPlace,
            _uiState.value.playingAsParty
        )
    }

    fun getHiddenPercentage(): Double {
        return calculateVoterPercentage(_uiState.value.hiddenPlace, _uiState.value.playingAsParty)
    }

    fun displayedIsMore(): Boolean {
        return this.getDisplayedPercentage() > this.getHiddenPercentage()
    }

    fun onCorrectGuess() {
        _uiState.update { currentState ->
            currentState.copy(
                displayedPlace = currentState.hiddenPlace,
                hiddenPlace = getRandomPlace(currentState.hiddenPlace),
                score = currentState.score + 1,
            )
        }
    }

    fun resetGame() {
        val displayedPlace = getRandomPlace()
        val hiddenPlace = getRandomPlace(displayedPlace)

        _uiState.update { currentState ->
            currentState.copy(
                displayedPlace = displayedPlace,
                hiddenPlace = hiddenPlace,
                score = 0,
            )
        }
    }

    fun changeDifficulty(newDifficulty: Difficulty) {
        _uiState.update { currentState ->
            currentState.copy(
                difficulty = newDifficulty
            )
        }
    }

    fun changePlayingAsParty(newParty: Party) {
        _uiState.update { currentState ->
            currentState.copy(
                playingAsParty = newParty
            )
        }
    }
}