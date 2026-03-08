package com.example.minercineplex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun TicketScreen(seats: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Movie Ticket",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
            shape = RoundedCornerShape(16.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("John Wick Chapter 4", color = Color.White)
                Text("Science Theater", color = Color.White)
                Text("7:30 PM", color = Color.White)
                Text("Seats: $seats", color = Color.White)

                Spacer(modifier = Modifier.height(20.dp))

                AsyncImage(
                    model = "https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=MinerCineplexTicket",
                    contentDescription = "QR Ticket",
                    modifier = Modifier.size(180.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text("QR Movie Ticket", color = Color.Gray)
            }
        }
    }
}