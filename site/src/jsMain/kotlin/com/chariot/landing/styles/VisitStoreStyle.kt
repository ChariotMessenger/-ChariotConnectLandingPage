package com.chariot.landing.styles

import com.chariot.landing.models.ThemeByKizito
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms


val VisitStoreStyle = CssStyle {
    base {
        Modifier
            .background(Color.black)
            .fillMaxWidth()
            .scale(1f)
            .transition(Transition.of(property = "translate", duration = 100.ms))
            .transition(Transition.of(property = "background", duration = 200.ms))

    }

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
