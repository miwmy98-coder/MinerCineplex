package com.example.minercineplex.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun PaymentMethodsScreen(){
    val methods = listOf(
        "Credit Card **** 4242",
        "PromptPay",
        "TrueMoney Wallet"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ){
        item{
            Text(
                "Payment Methods",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(methods){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
            ){
                Text(
                    it,
                    modifier = Modifier.padding(20.dp),
                    color = Color.White
                )
            }
        }
    }
}