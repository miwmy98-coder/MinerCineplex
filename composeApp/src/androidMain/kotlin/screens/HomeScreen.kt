package com.example.minercineplex.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.minercineplex.model.MovieData
@Composable
fun HomeScreen(navController: NavController) {
    val movies = MovieData.movies
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            "Trending Movies",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            itemsIndexed(movies) { index, movie ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(200.dp)
                        .clickable {
                            navController.navigate("detail/$index")
                        }
                ) {
                    AsyncImage(
                        model = movie.imageUrl,
                        contentDescription = movie.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(300.dp)
                    )
                }
            }
        }
        Text(
            "Now Showing",
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {
            itemsIndexed(movies) { index, movie ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clickable {
                            navController.navigate("detail/$index")
                        }
                ) {
                    AsyncImage(
                        model = movie.imageUrl,
                        contentDescription = movie.title,
                        modifier = Modifier
                            .width(100.dp)
                            .height(140.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(movie.title, color = Color.White)
                        Text(movie.genre, color = Color.Gray)
                        Text(
                            "⭐ ${movie.rating}",
                            color = Color.Yellow
                        )
                    }
                }
            }
        }
    }
}