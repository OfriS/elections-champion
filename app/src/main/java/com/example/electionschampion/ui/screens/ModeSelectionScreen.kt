package com.example.electionschampion.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.electionschampion.data.Difficulty
import com.example.electionschampion.model.Party

@Composable
fun ModeSelectionScreen(
    modifier: Modifier = Modifier,
    onStartButtonClicked: () -> Unit,
    currentDifficulty: Difficulty,
    onDifficultyButtonClicked: (Difficulty) -> Unit,
    currentPlayingAsParty: Party,
    onPartyButtonClicked: (Party) -> Unit,
) {
    Column(modifier = modifier) {
        Button(
            onClick = onStartButtonClicked
        ) {
            Text("Start")
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { onDifficultyButtonClicked(Difficulty.Easy) },
                colors = ButtonDefaults.buttonColors(contentColor = if (currentDifficulty == Difficulty.Easy) Color.Cyan else Color.Blue)
            ) {
                Text(Difficulty.Easy.displayName)
            }
            Button(
                onClick = { onDifficultyButtonClicked(Difficulty.Medium) },
                colors = ButtonDefaults.buttonColors(contentColor = if (currentDifficulty == Difficulty.Medium) Color.Cyan else Color.Blue)
            ) {
                Text(Difficulty.Medium.displayName)
            }
            Button(
                onClick = { onDifficultyButtonClicked(Difficulty.Hard) },
                colors = ButtonDefaults.buttonColors(contentColor = if (currentDifficulty == Difficulty.Hard) Color.Cyan else Color.Blue)
            ) {
                Text(Difficulty.Hard.displayName)
            }
        }
        PartySelectionGrid(
            currentPlayingAsParty = currentPlayingAsParty,
            onPartyButtonClicked = onPartyButtonClicked,
        )
    }
}

@Composable
fun PartySelectionGrid(
    modifier: Modifier = Modifier,
    currentPlayingAsParty: Party,
    onPartyButtonClicked: (Party) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 8.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(Party.entries) { party ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(
                            color = if (party == currentPlayingAsParty) Color.Black else Color.White
                        )
                        .clickable {
                            // Update selectedBoxIndex to the clicked box index
                            onPartyButtonClicked(party)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(party.partySymbol)
                }
            }
        }
    }
}