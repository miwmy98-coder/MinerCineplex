package com.example.minercineplex.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Profile header
        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                Icons.Default.AccountCircle,
                contentDescription = "profile",
                tint = Color.Gray,
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {

                Text(
                    "Kamki RMUTT",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "kamki@student.rmutt.ac.th",
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        ProfileItem(Icons.Default.ConfirmationNumber, "My Tickets") {
            navController.navigate("mytickets")
        }
        ProfileItem(Icons.Default.History, "Booking History") {
            navController.navigate("history")
        }
        ProfileItem(Icons.Default.Favorite, "Favorite Movies") {
            navController.navigate("favorite")
        }
        ProfileItem(Icons.Default.CreditCard, "Payment Methods") {
            navController.navigate("paymentmethods")
        }
        ProfileItem(Icons.Default.Settings, "Settings") {}
        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.DarkGray)
        Spacer(modifier = Modifier.height(20.dp))
        ProfileItem(Icons.Default.Logout, "Logout") {}
    }
}
@Composable
fun ProfileItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() }   // ⭐ อันนี้คือที่ทำให้กดได้
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, null, tint = Color(0xFFFFC107))
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                color = Color.White
            )
        }
    }
}