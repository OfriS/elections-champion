package com.example.electionschampion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
// TODO: replace score type with Int.
fun ScoreDisplay(modifier: Modifier = Modifier, score: String) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(1000.dp))
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(score, fontSize = 32.sp, fontWeight = FontWeight.Black, color = Color.White)
    }
}

@Composable
fun ScoreRow(modifier: Modifier = Modifier, currentScore: Int, highScore: Int) {
    Row(modifier = modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        ScoreDisplay(Modifier.size(40.dp), score = currentScore.toString())
        Text(modifier = Modifier.padding(6.dp), text = "SCORE", fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.weight(1f))
        Text(modifier = Modifier.padding(6.dp), text = "HIGH SCORE", fontWeight = FontWeight.ExtraBold)
        // TODO: Implement high score.
        ScoreDisplay(Modifier.size(40.dp), score = "?")
    }
}