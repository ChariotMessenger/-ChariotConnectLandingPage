package com.chariot.landing.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.SupportBusinesses
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
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
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun SupportBusinessesSection() {


    val breakpoint = rememberBreakpoint()

    val sectionContent = remember { SupportBusinesses.Content }








    Column(
        modifier = Modifier
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
            ),
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
        ) {



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
                src = sectionContent.img,
                description = "image",
            )



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



                RenderMarkdown(
                    editText = sectionContent.extraTitle,
                    textColor = Color.black,
                    fontWeightValue = FontWeight.Thin ,
                    // fontFamilyValue = "Inter",
                    fontSize = if (breakpoint <= Breakpoint.ZERO) {
                        21.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            24.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                22.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    28.px
                                } else {
                                    34.px
                                }
                            }
                        }
                    }
                )


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



        }


    }


}