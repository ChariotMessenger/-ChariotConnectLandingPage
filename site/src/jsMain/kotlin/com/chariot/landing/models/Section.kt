package com.chariot.landing.models


enum class Section(
    val id: String,
    val title: String,
    val path: String
) {
    Home(
        id = "homeId",
        title = "Home",
        path = "#home"
    ),
    Vendors(
        id = "vendorsId",
        title = "Vendors",
        path = "#about"
    ),
    Riders(
        id = "ridersId",
        title = "Riders",
        path = "#service"
    ),

    Contact(
        id = "contact",
        title = "Contact us",
        path = "#contact"
    )
}