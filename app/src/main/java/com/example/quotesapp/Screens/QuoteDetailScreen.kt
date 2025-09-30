package com.example.quotesapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.DataManager
import com.example.models.Quote
import com.google.firebase.annotations.concurrent.Background

@Composable
fun QuoteDetail(quote: Quote) {

    BackHandler(){
        DataManager.switchPages(null)
    }
    // Full gradient background
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFE3E3E3), // Outer
                        Color(0xFFA42020)  // Center
                    ),
                    center = Offset(600f, 600f),
                    radius = 1000f
                )
            )
    ) {
        // Card with shadow, rounded corners, and border
        Card(
            elevation = cardElevation(defaultElevation = 8.dp, pressedElevation = 12.dp),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.08f)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.padding(24.dp).fillMaxWidth(0.88f)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 32.dp, horizontal = 20.dp)
            ) {
                // Quote Icon in a colored circle
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(72.dp)
                        .background(Color(0xFFF7B801), CircleShape)
                        .shadow(elevation = 4.dp, CircleShape)
                ) {
                    Image(
                        imageVector = Icons.Filled.FormatQuote,
                        contentDescription = "Quote Icon",
                        modifier = Modifier.size(36.dp).rotate(180f),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                }
                Spacer(Modifier.height(16.dp))
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(18.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}