package com.example.minercineplex.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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

// 🔥 Model จริง
data class Movie(
    val title: String,
    val imageUrl: String,
    val overview: String,
    val genre: String,
    val duration: String,
    val rating: String,
    val director: String,
    val cast: List<String>
)

// 🔥 ข้อมูลจริง
val movies = listOf(

    Movie(
        "The Irishman",
        "https://image.tmdb.org/t/p/w500/mbm8k3GFhXS0ROd9AD1gqYbIFbM.jpg",
        "A mob hitman recalls his possible involvement with the slaying of Jimmy Hoffa.",
        "Crime • Drama",
        "209 นาที",
        "8.2",
        "Martin Scorsese",
        listOf("Robert De Niro", "Al Pacino", "Joe Pesci")
    ),

    Movie(
        "Glass Onion",
        "https://image.tmdb.org/t/p/w500/5Tz1QpxzTn8pZ5OeYFQqYh6gXKq.jpg",
        "Detective Benoit Blanc investigates a new mystery in Greece.",
        "Mystery • Comedy",
        "139 นาที",
        "7.2",
        "Rian Johnson",
        listOf("Daniel Craig", "Edward Norton", "Janelle Monáe")
    ),

    Movie(
        "The Gray Man",
        "https://image.tmdb.org/t/p/w500/8cXbitsS6dWQ5gfMTZdorpAAzEH.jpg",
        "When the CIA's top operative uncovers secrets, he becomes hunted.",
        "Action • Thriller",
        "122 นาที",
        "6.5",
        "Anthony Russo",
        listOf("Ryan Gosling", "Chris Evans", "Ana de Armas")
    )
)

@Composable
fun HomeScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        item {
            Text(
                "Miner Cineplex",
                color = Color(0xFFFFC107),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        itemsIndexed(movies) { index, movie ->
            MovieCard(movie, index, navController)
        }

        item { Spacer(modifier = Modifier.height(80.dp)) }
    }
}

@Composable
fun MovieCard(movie: Movie, index: Int, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate("detail/$index")
            }
    ) {

        AsyncImage(
            model = movie.imageUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(220.dp)
                .clip(RoundedCornerShape(20.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(movie.title, color = Color.White, fontWeight = FontWeight.Bold)
        Text(movie.genre, color = Color.Gray)
    }
}