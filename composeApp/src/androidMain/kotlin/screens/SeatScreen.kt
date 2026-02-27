package com.example.minercineplex.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SeatScreen(navController: NavController) {

    val seatPrice = 160
    val rows = 6
    val columns = 8

    val selectedSeats = remember { mutableStateListOf<Pair<Int, Int>>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Text("เลือกที่นั่ง", color = Color.White, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        for (i in 0 until rows) {
            Row {
                for (j in 0 until columns) {

                    val selected = selectedSeats.contains(i to j)

                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(4.dp)
                            .background(if (selected) Color.Green else Color.Red)
                            .clickable {
                                if (selected)
                                    selectedSeats.remove(i to j)
                                else
                                    selectedSeats.add(i to j)
                            }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        val total = selectedSeats.size * seatPrice

        Card {
            Column(Modifier.padding(16.dp)) {
                Text("จำนวน: ${selectedSeats.size}")
                Text("รวม: ฿$total")
            }
        }
    }
}