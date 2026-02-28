package com.example.minercineplex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SeatScreen(navController: NavController) {

    val rows = 6
    val columns = 8
    val seatPrice = 120

    var selectedSeats by remember { mutableStateOf(setOf<String>()) }
    var showDialog by remember { mutableStateOf(false) }

    // ตัวอย่างที่นั่งที่ถูกจองแล้ว
    val reservedSeats = setOf("A3", "B4", "C2")

    val totalPrice = selectedSeats.size * seatPrice

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        // 🎬 ชื่อหนัง
        Text(
            text = "The Irishman",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "26 ก.พ. 2569 • 19:30 • Screen 1",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🎥 จอโรงหนัง (แบบโค้ง)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color.White, Color.LightGray)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text("SCREEN", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(30.dp))

        // 🎟 Grid ที่นั่ง
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.height(320.dp)
        ) {

            items(rows * columns) { index ->

                val rowChar = ('A' + (index / columns))
                val seatNumber = (index % columns) + 1
                val seatId = "$rowChar$seatNumber"

                val isSelected = seatId in selectedSeats
                val isReserved = seatId in reservedSeats

                val seatColor = when {
                    isReserved -> Color.DarkGray
                    isSelected -> Color(0xFF4CAF50)
                    else -> Color.Red
                }

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(40.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(seatColor)
                        .clickable(enabled = !isReserved) {
                            selectedSeats =
                                if (isSelected) selectedSeats - seatId
                                else selectedSeats + seatId
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        seatId,
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🎨 Legend สี
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Legend(Color.Red, "ว่าง")
            Legend(Color(0xFF4CAF50), "เลือกแล้ว")
            Legend(Color.DarkGray, "จองแล้ว")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🎫 สรุป
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1C)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    "จำนวนที่นั่ง: ${selectedSeats.size}",
                    color = Color.White
                )

                Text(
                    "ที่นั่ง: ${selectedSeats.joinToString()}",
                    color = Color.LightGray
                )

                Text(
                    "ราคารวม: $totalPrice บาท",
                    color = Color(0xFFFFC107),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { showDialog = true },
                    enabled = selectedSeats.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFC107)
                    )
                ) {
                    Text("ยืนยันการจอง", color = Color.Black)
                }
            }
        }
    }

    // 🎟 Dialog ยืนยัน
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        selectedSeats = emptySet()
                    }
                ) {
                    Text("ยืนยัน")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("ยกเลิก")
                }
            },
            title = { Text("ยืนยันการจอง") },
            text = {
                Text(
                    "คุณเลือกที่นั่ง ${selectedSeats.joinToString()}\nรวม $totalPrice บาท\nยืนยันหรือไม่?"
                )
            }
        )
    }
}

@Composable
fun Legend(color: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .background(color, RoundedCornerShape(3.dp))
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text, color = Color.White, style = MaterialTheme.typography.labelSmall)
    }
}