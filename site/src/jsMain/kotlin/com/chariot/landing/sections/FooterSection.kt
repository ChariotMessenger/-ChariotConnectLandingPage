package com.chariot.landing.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.FollowUs
import com.chariot.landing.models.FollowUs.*
import com.chariot.landing.models.Section
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.styles.EmailButtonStyle
import com.chariot.landing.styles.LogoStyle
import com.chariot.landing.styles.NavigationItemStyle
import com.chariot.landing.styles.SocialLinkStyle
import com.chariot.landing.styles.TextInputStyle
import com.chariot.landing.util.ConstantsObject
import com.chariot.landing.util.ResObject
import com.chariot.landing.util.isDesktop
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onContextMenu
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.forms.InputDefaults
import com.varabyte.kobweb.silk.components.forms.InputSize
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaTiktok
import com.varabyte.kobweb.silk.components.icons.fa.FaXTwitter
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.common.PlaceholderColor
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text


@OptIn(DelicateApi::class)
@Composable
fun FooterSection(){

    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(topBottom = if (breakpoint <= Breakpoint.ZERO) 40.px else
                if (breakpoint <= Breakpoint.SM) 60.px else
                    if (breakpoint <= Breakpoint.MD) 70.px else 80.px
            )
            .backgroundColor(Color.black),
        contentAlignment = Alignment.Center
    ) {

        BottonPart(
            breakpoint = breakpoint
        )

    }


}




@Composable
private fun TopPart(
    breakpoint: Breakpoint
){



}



@Composable
private fun BottonPart(
    breakpoint: Breakpoint
) {


    var emailText by remember { mutableStateOf("") }


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
            )
            .backgroundColor(color = Color.black),
        verticalArrangement = Arrangement.Bottom
    ) {


        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2),
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
            )
            {



                Image(
                    modifier = Modifier
                        .transition(
                            Transition.of(property = "transform", duration = 200.ms)
                        )
                        .width(if (breakpoint <= Breakpoint.ZERO){
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
                        .objectFit(ObjectFit.Contain)
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        },
                    src = ResObject.Icon.logo_white,
                    description = "icon",
                )




                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = 15.px
                            )
                        }
                        .toAttrs()
                )



                RenderMarkdown(
                    editText = "More Updates Coming soon",
                    textColor = ThemeByKizito.Gray2.rgb,
                    fontWeightValue = FontWeight.SemiBold,
                    fontSize = if (breakpoint <= Breakpoint.ZERO) {
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
                    editText = "Enter email to get updates ",
                    textColor = ThemeByKizito.Gray2.rgb,
                    fontWeightValue = FontWeight.Normal,
                    fontSize =  if (breakpoint <= Breakpoint.ZERO) {
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



                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .styleModifier {
                            property("display", "flex")
                            property("align-items", "stretch")
                        }
                )
                {


                    // Get the input height from TextInput's internal structure

                    TextInput(
                        text = emailText,
                        onTextChange = { input ->
                            emailText = input
                        },
                        modifier = TextInputStyle.toModifier()
                            .color(color = ThemeByKizito.Hint2_Color.rgb)
                            .styleModifier {
                                // Initial border
                               // property("border", "1px solid ${ThemeByKizito.Faq_Color_Stroke.rgb}")
                              //  property("border-right", "none")
                               // property("border-radius", "8px 0 0 8px")
                                // Ensure consistent height
                                property("height", "auto")
                                property("min-height", "40.px")
                            }
                            .weight(1f),
                        placeholder = "example@gmail.com",
                        placeholderColor = PlaceholderColor(color = ThemeByKizito.Hint2_Color.rgb),
                        size = InputSize.LG,
                        password = false,
                        enabled = InputDefaults.Enabled,
                        autoComplete = AutoComplete.email
                    )





                    Button(
                        attrs = EmailButtonStyle.toModifier()
                            .styleModifier {
                                property("display", "flex")
                                property("align-items", "center")
                                property("justify-content", "center")
                                property("white-space", "nowrap")
                                // Match the input's border style
                                property("border", "0.5px solid ${ThemeByKizito.Faq_Color_Stroke.rgb}")
                                property("border-left", "none")
                            }
                            .borderRadius(
                                topRight = 8.px,
                                bottomRight = 8.px,
                                topLeft = 0.px,
                                bottomLeft = 0.px
                            )
                            .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                            .fontSize(
                                when {
                                    breakpoint <= Breakpoint.ZERO -> 10.px
                                    breakpoint <= Breakpoint.SM -> 14.px
                                    breakpoint <= Breakpoint.MD -> 12.px
                                    breakpoint <= Breakpoint.LG -> 16.px
                                    else -> 18.px
                                }
                            )
                            .color(Color.white)
                            .cursor(Cursor.Pointer)
                            .userSelect(UserSelect.None)
                            .padding(
                                topBottom = when {
                                    breakpoint <= Breakpoint.ZERO -> 9.px
                                    breakpoint <= Breakpoint.SM -> 10.px
                                    else -> 12.px
                                },
                                leftRight = 16.px
                            )
                            .onContextMenu { event ->
                                event.preventDefault()
                                event.stopPropagation()
                            }
                            .toAttrs()
                    ) {
                        Text(value = "Get updates")
                    }




                }




            }





            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            )
            {

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {

                    RenderMarkdown(
                        editText = "Quick links",
                        textColor = ThemeByKizito.Gray2.rgb,
                        fontWeightValue = FontWeight.SemiBold,
                        fontSize = if (breakpoint <= Breakpoint.ZERO) {
                            12.px
                        } else {
                            if (breakpoint <= Breakpoint.SM) {
                                14.px
                            } else {
                                if (breakpoint <= Breakpoint.MD) {
                                    16.px
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

                    Section.entries.forEach { section ->



                        A(href = "/${section.path}",
                            attrs = NavigationItemStyle.toModifier()
                                .cursor(Cursor.Pointer)
                                .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                                .fontSize(
                                    if (breakpoint <= Breakpoint.ZERO) {
                                        12.px
                                    } else {
                                        if (breakpoint <= Breakpoint.SM) {
                                            12.px
                                        } else {
                                            if (breakpoint <= Breakpoint.MD) {
                                                12.px
                                            } else {
                                                if (breakpoint <= Breakpoint.LG) {
                                                    14.px
                                                } else {
                                                    16.px
                                                }
                                            }
                                        }
                                    }
                                )
                                .fontWeight(FontWeight.Medium)
                                .padding(leftRight = 3.px , topBottom = 1.px)
                                .textDecorationLine(TextDecorationLine.None)
                                .userSelect(UserSelect.None)
                                .toAttrs{
                                    onClick {
                                        it.preventDefault()
                                        it.stopPropagation()

                                        //navigateScrollToSection(section.id)


                                    }

                                }
                        ) {

                            Text(value = section.title)

                        }


                        Div(
                            attrs = Modifier
                                .styleModifier {
                                    property(
                                        propertyName = "height",
                                        value = 8.px
                                    )
                                }
                                .toAttrs()
                        )



                    }

                }




                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {


                    RenderMarkdown(
                        editText = "Follow Us",
                        textColor = ThemeByKizito.Gray2.rgb,
                        fontWeightValue = FontWeight.SemiBold,
                        fontSize = if (breakpoint <= Breakpoint.ZERO) {
                            12.px
                        } else {
                            if (breakpoint <= Breakpoint.SM) {
                                14.px
                            } else {
                                if (breakpoint <= Breakpoint.MD) {
                                    16.px
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


                    FollowUs.entries.forEach { follow ->


                        Link(
                            path = follow.link,
                            modifier = Modifier.textDecorationLine(TextDecorationLine.None),
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                        ) {



                            Row(modifier = SocialLinkStyle.toModifier()
                                .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                                .fontSize(
                                    if (breakpoint <= Breakpoint.ZERO) {
                                        12.px
                                    } else {
                                        if (breakpoint <= Breakpoint.SM) {
                                            12.px
                                        } else {
                                            if (breakpoint <= Breakpoint.MD) {
                                                12.px
                                            } else {
                                                if (breakpoint <= Breakpoint.LG) {
                                                    14.px
                                                } else {
                                                    16.px
                                                }
                                            }
                                        }
                                    }
                                )
                                .fontWeight(FontWeight.Medium)
                                .padding(leftRight = 3.px , topBottom = 1.px)
                                .textDecorationLine(TextDecorationLine.None),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.px)

                            ) {


                                when(follow){
                                    Instagram -> {
                                        FaInstagram(
                                            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
                                        )
                                    }
                                    Tiktok -> {
                                        FaTiktok(
                                            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
                                        )
                                    }
                                    Twitter -> {
                                        FaXTwitter(
                                            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
                                        )
                                    }
                                    Linkedin -> {
                                        FaLinkedin(
                                            size =  if(breakpoint <= Breakpoint.ZERO) IconSize.SM else IconSize.LG
                                        )
                                    }
                                }



                                Text(value = follow.title)


                            }

                        }


                        Div(
                            attrs = Modifier
                                .styleModifier {
                                    property(
                                        propertyName = "height",
                                        value = 8.px
                                    )
                                }
                                .toAttrs()
                        )



                    }

                }


            }



        }



    }


}



