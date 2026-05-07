package com.chariot.landing.models

import com.chariot.landing.util.ResObject


enum class HappyCustomer(
    val title: String,
    val description: String,
    val topImgList: List<String>,
    val bottomImgList: List<String>

    ) {

    Content(
        title = "Happy Customers",
        description = """
            **Umail** has made customers happy across the country by delivering smile
        """.trimIndent(),
        topImgList = listOf(
            ResObject.Image.happy_top1_img,
            ResObject.Image.happy_top2_img,
            ResObject.Image.happy_top3_img,
            ResObject.Image.happy_top4_img,
            ResObject.Image.happy_top5_img,
            ResObject.Image.happy_top6_img,
        ),
        bottomImgList = listOf(
            ResObject.Image.happy_bottom1_img,
            ResObject.Image.happy_bottom2_img,
            ResObject.Image.happy_bottom_img3,
            ResObject.Image.happy_bottom4_img,
            ResObject.Image.happy_bottom5_img,
            ResObject.Image.happy_bottom6_img,
        ),
    )


}