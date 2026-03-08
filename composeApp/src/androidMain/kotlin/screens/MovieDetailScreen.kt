package com.example.minercineplex.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.minercineplex.model.Movie

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
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(16.dp)) {

            Text(movie.title, color = Color.White)

            Text(
                "⭐ ${movie.rating} • ${movie.genre} • ${movie.duration}",
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { navController.navigate("seat") }
            ) {
                Text("🎟 Book Ticket")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(movie.trailerUrl)
                    )
                    navController.context.startActivity(intent)
                }
            ) {
                Text("▶ Watch Trailer")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Overview", color = Color.White)

            Text(movie.overview, color = Color.Gray)

            Spacer(modifier = Modifier.height(20.dp))

            Text("Director", color = Color.White)

            Text(movie.director, color = Color.Gray)

            Spacer(modifier = Modifier.height(20.dp))

            Text("Cast", color = Color.White)

            movie.cast.forEach {

                Text("• $it", color = Color.Gray)
            }
        }
    }
}