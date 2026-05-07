package com.chariot.landing.pages

import androidx.compose.runtime.*
import com.chariot.landing.components.Header
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.sections.DoMoreSectionSection
import com.chariot.landing.sections.FaqSection
import com.chariot.landing.sections.FooterSection
import com.chariot.landing.sections.HappyCustomerSection
import com.chariot.landing.sections.MultiplePackageSection
import com.chariot.landing.sections.SupportBusinessesSection
import com.chariot.landing.sections.WhatSpecial
import com.chariot.landing.sections.WhatYouNeedSection
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.worker.rememberWorker
import com.chariot.landing.worker.EchoWorker
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div


@OptIn(DelicateApi::class)
@Page
@Composable
fun HomePage() {


    var isMenuOpened by remember { mutableStateOf(false) }

    val breakpoint = rememberBreakpoint()

    var isContentReady by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()


    // DOM content is ready (without waiting for images/fonts)
    LaunchedEffect(Unit) {
        document.addEventListener("DOMContentLoaded", {
            //console.log(" DOM is fully built, but assets may still be loading.")
            scope.launch {
                delay(300)
                isContentReady = true
            }
        })
    }



    println(breakpoint.name)


    Box(
        modifier = Modifier
            .minHeight(100.vh)
            .width(100.vw)
            .background(ThemeByKizito.Primary.rgb)
            .overflow(Overflow.Hidden)
    ) {


        Box(
            modifier = Modifier
            .minHeight(100.vh)
                .width(100.vw)
            .then(
                if (isMenuOpened) {
                    Modifier
                        .background(ThemeByKizito.Primary_ALPHA1.rgb)
                        .onClick {
                            isMenuOpened = false
                        }
                } else {
                    Modifier
                })
        ) {


            if (isContentReady) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ThemeByKizito.Primary_ALPHA1.rgb)
                        .overflow(overflowY = Overflow.Scroll, overflowX = Overflow.Auto),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    Header(
                        onMenuClicked = {

                        }
                    )


                    Div(
                        attrs = Modifier
                            .styleModifier {
                                property(
                                    propertyName = "height",
                                    value = 18.px
                                )
                            }
                            .toAttrs()
                    )


                    WhatYouNeedSection()


                    Div(
                        attrs = Modifier
                            .styleModifier {

                                property(
                                    propertyName = "height",
                                    value = if (breakpoint <= Breakpoint.ZERO) {
                                        130.px
                                    } else {
                                        if (breakpoint <= Breakpoint.SM) {
                                            150.px
                                        } else {
                                            if (breakpoint <= Breakpoint.MD) {
                                                180.px
                                            } else {
                                                if (breakpoint <= Breakpoint.LG) {
                                                    200.px
                                                } else {
                                                    230.px
                                                }
                                            }
                                        }
                                    }
                                )

                            }
                            .toAttrs()
                    )

                    WhatSpecial()


                    CustomSpacer(breakpoint = breakpoint)


                    MultiplePackageSection()


                    Div(
                        attrs = Modifier
                            .styleModifier {

                                property(
                                    propertyName = "height",
                                    value = if (breakpoint <= Breakpoint.ZERO) {
                                        100.px
                                    } else {
                                        if (breakpoint <= Breakpoint.SM) {
                                            120.px
                                        } else {
                                            if (breakpoint <= Breakpoint.MD) {
                                                160.px
                                            } else {
                                                if (breakpoint <= Breakpoint.LG) {
                                                    180.px
                                                } else {
                                                    200.px
                                                }
                                            }
                                        }
                                    }
                                )

                            }
                            .toAttrs()
                    )


                    SupportBusinessesSection()


                    CustomSpacer(breakpoint = breakpoint)

                    HappyCustomerSection()

                    CustomSpacer(breakpoint = breakpoint)


                    DoMoreSectionSection()

                    CustomSpacer(breakpoint = breakpoint)

                    FaqSection()

                    CustomSpacer(breakpoint = breakpoint)
                    CustomSpacer(breakpoint = breakpoint)

                    FooterSection()


                }


            }


        }


    }


}


@Composable
private fun CustomSpacer(
    breakpoint: Breakpoint
){


    Div(
        attrs = Modifier
            .styleModifier {

                property(
                    propertyName = "height",
                    value = if (breakpoint <= Breakpoint.ZERO) {
                        90.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            110.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                150.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    170.px
                                } else {
                                    190.px
                                }
                            }
                        }
                    }
                )

            }
            .toAttrs()
    )

}