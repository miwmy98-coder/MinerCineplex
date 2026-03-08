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
import com.example.minercineplex.model.MovieData
import com.example.minercineplex.screens.*

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val movies = MovieData.movies

    Scaffold(

        containerColor = Color.Black,

        bottomBar = {

            NavigationBar(
                containerColor = Color(0xFF111111)
            ) {

                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                NavigationBarItem(
                    selected = currentRoute == "home",
                    onClick = {
                        navController.navigate("home") {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Filled.Home, null) },
                    label = { Text("Home") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFFFC107),
                        selectedTextColor = Color(0xFFFFC107),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    )
                )

                NavigationBarItem(
                    selected = currentRoute == "theater",
                    onClick = {
                        navController.navigate("theater") {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Filled.LocationOn, null) },
                    label = { Text("Theater") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFFFC107),
                        selectedTextColor = Color(0xFFFFC107),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    )
                )

                NavigationBarItem(
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Filled.Person, null) },
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

            // Home
            composable("home") {
                HomeScreen(navController)
            }

            // Movie Detail
            composable("detail/{index}") { backStackEntry ->

                val index =
                    backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0

                MovieDetailScreen(navController, movies[index])
            }

            // Showtime
            composable("showtime") {
                ShowtimeScreen(navController)
            }

            // Seat
            composable("seat") {
                SeatScreen(navController)
            }

            // Booking Summary
            composable("summary/{seats}") { backStackEntry ->

                val seats =
                    backStackEntry.arguments?.getString("seats") ?: ""

                TicketSummaryScreen(navController, seats)
            }

            // Payment
            composable("payment/{seats}") { backStackEntry ->

                val seats =
                    backStackEntry.arguments?.getString("seats") ?: ""

                PaymentScreen(navController, seats)
            }

            // QR Ticket
            composable("ticket/{seats}") { backStackEntry ->

                val seats =
                    backStackEntry.arguments?.getString("seats") ?: ""

                TicketScreen(seats)
            }

            // Theater
            composable("theater") {
                TheaterScreen(navController)
            }

            // Profile
            composable("profile") {
                ProfileScreen(navController)
            }

            // My Tickets
            composable("mytickets") {
                MyTicketsScreen()
            }

            // Booking History
            composable("history") {
                BookingHistoryScreen()
            }

            // Favorite Movies
            composable("favorite") {
                FavoriteMoviesScreen()
            }

            // Payment Methods
            composable("paymentmethods") {
                PaymentMethodsScreen()
            }
        }
    }
}