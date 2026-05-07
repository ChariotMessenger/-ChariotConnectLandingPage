package com.chariot.landing.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.HappyCustomer
import com.chariot.landing.models.SupportBusinesses
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div


@OptIn(DelicateApi::class)
@Composable
fun HappyCustomerSection(

) {


    val breakpoint = rememberBreakpoint()


    val mainHeaderText = remember { HappyCustomer.mainHeaderText }
    val vendorContent = remember { HappyCustomer.Vendor }
    val riderContent = remember { HappyCustomer.Rider }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                leftRight = if (breakpoint <= Breakpoint.ZERO) {
                    100.px
                } else {
                    if (breakpoint <= Breakpoint.SM) {
                        150.px
                    } else {
                        if (breakpoint <= Breakpoint.MD) {
                            120.px
                        } else {
                            if (breakpoint <= Breakpoint.LG) {
                                200.px
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


        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        )
        {
            RenderMarkdown(
                editText = sectionContent.title,
                textColor = Color.black,
                fontWeightValue = FontWeight.Bold,
                fontSize = if (breakpoint <= Breakpoint.ZERO) {
                    19.px
                } else {
                    if (breakpoint <= Breakpoint.SM) {
                        22.px
                    } else {
                        if (breakpoint <= Breakpoint.MD) {
                            20.px
                        } else {
                            if (breakpoint <= Breakpoint.LG) {
                                26.px
                            } else {
                                32.px
                            }
                        }
                    }
                }
            )



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
                                14.px
                            } else {
                                16.px
                            }
                        }
                    }
                }
            )


        }


        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        )
        {
            RenderMarkdown(
                editText = sectionContent.title,
                textColor = Color.black,
                fontWeightValue = FontWeight.Bold,
                fontSize = if (breakpoint <= Breakpoint.ZERO) {
                    19.px
                } else {
                    if (breakpoint <= Breakpoint.SM) {
                        22.px
                    } else {
                        if (breakpoint <= Breakpoint.MD) {
                            20.px
                        } else {
                            if (breakpoint <= Breakpoint.LG) {
                                26.px
                            } else {
                                32.px
                            }
                        }
                    }
                }
            )



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
                                14.px
                            } else {
                                16.px
                            }
                        }
                    }
                }
            )


        }


    }


}