package com.chariot.landing.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.styles.LogoStyle
import com.chariot.landing.util.ConstantsObject
import com.chariot.landing.util.ResObject
import com.chariot.landing.util.isDesktop
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun Header (
    onMenuClicked: () -> Unit
){

    val breakPoint = rememberBreakpoint()



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background {
                //ThemeByKizito.Secondary.rgb,
                image(
                    linearGradient(180.deg) {
                        add(ThemeByKizito.Secondary.rgb, 0.percent)
                        add(ThemeByKizito.Secondary.rgb, 5.percent)
                        add(ThemeByKizito.Primary.rgb, 100.percent)
                    }
                )
            }
            .padding(left = 30.px, right = 30.px,
                top = if (breakPoint <= Breakpoint.ZERO) {
                    30.px
                } else {
                    if (breakPoint <= Breakpoint.SM) {
                        40.px
                    } else {
                        if (breakPoint <= Breakpoint.MD) {
                            50.px
                        } else {
                            50.px
                        }
                    }
                },

                bottom = if (breakPoint <= Breakpoint.ZERO) {
                    40.px
                } else {
                    if (breakPoint <= Breakpoint.SM) {
                        80.px
                    } else {
                        if (breakPoint <= Breakpoint.MD) {
                            100.px
                        } else {
                            130.px
                        }
                    }
                }
            ),
        contentAlignment = Alignment.TopCenter
    ) {

        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LeftSide(
                breakpoint = breakPoint,
                onMenuClicked = {
                    onMenuClicked()
                }
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            if (breakPoint > Breakpoint.SM) {
                RightSide(breakpoint = breakPoint)
            }

        }

    }



}


@Composable
fun LeftSide(
    breakpoint: Breakpoint,
    onMenuClicked: () -> Unit
){
    Row (modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){

        Image(
            modifier = Modifier
                .thenIf(
                    condition = isDesktop(),
                    other = LogoStyle.toModifier()
                )
                .maxWidth(if (breakpoint <= Breakpoint.ZERO){
                        80.px
                    }else {

                        if (breakpoint <= Breakpoint.SM) {
                            100.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                130.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    160.px
                                } else {
                                    180.px
                                }
                            }
                        }
                    })
                // Disable right-click / long-press
                . onContextMenu { event ->
                    event.preventDefault()
                    event.stopPropagation()
                },
            src =  ResObject.Icon.logo_white,
            description = "logo icon",
        )

        Spacer()

        if (breakpoint <= Breakpoint.SM) {

            Image(
                modifier = Modifier
                    .cursor(Cursor.Pointer)
                    .onClick {
                        onMenuClicked()
                    }
                    .size(
                        if (breakpoint <= Breakpoint.ZERO) 25.px else 28.px
                    ),
                src = ResObject.Icon.hamburger,
                alt = "hamburger Image"
            )

        }

    }
}



@Composable
fun RightSide(breakpoint: Breakpoint){

    val listOfPage = remember { listOf("Vendors", "Riders", "Contact")}


    Row( modifier = Modifier
        .backgroundColor(ThemeByKizito.Primary_ALPHA1.rgb)
        .borderRadius(r = 50.px)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .borderRadius(r = 50.px)
                .backgroundColor(ThemeByKizito.Primary_ALPHA4.rgb)
                .padding(topBottom = 8.px, leftRight = 16.px),
            horizontalArrangement = Arrangement.spacedBy(18.px),
            verticalAlignment = Alignment.CenterVertically
        )
        {


            listOfPage.forEachIndexed { index, pageName ->

                val linkColor = remember(index) { mutableStateOf(ThemeByKizito.Primary.rgb) }

                val title = if (index == 0) {
                    "Vendors"
                } else {
                    if (index == 1) {
                        "Riders"
                    } else {
                        "Contact"
                    }
                }


                A(
                    href = "/$pageName/",
                    attrs = Modifier
                        .textDecorationLine(TextDecorationLine.None)
                        .padding(topBottom = 8.px, leftRight = 10.px)
                        .cursor(Cursor.Pointer)
                        .margin(all = 0.px)
                        .toAttrs {}
                ) {


                    P(
                        attrs = Modifier
                            .margin(all = 0.px)
                            .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                            .color(linkColor.value)
                            .padding(all = 0.px)
                            .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                            .fontSize(
                                if (breakpoint <= Breakpoint.MD) {
                                    16.px
                                } else {
                                    18.px
                                }
                            )
                            //.fontStyle(FontStyle.Normal)
                            .fontWeight(700)
                            .whiteSpace(WhiteSpace.NoWrap)//  force single line
                            .overflow(Overflow.Hidden) // (optional) cut off overflow
                            .textOverflow(TextOverflow.Ellipsis)
                            .onMouseOut {
                                linkColor.value = ThemeByKizito.Primary.rgb
                            }
                            .onMouseEnter {
                                linkColor.value = ThemeByKizito.Secondary.rgb
                            }
                            .userSelect(UserSelect.None)
                            .toAttrs()
                    ) {
                        Text(value = title)

                    }


                }



                if (index != listOfPage.lastIndex){
                    Div(attrs = {
                        Modifier.width(12.px)
                    })
                }



            }




        }

    }
}






