package com.chariot.landing.sections

import androidx.compose.runtime.*
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.MultiplePackage
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun MultiplePackageSection(

) {



    val breakpoint = rememberBreakpoint()

    val sectionContent = remember { MultiplePackage.Content }

    var currentImageIndex by remember { mutableStateOf(0) }
    var nextImageIndex by remember { mutableStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    var nextImageStartPosition by remember { mutableStateOf("translateX(-200px) scale(0.8)") }
    var currentImageTransform by remember { mutableStateOf("translateX(0) scale(1)") }

    // Auto-cycle through images with animation
    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)

            // Start animation
            nextImageIndex = (currentImageIndex + 1) % sectionContent.listOfChangeableImg.size
            nextImageStartPosition = "translateX(0) scale(1)"
            currentImageTransform = "translateX(200px) scale(0.6)"
            isAnimating = true

            // Wait for animation to complete
            delay(500)

            // Update current image and reset
            currentImageIndex = nextImageIndex
            currentImageTransform = "translateX(0) scale(1)"
            nextImageStartPosition = "translateX(-200px) scale(0.8)"
            isAnimating = false
        }
    }


    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            leftRight = if (breakpoint <= Breakpoint.ZERO) {
                30.px
            } else {
                if (breakpoint <= Breakpoint.SM) {
                    50.px
                } else {
                    if (breakpoint <= Breakpoint.MD) {
                        120.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            150.px
                        } else {
                            270.px
                        }
                    }
                }
            }
        )
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 1, md = 2),
            Modifier.fillMaxWidth()
                //.display(DisplayStyle.Grid)

                .gap(
                    rowGap = if (breakpoint <= Breakpoint.ZERO) {
                        20.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            28.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                36.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    48.px
                                } else {
                                    56.px
                                }
                            }
                        }
                    },
                    columnGap =
                        if (breakpoint <= Breakpoint.ZERO) {
                            12.px
                        } else {
                            if (breakpoint <= Breakpoint.SM) {
                                20.px
                            } else {
                                if (breakpoint <= Breakpoint.MD) {
                                    30.px
                                } else {
                                    if (breakpoint <= Breakpoint.LG) {
                                        30.px
                                    } else {
                                        40.px
                                    }
                                }
                            }
                        },
                ),
        )
        {


            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            )
            {


                P(
                    attrs = Modifier
                        .margin(all = 0.px)
                        // .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                        .color(Color.black)
                        .padding(all = 0.px)
                        .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                        .lineHeight( 1.2)
                        .fontSize(
                            if (breakpoint <= Breakpoint.ZERO) {
                                20.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    28.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        32.px
                                    } else {
                                        if (breakpoint <= Breakpoint.LG) {
                                            45.px
                                        } else {
                                            60.px
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
                    Text(value =  sectionContent.title)

                }



                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = 20.px
                            )
                        }
                        .toAttrs()
                )


                RenderMarkdown(
                    editText = sectionContent.description,
                    textColor = Color.black,
                    fontWeightValue = FontWeight.Normal ,
                    fontSize = if (breakpoint <= Breakpoint.ZERO) {
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


            }



            Box(modifier = Modifier
                .fillMaxWidth(),
                 contentAlignment = Alignment.CenterEnd
            ) {


                sectionContent.listOfChangeableImg.forEachIndexed { index, image ->


                    // Current image (sliding out to the right)
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .objectFit(ObjectFit.Contain)
                            .styleModifier {
                                property("opacity", if (isAnimating) "0" else "1")
                                property("transform", currentImageTransform)
                                property("transition", if (isAnimating) "opacity 500ms linear, transform 500ms linear" else "none")
                                property("will-change", "transform, opacity")
                            }
                            .onContextMenu { event ->
                                event.preventDefault()
                                event.stopPropagation()
                            },
                        src = sectionContent.listOfChangeableImg[currentImageIndex],
                        description = "current image",
                    )

                    // Next image (sliding in from left)
                        // if (isAnimating) {
                        Image(
                            modifier = Modifier
                                .fillMaxSize()
                                .objectFit(ObjectFit.Contain)
                                .styleModifier {
                                    property(
                                        "opacity",
                                        //value = "1"
                                        value = if(isAnimating) "1" else "0"
                                    )
                                    property("transform", nextImageStartPosition)
                                    property("transition", "transform 500ms linear")
                                    property("will-change", "transform")
                                }
                               // .visibility(if (isAnimating) Visibility.Visible else Visibility.Hidden)
                                .onContextMenu { event ->
                                    event.preventDefault()
                                    event.stopPropagation()
                                },
                            src = sectionContent.listOfChangeableImg[nextImageIndex],
                            description = "next image",
                        )
                    //}




                }

                Image(
                    modifier = Modifier
                        .transition(
                            Transition.of(property = "transform", duration = 200.ms)
                        )
                        .fillMaxSize()
                        .objectFit(ObjectFit.Contain)
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        }
                        .zIndex(1f),
                    src = sectionContent.mainImgFrame,
                    description = "image",
                )


            }





        }



    }




}