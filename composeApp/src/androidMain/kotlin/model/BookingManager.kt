package com.example.minercineplex.model

object BookingManager {

    val bookedSeats = mutableListOf<String>()

    data class Ticket(
        val movie: String,
        val theater: String,
        val time: String,
        val seats: String
    )

    val myTickets = mutableListOf<Ticket>()

}