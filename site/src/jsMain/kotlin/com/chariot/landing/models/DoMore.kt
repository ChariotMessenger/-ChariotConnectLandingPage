package com.chariot.landing.models

import com.chariot.landing.util.ResObject




enum class DoMore(
    val icon: String,
    val subTitle: String,
    val description: String,
    val buttonText: String,
) {

    Vendor(
        icon = ResObject.Icon.store_icon,
        subTitle = "Become a vendor",
        description = """
            Do you own a restaurant, grocery store, or pharmacy?
            <p>
            Register to Umail to reach new customers and grow your business with ease.
        """.trimIndent(),
        buttonText = "Become a vendor"
    ),

    Rider(
        icon = ResObject.Icon.helment_icon,
        subTitle = "Become a rider",
        description = """
            Want to be a rider who delivers packages to customer?
            <p>
            Become a Umail rider and bring smile to the faces of hundreds and earn while at it.
        """.trimIndent(),
        buttonText = "Become a rider"
    );

    companion object {
        const val mainHeaderText = "Do more with Umail"
    }

}