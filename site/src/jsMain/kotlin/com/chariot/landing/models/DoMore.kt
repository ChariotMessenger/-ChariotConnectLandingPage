package com.chariot.landing.models

import com.chariot.landing.util.ResObject




enum class HappyCustomer(
    val icon: String,
    val title: String,
    val description: String,
    val buttonText: String,
) {

    Vendor(
        icon = ResObject.Image.img_pack_f1,
        title = "Become a vendor",
        description = """
            Do you own a restaurant, grocery store, or pharmacy?

            Register to ChariotConnect to reach new customers and grow your business with ease.
        """.trimIndent(),
        buttonText = "Become a vendor"
    ),

    Rider(
        icon = ResObject.Image.img_pack_f1,
        title = "Become a rider",
        description = """
            Want to be a rider who delivers packages to customer?

            Become a ChariotConnect rider and bring smile to the faces of hundreds and earn while at it.
        """.trimIndent(),
        buttonText = "Become a rider"
    );

    companion object {
        val mainHeaderText = "Do more with Chariotconect"
    }

}