package com.chariot.landing.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.DoMore
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onContextMenu
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text







@OptIn(DelicateApi::class)
@Composable
fun DoMoreSectionSection(

) {


    val breakpoint = rememberBreakpoint()


    val mainHeaderText = remember { DoMore.mainHeaderText }
    val vendorContent = remember { DoMore.Vendor }
    val riderContent = remember { DoMore.Rider }

    val subTitleFontSize = remember {
        if (breakpoint <= Breakpoint.ZERO) {
            17.px
        } else {
            if (breakpoint <= Breakpoint.SM) {
                22.px
            } else {
                if (breakpoint <= Breakpoint.MD) {
                    18.px
                } else {
                    if (breakpoint <= Breakpoint.LG) {
                        20.px
                    } else {
                        26.px
                    }
                }
            }
        }
    }

    val descriptionFontSize = remember {
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
                        14.px
                    } else {
                        16.px
                    }
                }
            }
        }
    }


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


        P(
            attrs = Modifier
                .margin(all = 0.px)
                // .transition(Transition.Companion.of(property = "background", duration = 200.ms))
                .color(Color.black)
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
            Text(value = mainHeaderText)

        }



        Div(
            attrs = Modifier
                .styleModifier {
                    property(
                        propertyName = "height",
                        value = 30.px
                    )
                }
                .toAttrs()
        )



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
                                    80.px
                                } else {
                                    if (breakpoint <= Breakpoint.LG) {
                                        90.px
                                    } else {
                                        180.px
                                    }
                                }
                            }
                        },
                ),
        )
        {


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {



                Image(
                    modifier = Modifier
                        .transition(
                            Transition.of(property = "transform", duration = 200.ms)
                        )
                        .size(50.px)
                        .objectFit(ObjectFit.Contain)
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        }
                        .zIndex(1f),
                    src = vendorContent.icon,
                    description = "icon",
                )


                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = 10.px
                            )
                        }
                        .toAttrs()
                )



                RenderMarkdown(
                    editText = vendorContent.subTitle,
                    textColor = Color.black,
                    fontWeightValue = FontWeight.SemiBold,
                    fontSize = subTitleFontSize
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
                    editText = vendorContent.description,
                    textColor = ThemeByKizito.Typography_Sec_Hint_Color.rgb,
                    fontWeightValue = FontWeight.Normal,
                    fontSize = descriptionFontSize
                )

                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = 26.px
                            )
                        }
                        .toAttrs()
                )

                CustomButton(
                    breakpoint = breakpoint,
                    buttonText = riderContent.buttonText,
                    // fontSizeValue = 15.px,
                    // fontWeightValue = FontWeight.Medium,
                    textColor = ThemeByKizito.Button_Blue_Color.rgb,
                    backgroundColor = ThemeByKizito.Button_Blue_ALPHA1.rgb,
                    storeLink = ""
                )


            }


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            )
            {


                Image(
                    modifier = Modifier
                        .transition(
                            Transition.of(property = "transform", duration = 200.ms)
                        )
                        .size(50.px)
                        .objectFit(ObjectFit.Contain)
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        }
                        .zIndex(1f),
                    src = riderContent.icon,
                    description = "icon",
                )


                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = 10.px
                            )
                        }
                        .toAttrs()
                )


                RenderMarkdown(
                    editText = riderContent.subTitle,
                    textColor = Color.black,
                    fontWeightValue = FontWeight.SemiBold,
                    fontSize = subTitleFontSize
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
                    editText = riderContent.description,
                    textColor = ThemeByKizito.Typography_Sec_Hint_Color.rgb,
                    fontWeightValue = FontWeight.Normal,
                    fontSize = descriptionFontSize
                )


                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = 26.px
                            )
                        }
                        .toAttrs()
                )


                CustomButton(
                    breakpoint = breakpoint,
                    buttonText = riderContent.buttonText,
                    // fontSizeValue = 15.px,
                    // fontWeightValue = FontWeight.Medium,
                    textColor = ThemeByKizito.ORANGE_COLOR.rgb,
                    backgroundColor = ThemeByKizito.ORANGE_ALPHA.rgb,
                    storeLink = ""
                )


            }



        }


    }


}


 val ButtonStyle = CssStyle {
//    base {
//        Modifier
//            .background(Color.black)
//            .fillMaxWidth()
//            .scale(1f)
//            .transition(Transition.of(property = "translate", duration = 100.ms))
//            .transition(Transition.of(property = "background", duration = 200.ms))
//
//    }

    hover{
        Modifier
            .background(ThemeByKizito.Typography_Color_Body_Text.rgb)

            .transition(Transition.of(property = "translate", duration = 200.ms))
            .transition(Transition.of(property = "background", duration = 200.ms))

    }

    active {
        Modifier
            .background(ThemeByKizito.Typography_Header_Title_Color.rgb)
            .scale(0.97f)  // Press down effect
            .transition(Transition.of(property = "transform", duration = 50.ms))
    }

}



@Composable
private fun CustomButton(
    breakpoint: Breakpoint,
    buttonText: String,
    //fontSizeValue: CSSSizeValue<CSSUnit.px>,
    //fontWeightValue: FontWeight,
    textColor: CSSColorValue,
    backgroundColor:  CSSColorValue,
    storeLink: String,
    ){


    Link(
        modifier = ButtonStyle.toModifier()
            .fillMaxWidth()
            .textDecorationLine(TextDecorationLine.None)
            // Disable right-click / long-press
            .onContextMenu { event ->
                event.preventDefault()
                event.stopPropagation()
            },
        path = storeLink,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {


        Button(
            attrs = Modifier
                .background(backgroundColor)
                .fillMaxWidth()
                .border(width = 0.px)
                .borderRadius(r = 8.px)
                .color(textColor)
                .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                .fontSize(
                    if (breakpoint <= Breakpoint.ZERO) {
                        10.px
                    }else {
                        if (breakpoint <= Breakpoint.SM) {
                            14.px
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
                .cursor(Cursor.Pointer)
                .userSelect(UserSelect.None)
                .padding(
                    topBottom =if (breakpoint <= Breakpoint.ZERO){
                        9.px
                    } else {
                        if (breakpoint <= Breakpoint.SM){
                            10.px
                        } else {
                            if (breakpoint <= Breakpoint.MD){
                                12.px
                            } else 12.px
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

            Text(value = buttonText)

        }

    }


}

