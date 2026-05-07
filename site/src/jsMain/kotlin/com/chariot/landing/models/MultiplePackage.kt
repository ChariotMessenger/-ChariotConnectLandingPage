package com.chariot.landing.models

import com.chariot.landing.util.MyLinksObject
import com.chariot.landing.util.ResObject








enum class MultiplePackage(
    val title: String,
    val description: String,
    val mainImgFrame: String,
    val listOfChangeableImg:  List<String>,
    ) {

    Content(
        title = """
            Send Multiple
            Packages at once
        """.trimIndent(),
        description = """
            Deliver 1 or multiple packages to all your loved ones, friends and customers with **Umail** all on one pickup.
        """.trimIndent(),
        mainImgFrame = ResObject.Image.img_pack_f1,
        listOfChangeableImg = listOf(
            ResObject.Image.img_pack_f2,
            ResObject.Image.img_pack_f3,
            ResObject.Image.img_pack_f4,
        )
    )

}

