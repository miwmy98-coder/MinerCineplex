package com.example.minercineplex.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@Composable
fun SeatScreen(navController: NavController) {
    val rows = listOf("A","B","C","D","E","F")
    val cols = 8
    val seatPrice = 180
    val selectedSeats = remember { mutableStateListOf<String>() }
    val total = selectedSeats.size * seatPrice
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "Select Seat",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.DarkGray, RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ) {
            Text("SCREEN", color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        rows.forEach { row ->

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (col in 1..cols) {
                    val seat = "$row$col"
                    val selected = selectedSeats.contains(seat)
                    val color =
                        if (selected) Color(0xFFFFC107)
                        else Color.Gray
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(4.dp)
                            .background(color, RoundedCornerShape(6.dp))
                            .clickable {
                                if (selected)
                                    selectedSeats.remove(seat)
                                else
                                    selectedSeats.add(seat)
                            }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Selected Seats: ${selectedSeats.joinToString(",")}",
                    color = Color.White
                )
                Text(
                    text = "Price per seat: ฿$seatPrice",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Total: ฿$total",
                    color = Color(0xFFFFC107)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val seats = selectedSeats.joinToString(",")
                navController.navigate("summary/$seats")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFC107)
            )
        ) {
            Text(
                text = "Proceed to Booking",
                color = Color.Black
            )
        }
    }
}