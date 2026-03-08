package com.example.minercineplex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.minercineplex.model.MovieData

@Composable
fun TheaterScreen(navController: NavController) {

    val movies = MovieData.movies

    val theater1Movies = movies.take(5)
    val theater2Movies = movies.takeLast(5)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "RMUTT Cinema",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            TheaterCard(
                name = "Science Building Theater",
                location = "Faculty of Science",
                movies = theater1Movies,
                navController = navController
            )

            Spacer(modifier = Modifier.height(20.dp))

            TheaterCard(
                name = "Library Theater",
                location = "Learning Resource Center",
                movies = theater2Movies,
                navController = navController
            )
        }
    }
}

@Composable
fun TheaterCard(
    name: String,
    location: String,
    movies: List<com.example.minercineplex.model.Movie>,
    navController: NavController
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = name,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = location,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(12.dp))

            movies.forEach { movie ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {

                    Row {

                        AsyncImage(
                            model = movie.imageUrl,
                            contentDescription = movie.title,
                            modifier = Modifier
                                .width(80.dp)
                                .height(110.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {

                            Text(
                                movie.title,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                movie.genre,
                                color = Color.Gray
                            )

                            Text(
                                "⭐ ${movie.rating}",
                                color = Color(0xFFFFC107)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row {

                        ShowtimeButton("10:30", navController)
                        ShowtimeButton("13:00", navController)
                        ShowtimeButton("16:30", navController)

                    }
                }
            }
        }
    }
}

@Composable
fun ShowtimeButton(time: String, navController: NavController) {

    Button(
        onClick = {
            navController.navigate("seat")
        },
        modifier = Modifier
            .padding(end = 8.dp)
            .height(36.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFC107)
        )
    ) {

        Text(
            text = time,
            color = Color.Black
        )
    }
}