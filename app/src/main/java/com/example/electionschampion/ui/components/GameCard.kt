package com.example.electionschampion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electionschampion.common.LIKUD_PARTY_SYMBOL

@Composable
fun GameCard(modifier: Modifier = Modifier, votingPercentage: Double) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0xff2e70b4))
            .padding(10.dp)
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color = Color(0xffa2caf2))
        ) {
            Column(
                modifier = modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        LIKUD_PARTY_SYMBOL,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    "%.2f%% votes".format(votingPercentage),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview
@Composable
private fun GameCardPreview() {
    GameCard(modifier = Modifier, 35.7982)
}