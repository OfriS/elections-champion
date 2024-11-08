package com.example.electionschampion.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameOverScreen(score: Int, onRestartButtonClicked: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(Modifier.clip(RoundedCornerShape(1000.dp)), contentAlignment = Alignment.Center) {
            Column {
                Text(text = "Score", fontSize = 48.sp)
                Text(text = score.toString(), fontSize = 64.sp)
            }
        }
        Spacer(Modifier.height(100.dp))
        Button(
            onClick = onRestartButtonClicked
        ) {
            Text("Restart")
        }
    }
}