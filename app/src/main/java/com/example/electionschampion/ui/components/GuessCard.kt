package com.example.electionschampion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun GuessCard(
    modifier: Modifier = Modifier,
    placeName: String,
    onClickMore: () -> Unit,
    onClickLess: () -> Unit
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Box(
            Modifier.background(Color(0xFFDEDEDE))
        ) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Display the current place's name.
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = placeName,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(16.dp))

                // Two buttons for guessing higher or lower.
                Row {
                    Spacer(Modifier.weight(.5f))

                    Button(onClick = onClickMore) {
                        Text(text = "MORE", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                    }

                    Spacer(Modifier.weight(1f))

                    Button(onClick = onClickLess) {
                        Text(text = "LESS", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                    }

                    Spacer(Modifier.weight(.5f))
                }
            }
        }
    }
}