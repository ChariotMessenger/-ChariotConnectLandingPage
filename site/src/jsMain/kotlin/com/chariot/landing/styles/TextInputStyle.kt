package com.chariot.landing.styles

import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.focusWithin
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.ms


val TextInputStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                background(ThemeByKizito.LightBlackAlpha.rgb.toString())
                property("border", "0.5px solid ${ThemeByKizito.Faq_Color_Stroke.rgb}")
                property("border-right", "none")
                property("border-radius", "8px 0 0 8px")
                property("height", "auto")
                property("min-height", "40.px")
                property("transition", "border-color 0.2s ease")
                property("outline", "none")
            }
    }

    hover {
        Modifier
            .styleModifier {
                property("border-color", ThemeByKizito.Button_Blue_Color.rgb.toString())
                property("border-right", "none")
            }
    }

    focus {
        Modifier
            .styleModifier {
                property("border-color", ThemeByKizito.Button_Blue_Color.rgb.toString())
                property("border-right", "none")
                property("outline", "none")
            }
    }

    focusWithin {
        Modifier
            .styleModifier {
                property("border-color", ThemeByKizito.Button_Blue_Color.rgb.toString())
                property("border-right", "none")
                property("outline", "none")
            }
    }
}





val EmailButtonStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("display", "flex")
                property("align-items", "center")
                property("justify-content", "center")
                property("white-space", "nowrap")
                property("border", "0.5px solid ${ThemeByKizito.Faq_Color_Stroke.rgb}")
                property("border-left", "none")
                property("border-radius", "0 8px 8px 0")
                property("transition", "border-color 0.2s ease")
                property("background-color", ThemeByKizito.Button_Blue_Color.rgb.toString())
                property("color", Color.white.toString())
            }
            .transition(Transition.of(property = "transform", duration = 50.ms))
    }

    hover {
        Modifier
            .styleModifier {
                property("border-color", ThemeByKizito.Button_Blue_Color.rgb.toString())
                property("border-left", "none")
                property("background-color", ThemeByKizito.ORANGE_COLOR.rgb.toString())// copy(alpha = 0.9f)
            }
            .transition(Transition.of(property = "transform", duration = 50.ms))
    }

    focus {
        Modifier
            .styleModifier {
                property("border-color", ThemeByKizito.Button_Blue_Color.rgb.toString())
                property("border-left", "none")
                property("outline", "none")
            }
            .transition(Transition.of(property = "transform", duration = 50.ms))
    }

    active {
        Modifier
            .background(ThemeByKizito.Typography_Header_Title_Color.rgb)
            .transition(Transition.of(property = "transform", duration = 50.ms))
    }
}

