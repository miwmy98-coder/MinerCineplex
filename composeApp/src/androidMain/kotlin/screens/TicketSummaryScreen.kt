package com.example.minercineplex.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TicketSummaryScreen(navController: NavController, seats: String) {
    val seatList = seats.split(",")
    val total = seatList.size * 180
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {
        Text(
            text = "Booking Summary",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Movie: John Wick Chapter 4", color = Color.White)
        Text("Theater: Science Building", color = Color.White)
        Text("Showtime: 7:30 PM", color = Color.White)
        Text(
            text = "Seats: $seats",
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Total: ฿$total",
            color = Color(0xFFFFC107)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navController.navigate("payment/$seats")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFC107)
            )
        ) {
            Text(
                text = "Proceed to Payment",
                color = Color.Black
            )
        }
    }
}