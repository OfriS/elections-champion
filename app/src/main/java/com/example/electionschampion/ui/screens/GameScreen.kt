package com.example.electionschampion.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.electionschampion.data.GameUiState
import com.example.electionschampion.ui.calculateVoterPercentage
import com.example.electionschampion.ui.components.DisplayCard
import com.example.electionschampion.ui.components.GuessCard
import com.example.electionschampion.ui.components.ScoreRow

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onClickMore: () -> Unit,
    onClickLess: () -> Unit,
    state: GameUiState,
) {
    Column(
        modifier = modifier
            .background(Color(0xff2e70b4))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: implement party selection mode.
        DisplayCard(
            Modifier.weight(2f),
            placeName = state.displayedPlace.placeName,
            votingPercentage = calculateVoterPercentage(state.displayedPlace, state.playingAsParty),
            partyBallotLetters = state.playingAsParty.partySymbol,
        )

        Spacer(Modifier.height(32.dp))

        GuessCard(
            Modifier.weight(.8f),
            placeName = state.hiddenPlace.placeName,
            onClickMore = onClickMore,
            onClickLess = onClickLess
        )

        // TODO: Add highscore
        ScoreRow(
            Modifier.weight(.5f),
            currentScore = state.score, highScore = 0
        )
    }
}
