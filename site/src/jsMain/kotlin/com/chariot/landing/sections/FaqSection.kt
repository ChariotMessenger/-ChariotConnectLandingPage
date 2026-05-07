package com.chariot.landing.sections

import androidx.compose.runtime.*
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.Questions
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.util.ConstantsObject
import com.chariot.landing.util.ResObject
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
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
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text




@OptIn(DelicateApi::class)
@Composable
fun FaqSection() {

    val breakpoint = rememberBreakpoint()


    val sectionContent = remember { Questions }




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
                .align(Alignment.CenterHorizontally)
                .toAttrs()

        ) {
            Text(value = sectionContent.title)

        }



        Div(
            attrs = Modifier
                .styleModifier {
                    property(
                        propertyName = "height",
                        value =  if (breakpoint <= Breakpoint.SM){
                            30.px
                        }else{
                            40.px
                        }
                    )
                }
                .toAttrs()
        )


        if (breakpoint <= Breakpoint.SM){

            MobileView(
                breakpoint = breakpoint,
                sectionContent = sectionContent.getAllQuestions(),
            )

        }else{

            DesktopView(
                breakpoint = breakpoint,
                sectionContent = sectionContent.getAllQuestions(),
            )

        }




    }


}





@Composable
private fun DesktopView(
    breakpoint: Breakpoint,
    sectionContent: List<Questions>
) {
    var selectedIndex by remember { mutableStateOf(0) }
    var hoveredIndex by remember { mutableStateOf(-1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .styleModifier {
                property("display", "flex")
                property("align-items", "stretch")
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .border(
                    width = 5.px,
                    style = LineStyle.Solid,
                    color = Color.black
                )
                .borderRadius(r = 10.px)
                .padding(
                    leftRight = if (breakpoint <= Breakpoint.MD) {
                        10.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            15.px
                        } else {
                            20.px
                        }
                    }
                )
                .transition(
                    Transition.of(
                        property = "all",
                        duration = 300.ms,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            sectionContent.forEachIndexed { index, quesAns ->

                if (index == 0){

                    Div(
                        attrs = Modifier
                            .styleModifier {
                                property("transition", "height 0.3s ease")
                                property(
                                    propertyName = "height",
                                    value = 20.px
                                )
                            }
                            .toAttrs()
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .borderRadius(r = 8.px)
                        .styleModifier {
                            property("transition", "all 0.3s cubic-bezier(0.4, 0, 0.2, 1)")
                            property("cursor", "pointer")
                        }
                        .background(
                            when {
                                index == selectedIndex -> Color.black
                                hoveredIndex == index -> ThemeByKizito.Purple_ALPHA2.rgb
                                else -> ThemeByKizito.Button_Blue_ALPHA2.rgb
                            }
                        )
                        .border(
                            width = 0.5.px,
                            style = LineStyle.Solid,
                            color = ThemeByKizito.Faq_Color_Stroke.rgb
                        )
                        .padding(
                            all = if (breakpoint <= Breakpoint.MD) {
                                10.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    15.px
                                } else {
                                    20.px
                                }
                            }
                        )
                        .onClick {
                            selectedIndex = index
                        }
                        .onMouseEnter {
                            hoveredIndex = index
                        }
                        .onMouseLeave {
                            hoveredIndex = -1
                        }
                ) {
                    P(
                        attrs = Modifier
                            .margin(all = 0.px)
                            .color(
                                if (index == selectedIndex) Color.white
                                else ThemeByKizito.Button_Blue_Color.rgb
                            )
                            .padding(all = 0.px)
                            .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                            .fontSize(
                                if (breakpoint <= Breakpoint.MD) {
                                    12.px
                                } else {
                                    if (breakpoint <= Breakpoint.LG) {
                                        16.px
                                    } else {
                                        18.px
                                    }
                                }
                            )
                            .fontWeight(FontWeight.Bold)
                            .weight(1f)
                            .transition(
                                Transition.of(
                                    property = "color",
                                    duration = 250.ms
                                )
                            )
                            .toAttrs()
                    ) {
                        Text(value = quesAns.qus)
                    }

                    if (selectedIndex == index) {
                        Image(
                            modifier = Modifier
                                .transition(
                                    Transition.of(
                                        property = "transform",
                                        duration = 300.ms,
                                        timingFunction = AnimationTimingFunction.EaseInOut
                                    )
                                )
                                .size(18.px)
                                .styleModifier {
                                    property("transform", "translateX(0px)")
                                }
                                .onContextMenu { event ->
                                    event.preventDefault()
                                    event.stopPropagation()
                                },
                            src = ResObject.Icon.arrow_right,
                            description = "icon",
                        )
                    } else {
                        Box(modifier = Modifier.size(18.px))
                    }
                }


                Div(
                    attrs = Modifier
                        .styleModifier {
                            property(
                                propertyName = "height",
                                value = if (index == sectionContent.lastIndex){
                                    20.px
                                }else{
                                    10.px
                                }
                            )
                            property("transition", "height 0.3s ease")
                        }
                        .toAttrs()
                )

            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(44.percent)
                .padding(
                    top = if (breakpoint <= Breakpoint.MD) {
                        30.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            40.px
                        } else {
                            50.px
                        }
                    },
                    bottom = if (breakpoint <= Breakpoint.MD) {
                        10.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            20.px
                        } else {
                            30.px
                        }
                    }
                )
                .transition(
                    Transition.of(
                        property = "all",
                        duration = 350.ms,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                )
        ) {
            val topBottomPadding = remember {
                if (breakpoint <= Breakpoint.MD) {
                    18.px
                } else {
                    if (breakpoint <= Breakpoint.LG) {
                        24.px
                    } else {
                        30.px
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .borderRadius(topRight = topBottomPadding, bottomRight = topBottomPadding)
                    .background(color = Color.black)
                    .padding(
                        leftRight = if (breakpoint <= Breakpoint.MD) {
                            15.px
                        } else {
                            if (breakpoint <= Breakpoint.LG) {
                                20.px
                            } else {
                                30.px
                            }
                        }
                    )
                    .transition(
                        Transition.of(
                            property = "transform",
                            duration = 300.ms,
                            timingFunction = AnimationTimingFunction.EaseInOut
                        )
                    ),
                verticalArrangement = Arrangement.spacedBy(20.px),
            ) {
                Div(
                    attrs = Modifier
                        .styleModifier {
                            property("height", "30.px")
                            property("transition", "height 0.3s ease")
                        }
                        .toAttrs()
                )

                P(
                    attrs = Modifier
                        .margin(all = 0.px)
                        .color(Color.white)
                        .padding(all = 0.px)
                        .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                        .fontSize(
                            if (breakpoint <= Breakpoint.MD) {
                                16.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    20.px
                                } else {
                                    26.px
                                }
                            }
                        )
                        .fontWeight(FontWeight.Bold)
                        .transition(
                            Transition.of(
                                property = "color",
                                duration = 250.ms
                            )
                        )
                        .toAttrs()
                ) {
                    Text(value = sectionContent[selectedIndex].qus)
                }

                RenderMarkdown(
                    editText = sectionContent[selectedIndex].ans,
                    textColor = ThemeByKizito.Gray2.rgb,
                    fontWeightValue = FontWeight.Normal,
                    fontSize = if (breakpoint <= Breakpoint.MD) {
                        14.px
                    } else {
                        if (breakpoint <= Breakpoint.LG) {
                            16.px
                        } else {
                            18.px
                        }
                    }
                )

                Div(
                    attrs = Modifier
                        .styleModifier {
                            property("height", "12.px")
                            property("transition", "height 0.3s ease")
                        }
                        .toAttrs()
                )
            }
        }
    }
}





@Composable
private fun MobileView(
    breakpoint: Breakpoint,
    sectionContent: List<Questions>
) {
    var selectedIndex by remember { mutableStateOf(-1) } // -1 means none selected
    var hoveredIndex by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint <= Breakpoint.ZERO) 100.percent else 90.percent
            )
            .border(
                width = 5.px,
                style = LineStyle.Solid,
                color = Color.black
            )
            .borderRadius(r = 10.px)
            .padding(
                leftRight = if (breakpoint <= Breakpoint.ZERO) 10.px else 20.px
            )
            .transition(
                Transition.of(
                    property = "all",
                    duration = 500.ms, // Slower
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        sectionContent.forEachIndexed { index, quesAns ->
            val isExpanded = selectedIndex == index


            if (index == 0){

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
            }

            // Question Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .borderRadius(r = 8.px)
                    .styleModifier {
                        property("transition", "all 0.4s ease") // Slower hover
                        property("cursor", "pointer")
                    }
                    .background(
                        when {
                            isExpanded -> Color.black
                            hoveredIndex == index -> ThemeByKizito.Purple_ALPHA2.rgb
                            else -> ThemeByKizito.Button_Blue_ALPHA2.rgb
                        }
                    )
                    .border(
                        width = 0.5.px,
                        style = LineStyle.Solid,
                        color = ThemeByKizito.Faq_Color_Stroke.rgb
                    )
                    .padding(
                        all = if (breakpoint <= Breakpoint.ZERO) 10.px else 14.px
                    )
                    .onClick {
                        selectedIndex = if (isExpanded) -1 else index
                    }
                    .onMouseEnter { hoveredIndex = index }
                    .onMouseLeave { hoveredIndex = -1 }
            ) {
                P(
                    attrs = Modifier
                        .margin(all = 0.px)
                        .color(
                            if (isExpanded) Color.white
                            else ThemeByKizito.Button_Blue_Color.rgb
                        )
                        .padding(all = 0.px)
                        .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                        .fontSize(
                            if (breakpoint <= Breakpoint.ZERO) 10.px else 14.px
                        )
                        .fontWeight(FontWeight.Bold)
                        .weight(1f)
                        .transition(
                            Transition.of(
                                property = "color",
                                duration = 400.ms // Slower color transition
                            )
                        )
                        .toAttrs()
                ) {
                    Text(value = quesAns.qus)
                }

                // Animated Arrow Icon
                Image(
                    modifier = Modifier
                        .size(if (breakpoint <= Breakpoint.ZERO) 12.px else 15.px)
                        .transition(
                            Transition.of(
                                property = "transform",
                                duration = 500.ms, // Slower rotation
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                        )
                        .styleModifier {
                            if (isExpanded) {
                                property("transform", "rotate(90deg)")
                            } else {
                                property("transform", "rotate(0deg)")
                            }
                        }
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        },
                    src = ResObject.Icon.arrow_right,
                    description = "expand icon",
                )
            }

            // Animated Answer Content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .transition(
                        Transition.of(
                            property = "all",
                            duration = 500.ms, // Slower expansion
                            timingFunction = AnimationTimingFunction.EaseInOut
                        )
                    )
                    .styleModifier {
                        if (isExpanded) {
                            property("opacity", "1")
                            property("max-height", "1000px")
                            property("visibility", "visible")
                        } else {
                            property("opacity", "0")
                            property("max-height", "0")
                            property("visibility", "hidden")
                        }
                        property("overflow", "hidden")
                        property("transition", "all 0.5s cubic-bezier(0.4, 0, 0.2, 1)") // Slower with custom easing
                    }
            ) {
                if (isExpanded) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(left = 8.px, right = 8.px, top = 4.px, bottom = 10.px)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .borderRadius(topLeft = 10.px, topRight = 10.px)
                                .background(color = Color.black)
                                .padding(
                                    leftRight = if (breakpoint <= Breakpoint.ZERO) 8.px else 10.px,
                                    topBottom = 10.px
                                )
                                .transition(
                                    Transition.of(
                                        property = "transform",
                                        duration = 400.ms // Slower content fade
                                    )
                                ),
                            verticalArrangement = Arrangement.spacedBy(20.px),
                        ) {
                            RenderMarkdown(
                                editText = quesAns.ans,
                                textColor = ThemeByKizito.Gray2.rgb,
                                fontWeightValue = FontWeight.Normal,
                                fontSize = if (breakpoint <= Breakpoint.ZERO) 10.px else 12.px
                            )
                        }
                    }
                }
            }

            // Bottom spacer with height transition

            Div(
                attrs = Modifier
                    .styleModifier {
                        property(
                            propertyName = "height",
                            value = if (index == sectionContent.lastIndex){
                                30.px
                            }else{
                                14.px
                            }
                        )
                        property("transition", "height 0.5s cubic-bezier(0.4, 0, 0.2, 1)") // Slower
                    }
                    .toAttrs()
            )
        }
    }
}
