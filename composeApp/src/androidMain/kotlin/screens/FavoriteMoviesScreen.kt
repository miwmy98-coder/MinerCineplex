package com.example.minercineplex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minercineplex.model.MovieData

@Composable
fun FavoriteMoviesScreen(){

    val movies = MovieData.movies.take(3)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ){

        item{
            Text(
                "Favorite Movies",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(movies){

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
            ){

                Column(
                    modifier = Modifier.padding(16.dp)
                ){

                    Text(it.title,color = Color.White)

                    Text(
                        it.genre,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}