package com.chariot.landing.models

import com.chariot.landing.util.MyLinksObject
import com.chariot.landing.util.ResObject

data class CategoryItem(
    val categoryText: String,
    val imgPair: Pair<String, String>
)

enum class WhatYouNeed(
    val title: String,
    val description: String,
    val listOfCategoryItem: List<CategoryItem>,
    val playStoreLink: String,
    val appStoreLink: String
) {

    Content(
        title = "What do you need?",
        description = "All from the comfort of your home, office, etc.",
        listOfCategoryItem = listOf(
            CategoryItem(
                categoryText = "Want to Get Food?",
                imgPair = Pair(ResObject.Image.foodImg1, ResObject.Image.foodImg2),
            ),
            CategoryItem(
                categoryText = "Need to Get groceries?",
                imgPair = Pair(ResObject.Image.groceriesImg1, ResObject.Image.groceriesImg2),
            ),
            CategoryItem(
                categoryText = "Need Drugs from Pharmacy?",
                imgPair = Pair(ResObject.Image.pharmacyImg1, ResObject.Image.pharmacyImge2),
            ),
            CategoryItem(
                categoryText = "Want to Send a Package?",
                imgPair = Pair(ResObject.Image.pharmacyImge2, ResObject.Image.packageImge2),
            ),
        ),
        playStoreLink = MyLinksObject.playStoreLink,
        appStoreLink = MyLinksObject.appStoreLink,
    ),

}