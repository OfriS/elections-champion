package com.example.electionschampion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BallotImage(modifier: Modifier = Modifier, partyBallotLetters: String) {
    // TODO: Implement a nice image of a voting ballot.
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        // TODO: Maybe add the each party's logo instead of just text? IDK.
        Text(text = partyBallotLetters, fontSize = 64.sp, fontWeight = FontWeight.Black)
    }
}


@Composable
fun DisplayCard(
    modifier: Modifier = Modifier,
    placeName: String,
    votingPercentage: Double,
    partyBallotLetters: String
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Box(Modifier.background(Color(0xFFDEDEDE))) {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display the current place's name.
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = placeName,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(16.dp))

                // Display the current party.
                BallotImage(
                    modifier = Modifier.size(250.dp),
                    partyBallotLetters = partyBallotLetters
                )

                Spacer(Modifier.weight(1f))

                // Display the party's vote percentage.
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "%.2f%% of the votes".format(votingPercentage),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))
            }
        }
    }
}
