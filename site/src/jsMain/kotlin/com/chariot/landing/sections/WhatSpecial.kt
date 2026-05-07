package com.chariot.landing.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.util.ConstantsObject
import com.chariot.landing.util.ResObject
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
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun WhatSpecial(

) {


    val breakpoint = rememberBreakpoint()


    Column(modifier = Modifier
        .padding(
            leftRight = if (breakpoint <= Breakpoint.ZERO) {
                40.px
            } else {
                if (breakpoint <= Breakpoint.SM) {
                    90.px
                } else {
                    if (breakpoint <= Breakpoint.MD) {
                        100.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            150.px
                        } else {
                            200.px
                        }
                    }
                }
            }
        )
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.px),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.px)
        )
        {


            P(
                attrs = Modifier
                    .margin(all = 0.px)
                    // .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                    .color(ThemeByKizito.Typography_Header_Title_Color.rgb)
                    .padding(all = 0.px)
                    .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
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
                Text(value = "What’s so special?")

            }


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
                Text(value = "All from the comfort of your home, office, etc.")

            }


        }



        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 1, md = 2),
            Modifier
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
        ) {


            AiAnimationSection()




            Box(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Image(
                    modifier = Modifier
                        .transition(
                            Transition.of(property = "opacity", duration = 400.ms),
                            Transition.of(property = "transform", duration = 400.ms)
                        )
                        .fillMaxWidth()
                        .objectFit(ObjectFit.Contain)
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        },
                    src = ResObject.Image.img_chat_f,
                    description = "image",
                )
            }




            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .gridColumn("1 / -1") // Span all columns
            ) {

                AppPurposeSection()


            }

        }

    }


}



@Composable
private fun AiAnimationSection(

){

    val showImage2 = remember { mutableStateOf(false) }
    val showImage3 = remember { mutableStateOf(false) }
    val showImage4 = remember { mutableStateOf(false) }


    LaunchedEffect(Unit){
        delay(1200)
        showImage2.value = true

        delay(400)
        showImage3.value = true

        delay(40)
        showImage4.value = true
    }



    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        CustomImage(
            src = ResObject.Image.img_ai_f1
        )

            CustomImage(
                src = ResObject.Image.img_ai_f2,
                isVisible = showImage2.value
            )

            CustomImage(
                src = ResObject.Image.img_ai_f3,
                isVisible = showImage3.value
            )

            CustomImage(
                src = ResObject.Image.img_ai_f4,
                isVisible = showImage4.value

            )

    }

}



@Composable
private fun AppPurposeSection(

){

    val showPhoneImage = remember { mutableStateOf(false) }


    LaunchedEffect(Unit){
        delay(2000)
        showPhoneImage.value = true

    }


    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        CustomImage(
            src = ResObject.Image.img_purpose_f1,
        )

        Image(
            modifier = Modifier
                .opacity(if (showPhoneImage.value) 1f else 0f)
                .transform { scale(if (showPhoneImage.value) 1f else 1.6f) }
                .transition(
                    Transition.of(property = "opacity", duration = 500.ms),
                    Transition.of(property = "transform", duration = 500.ms)
                )
                .fillMaxWidth()
                .objectFit(ObjectFit.Contain)
                .onContextMenu { event ->
                    event.preventDefault()
                    event.stopPropagation()
                },
            src = ResObject.Image.img_purpose_f2,
            description = "image",
        )
    }


}




@Composable
private fun CustomImage(
    src: String,
    isVisible: Boolean = true
) {
    Image(
        modifier = Modifier
            .opacity(if (isVisible) 1f else 0f)
            .transform { scale(if (isVisible) 1f else 0.8f) }
            .transition(
                Transition.of(property = "opacity", duration = 400.ms),
                Transition.of(property = "transform", duration = 400.ms)
            )
            .fillMaxWidth()
            .objectFit(ObjectFit.Contain)
            .onContextMenu { event ->
                event.preventDefault()
                event.stopPropagation()
            },
        src = src,
        description = "image",
    )
}


