package com.chariot.landing.models


enum class Section(
    val id: String,
    val title: String,
    val path: String
) {


    WhatYouNeed(
        id = "whatYouNeedId",
        title = "",
        path = "#whatYouNeedId"
    ),

    WhatSpecialIconTop(
        id = " whatSpecialImageTopId",
        title = "",
        path = "#whatSpecialImageTopId"
    ),

    WhatSpecialIconBottom(
        id = "whatSpecialImageBottomId",
        title = "",
        path = "#whatSpecialImageBottomId"
    ),



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