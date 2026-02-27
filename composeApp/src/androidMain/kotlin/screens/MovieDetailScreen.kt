package com.example.minercineplex.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun MovieDetailScreen(navController: NavController, movie: Movie) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {

        AsyncImage(
            model = movie.imageUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(16.dp)) {

            Text(movie.title, color = Color.White, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "⭐ ${movie.rating} • ${movie.genre} • ${movie.duration}",
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                onClick = { navController.navigate("seat") }
            ) {
                Text("🎟 จองตั๋ว", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("เรื่องย่อ", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(movie.overview, color = Color.LightGray)

            Spacer(modifier = Modifier.height(24.dp))

            Text("ผู้กำกับ", color = Color.White, fontWeight = FontWeight.Bold)
            Text(movie.director, color = Color.LightGray)

            Spacer(modifier = Modifier.height(24.dp))

            Text("นักแสดงนำ", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            movie.cast.forEach {
                Text("• $it", color = Color.LightGray)
            }
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}