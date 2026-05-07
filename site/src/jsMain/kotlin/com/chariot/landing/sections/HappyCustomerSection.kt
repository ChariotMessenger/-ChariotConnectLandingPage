package com.chariot.landing.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chariot.landing.components.RenderMarkdown
import com.chariot.landing.models.HappyCustomer
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

// ── Top level - outside any composable ────────────────────
val ScrollLeftKeyframes = Keyframes {
    from { Modifier.translateX(0.percent) }
    to { Modifier.translateX((-70).percent) }
}

val ScrollRightKeyframes = Keyframes {
    from { Modifier.translateX((-70).percent) }
    to { Modifier.translateX(0.percent) }
}

//val AutoScrollRowStyle = CssStyle {
//    //cssRule(":hover") {
//    hover {
//        Modifier.animation(
//            ScrollLeftKeyframes.toAnimation(
//                duration = 20.s,
//                iterationCount = AnimationIterationCount.Infinite,
//                timingFunction = AnimationTimingFunction.Linear,
//                playState = AnimationPlayState.Paused
//            )
//        )
//    }
//}

// Applied to the OUTER container
val AutoScrollContainerStyle = CssStyle {

    cssRule(":hover .scroll-inner") {
        Modifier.styleModifier {
            property("animation-play-state", "paused")
        }
    }
}



@OptIn(DelicateApi::class)
@Composable
fun HappyCustomerSection() {




    val breakpoint = rememberBreakpoint()
    val sectionContent = remember { HappyCustomer.Content }



    val imgLayoutHeight = remember {
        when {
            breakpoint <= Breakpoint.ZERO -> 100.px
            breakpoint <= Breakpoint.SM -> 150.px
            breakpoint <= Breakpoint.MD -> 120.px
            breakpoint <= Breakpoint.LG -> 200.px
            else -> 300.px
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
            Text(value = sectionContent.title)

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
            fontWeightValue = FontWeight.Normal,
            fontSize = when {
                breakpoint <= Breakpoint.ZERO -> 10.px
                breakpoint <= Breakpoint.SM -> 12.px
                breakpoint <= Breakpoint.MD -> 18.px
                breakpoint <= Breakpoint.LG -> 20.px
                else -> 16.px
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


        val gapSpace = remember { 15.px }

        // Scroll left (default - images move from right to left)
        // Top row - scrolls left
        // Top row - scrolls left
        AutoScrollingRow(
           // isScrollEnabled = true,
            //scrollSpeed = 30f, // Lower = faster, higher = slower
            images = sectionContent.topImgList,
            height = imgLayoutHeight,
            gap = gapSpace,
            direction = ScrollDirection.LEFT,
            //pauseOnHover = true,
            onImageClick = { image ->
                println("Image clicked: $image")
            }
        )

        Div(
            attrs = Modifier
                .styleModifier {
                    property(
                        propertyName = "height",
                        value = gapSpace
                    )
                }
                .toAttrs()
        )

        // Bottom row - scrolls right
        AutoScrollingRow(
            //isScrollEnabled = true,
            //scrollSpeed = 30f,
            images = sectionContent.bottomImgList,
            height = imgLayoutHeight,
            gap = gapSpace,
            direction = ScrollDirection.RIGHT,
            //pauseOnHover = true,
            onImageClick = { image ->
                println("Image clicked: $image")
            }
        )



    }
}




// Direction enum
private enum class ScrollDirection {
    LEFT,   // Scrolls from right to left
    RIGHT   // Scrolls from left to right
}




// ── Composable ─────────────────────────────────────────────
@OptIn(DelicateApi::class)
@Composable
private fun AutoScrollingRow(
    images: List<String>,
    height: CSSLengthOrPercentageNumericValue,
    gap: CSSLengthOrPercentageNumericValue = 15.px,
    direction: ScrollDirection = ScrollDirection.LEFT,
    onImageClick: ((String) -> Unit)? = null
) {
    val scrollingImages = remember(images) { images + images }

    val keyframes = remember(direction) {
        if (direction == ScrollDirection.LEFT) ScrollLeftKeyframes else ScrollRightKeyframes
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .overflow(Overflow.Hidden)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .styleModifier {
                    property("flex-shrink", "0")
                    property("white-space", "nowrap")
                }
                .animation(
                    keyframes.toAnimation(
                        duration = 20.s,
                        iterationCount = AnimationIterationCount.Infinite,
                        timingFunction = AnimationTimingFunction.Linear,
                    )
                ),
            horizontalArrangement = Arrangement.spacedBy(gap)
        ) {
            scrollingImages.forEach { img ->
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .objectFit(ObjectFit.Contain)
                        .styleModifier {
                            property("flex-shrink", "0")
                            property("pointer-events", "auto")
                        }
                        .then(
                            onImageClick?.let { click ->
                                Modifier.onClick { click(img) }
                            } ?: Modifier
                        )
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        },
                    src = img,
                    description = "customer image"
                )
            }
        }
    }
}




