package com.example.minercineplex

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.minercineplex.screens.*
import com.example.minercineplex.screens.movies

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        containerColor = Color.Black,
        bottomBar = {

            NavigationBar(
                containerColor = Color(0xFF111111)
            ) {

                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                // 🏠 Home
                NavigationBarItem(
                    selected = currentRoute == "home",
                    onClick = {
                        navController.navigate("home") {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    },
                    label = { Text("Home") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFFFC107),
                        selectedTextColor = Color(0xFFFFC107),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    )
                )

                // 🎬 Theater
                NavigationBarItem(
                    selected = currentRoute == "theater",
                    onClick = {
                        navController.navigate("theater") {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(Icons.Filled.LocationOn, contentDescription = "Theater")
                    },
                    label = { Text("Theater") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFFFC107),
                        selectedTextColor = Color(0xFFFFC107),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    )
                )

                // 👤 Profile
                NavigationBarItem(
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(Icons.Filled.Person, contentDescription = "Profile")
                    },
                    label = { Text("Profile") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFFFC107),
                        selectedTextColor = Color(0xFFFFC107),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    )
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            // 🏠 Home
            composable("home") {
                HomeScreen(navController)
            }

            // 🎬 Detail (รับ index)
            composable("detail/{index}") { backStackEntry ->
                val index =
                    backStackEntry.arguments?.getString("index")?.toInt() ?: 0
                MovieDetailScreen(navController, movies[index])
            }

            // 🎟 Seat
            composable("seat") {
                SeatScreen(navController)
            }

            // 🎥 Theater
            composable("theater") {
                TheaterScreen()
            }

            // 👤 Profile
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}