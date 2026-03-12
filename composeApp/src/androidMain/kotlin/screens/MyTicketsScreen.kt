package com.example.minercineplex.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
@Composable
fun MyTicketsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Tickets",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1E1E1E)
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("John Wick Chapter 4", color = Color.White)
                Text("Science Theater", color = Color.White)
                Text("Seat A3 A4", color = Color.White)
                Text("7:30 PM", color = Color.White)
                Spacer(modifier = Modifier.height(20.dp))
                AsyncImage(
                    model = "https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=RMUTT-CINEMA-TICKET-12345",
                    contentDescription = "QR Ticket",
                    modifier = Modifier.size(180.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "QR Movie Ticket",
                    color = Color.Gray
                )
            }
        }
    }
}