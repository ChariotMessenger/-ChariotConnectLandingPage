package com.chariot.landing.sections

import androidx.compose.runtime.*
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.models.WhatYouNeed
import com.chariot.landing.styles.VisitStoreStyle
import com.chariot.landing.util.ConstantsObject
import com.chariot.landing.util.ResObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@OptIn(DelicateApi::class)
@Composable
fun WhatYouNeedSection(

) {

    val sectionContent = remember { WhatYouNeed.Content }


    val breakpoint = rememberBreakpoint()

    var changingCategoryItem by remember { mutableStateOf(sectionContent.listOfCategoryItem.first()) }

    var changingState by remember { mutableStateOf("enter") }

    val imgHeight by rememberUpdatedState(

            if (breakpoint <= Breakpoint.ZERO) {
                130.px
            } else {
                if (breakpoint <= Breakpoint.SM) {
                    164.px
                } else {
                    if (breakpoint <= Breakpoint.MD) {
                        130.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            176.px
                        } else {
                            194.px
                        }
                    }
                }
            }

    )



    LaunchedEffect(Unit) {
        var index = 0
        while (true) {
            delay(5000)

            // Exit animation
            changingState = "exit"
            delay(800)

            index = (index + 1) % sectionContent.listOfCategoryItem.size
            changingCategoryItem = sectionContent.listOfCategoryItem[index]

            // Enter animation
            changingState = "enter"
            delay(200)
        }
    }




    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {


        if (breakpoint <= Breakpoint.SM) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(leftRight = 20.px)
                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                key(changingCategoryItem) {

                    CustomImage(
                        src = changingCategoryItem.imgPair.first,
                        rotateDegree = (-12).deg,
                        changingState = changingState,
                        imgHeight = imgHeight
                    )

                }


                Div(attrs = {
                    style {
                        width(90.px)
                    }
                })

                key(changingCategoryItem) {

                    CustomImage(
                        src = changingCategoryItem.imgPair.second,
                        rotateDegree = 12.deg,
                        changingState = changingState,
                        imgHeight = imgHeight
                    )


                }



            }

        }


        if (breakpoint <= Breakpoint.SM) {

            Div(attrs = {
                style {
                    height(30.px)
                }
            })
        }


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        )
        {


            if (breakpoint > Breakpoint.SM) {


                key(changingCategoryItem) {

                    CustomImage(
                        src = changingCategoryItem.imgPair.first,
                        rotateDegree = (-12).deg,
                        changingState = changingState,
                        imgHeight = imgHeight
                    )

                }


            }


            Div(attrs = {
                style {
                    width(
                        if (breakpoint <= Breakpoint.ZERO) {
                            8.px
                        } else {
                            if (breakpoint <= Breakpoint.SM) {
                                10.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    15.px
                                } else 20.px
                            }
                        }

                    )
                }
            })



            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {


                H1(
                    attrs = Modifier
                        .margin(all = 0.px)
                        .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                        .color(ThemeByKizito.Typography_Header_Title_Color.rgb)
                        .padding(all = 0.px)
                        .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                        .fontSize(
                            if (breakpoint <= Breakpoint.ZERO) {
                                30.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    46.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        48.px
                                    } else {
                                        if (breakpoint <= Breakpoint.LG) {
                                            60.px
                                        } else {
                                            76.px
                                        }
                                    }
                                }
                            }
                        )
                        //.fontStyle(FontStyle.Normal)
                        .fontWeight(FontWeight.ExtraBold)
                        .whiteSpace(WhiteSpace.NoWrap)//  force single line
                        .overflow(Overflow.Hidden) // (optional) cut off overflow
                        .textOverflow(TextOverflow.Ellipsis)
                        .userSelect(UserSelect.None)
                        .toAttrs()
                ) {

                    Text(value = sectionContent.title)


                }


                Div(attrs = {
                    style {
                        height(10.px)
                    }
                })


                val radiusValue = remember {
                    if (breakpoint <= Breakpoint.ZERO) {
                        18.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            28.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                30.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    42.px
                                } else {
                                    48.px
                                }
                            }
                        }
                    }
                }

               // key(changingCategoryItem) {
                    Box(
                        modifier = Modifier
                            .borderRadius(
                                topLeftAndBottomRight = radiusValue,
                                topRightAndBottomLeft = radiusValue

                            )
                            .border(
                                width = if (breakpoint <= Breakpoint.ZERO) {
                                    1.px
                                } else {
                                    2.px
                                },
                                style = LineStyle.Solid,
                                color = ThemeByKizito.ORANGE_COLOR.rgb,
                            )
                            .opacity(
                                when (changingState) {
                                    "exit" -> 0f
                                    "enter" -> 1f
                                    else -> 1f
                                }
                            )
                            .transition(
                                Transition.of(property = "transform", duration = 1000.ms),
                                Transition.of(property = "opacity", duration = 1000.ms)
                            )
                            .padding(
                                topBottom = if (breakpoint <= Breakpoint.ZERO) {
                                    5.px
                                } else {
                                    if (breakpoint <= Breakpoint.SM) {
                                        6.px
                                    } else {
                                        if (breakpoint <= Breakpoint.MD) {
                                            7.px
                                        } else {
                                            8.px
                                        }
                                    }
                                },
                                leftRight = if (breakpoint <= Breakpoint.ZERO) {
                                    16.px
                                } else {
                                    if (breakpoint <= Breakpoint.SM) {
                                        20.px
                                    } else {
                                        if (breakpoint <= Breakpoint.MD) {
                                            25.px
                                        } else {
                                            if (breakpoint <= Breakpoint.LG) {
                                                30.px
                                            } else {
                                                40.px
                                            }
                                        }
                                    }
                                }
                            )
                            .styleModifier {

                                property(
                                    "transform",
                                    when (changingState) {
                                        "exit" -> "scaleX(1) scaleY(0.0)"
                                        "enter" -> "scaleX(1) scaleY(1)"
                                        else -> "scaleX(1) scaleY(1)"
                                })
                                property("transform-origin", "center")
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        P(
                            attrs = Modifier
                                .margin(all = 0.px)
                                // .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                                .color(ThemeByKizito.ORANGE_COLOR.rgb)
                                .padding(all = 0.px)
                                .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                                .fontSize(
                                    if (breakpoint <= Breakpoint.ZERO) {
                                        16.px
                                    } else {
                                        if (breakpoint <= Breakpoint.SM) {
                                            18.px
                                        } else {
                                            if (breakpoint <= Breakpoint.MD) {
                                                20.px
                                            } else {
                                                if (breakpoint <= Breakpoint.LG) {
                                                    36.px
                                                } else {
                                                    46.px
                                                }
                                            }
                                        }
                                    }

                                )
                                //.fontStyle(FontStyle.Normal)
                                .fontWeight(FontWeight.Bold)
                                .userSelect(UserSelect.None)
                                .toAttrs()

                        ) {
                            Text(value = changingCategoryItem.categoryText)

                        }


                    }


              //  }

                Div(attrs = {
                    style {
                        height(
                            if (breakpoint <= Breakpoint.ZERO) {
                                20.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    25.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        30.px
                                    } else {
                                        if (breakpoint <= Breakpoint.LG) {
                                            35.px
                                        } else {
                                            40.px
                                        }
                                    }
                                }
                            }
                        )
                    }
                })


                P(
                    attrs = Modifier
                        .margin(all = 0.px)
                        .color(Color.black)
                        .padding(all = 0.px)
                        .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                        .fontSize(
                            if (breakpoint <= Breakpoint.ZERO) {
                                10.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    12.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        14.px
                                    } else {
                                        if (breakpoint <= Breakpoint.LG) {
                                            18.px
                                        } else {
                                            20.px
                                        }
                                    }
                                }
                            }

                        )
                        .fontWeight(400)
                        .userSelect(UserSelect.None)
                        .toAttrs()

                ) {
                    Text(value = sectionContent.description)

                }




                Div(attrs = {
                    style {
                        height(
                            if (breakpoint <= Breakpoint.ZERO) {
                                20.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    25.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        30.px
                                    } else {
                                        if (breakpoint <= Breakpoint.LG) {
                                            35.px
                                        } else {
                                            40.px
                                        }
                                    }
                                }
                            }
                        )
                    }
                })

                if (breakpoint > Breakpoint.SM) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        StoreButton(
                            breakpoint = breakpoint,
                            buttonText = "Download on Google Play",
                            buttonIcon = ResObject.Icon.playStore,
                            storeLink = sectionContent.playStoreLink,
                        )

                        Div(attrs = {
                            style {
                                width(
                                    if (breakpoint <= Breakpoint.MD) {
                                        20.px
                                    } else {
                                        40.px
                                    }
                                )
                            }
                        })

                        StoreButton(
                            breakpoint = breakpoint,
                            buttonText = "Download on App Store",
                            buttonIcon = ResObject.Icon.appStore,
                            storeLink = sectionContent.appStoreLink,
                        )
                    }

                } else {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        StoreButton(
                            breakpoint = breakpoint,
                            buttonText = "Download on Google Play",
                            buttonIcon = ResObject.Icon.playStore,
                            storeLink = sectionContent.playStoreLink,
                        )

                        Div(attrs = {
                            style {
                                height(
                                    if (breakpoint <= Breakpoint.ZERO) {
                                        10.px
                                    } else {
                                       18.px
                                    }
                                )
                            }
                        })

                        StoreButton(
                            breakpoint = breakpoint,
                            buttonText = "Download on App Store",
                            buttonIcon = ResObject.Icon.appStore,
                            storeLink = sectionContent.appStoreLink,
                        )
                    }


                }


            }


            Div(attrs = {
                style {
                    width(
                        if (breakpoint <= Breakpoint.ZERO) {
                            8.px
                        } else {
                            if (breakpoint <= Breakpoint.SM) {
                                10.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    15.px
                                } else 20.px
                            }
                        }

                    )
                }
            })


            if (breakpoint > Breakpoint.SM) {

                key(changingCategoryItem) {

                    CustomImage(
                        src = changingCategoryItem.imgPair.second,
                        rotateDegree = 12.deg,
                        changingState = changingState,
                        imgHeight = imgHeight
                    )


                }

            }


        }

    }


}






@Composable
private fun CustomImage(
    src: String,
    rotateDegree: CSSSizeValue<CSSUnit.deg>,
    changingState: String,
    imgHeight:  CSSSizeValue<CSSUnit.px>,

    ) {



Box(modifier = Modifier.height(imgHeight)){


    Image(
        src = src,
        modifier = Modifier
            .transform {
                rotate(rotateDegree)
                when (changingState) {
                    "exit" -> scale(0.995f)
                    "enter" -> scale(1f)
                    else -> scale(1f)
                }

            }
//            .opacity(
//                when (changingState) {
//                    "exit" -> 0.3f
//                    "enter" -> 1f
//                    else -> 1f
//                }
//            )
            .transition(
                Transition.of(property = "transform", duration = 500.ms),
                Transition.of(property = "opacity", duration = 500.ms)
            )
            .margin(top = 30.px) // Offset the image down
            .fillMaxHeight()
            .objectFit(ObjectFit.Contain)
            //.width(imageWidth)
            // Disable right-click / long-press
            .onContextMenu { event ->
                event.preventDefault()
                event.stopPropagation()
            },
        description = "image",
    )

}


}





@Composable
private fun StoreButton(
    breakpoint: Breakpoint,
    buttonText: String,
    buttonIcon: String,
    storeLink: String,

){


    Link(
        modifier = Modifier
            .textDecorationLine(TextDecorationLine.None)
            // Disable right-click / long-press
            .onContextMenu { event ->
                event.preventDefault()
                event.stopPropagation()
            },
        path = storeLink,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    )
    {


        Button(
            attrs = VisitStoreStyle.toModifier()
                .border(width = 0.px)
                .borderRadius(r = 8.px)
                .color(Color.white)
                .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                .fontSize(
                    if (breakpoint <= Breakpoint.ZERO) {
                        10.px
                    }else {
                        if (breakpoint <= Breakpoint.SM) {
                            10.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                12.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    16.px
                                } else {
                                    18.px
                                }
                            }
                        }
                    }

                )
                .fontWeight(400)
                .cursor(Cursor.Pointer)
                .userSelect(UserSelect.None)
                .padding(
                    leftRight = if (breakpoint <= Breakpoint.ZERO){
                        18.px
                    } else {
                        if (breakpoint <= Breakpoint.SM){
                            20.px
                        } else {
                            if (breakpoint <= Breakpoint.MD){
                                26.px
                            } else 30.px
                        }
                    },
                    topBottom =if (breakpoint <= Breakpoint.ZERO){
                        12.px
                    } else {
                        if (breakpoint <= Breakpoint.SM){
                            14.px
                        } else {
                            if (breakpoint <= Breakpoint.MD){
                                16.px
                            } else 18.px
                        }
                    }
                )
                // Disable right-click / long-press
                .onContextMenu { event ->
                    event.preventDefault()
                    event.stopPropagation()
                }
                .toAttrs()
        )
        {

            Row(modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.px)
            ) {

                Image(
                    modifier = Modifier
                        .size(
                            size = if (breakpoint <= Breakpoint.ZERO) {
                                14.px
                            }else {
                                if (breakpoint <= Breakpoint.SM) {
                                    16.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        18.px
                                    } else {

                                        20.px
                                    }
                                }
                            }
                        )
                        // Disable right-click / long-press
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        },
                    src = buttonIcon,
                    description = "store icon",
                )

                Text(value = buttonText)


            }

        }

    }


}




