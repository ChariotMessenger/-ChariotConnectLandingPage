package com.chariot.landing.styles


import com.chariot.landing.models.ThemeByKizito
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px


val NavigationItemStyle = CssStyle {

    base {
        Modifier
            .styleModifier {
                property("color", ThemeByKizito.Primary.rgb)
            }
            .color(ThemeByKizito.Primary.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier {
                property("color", ThemeByKizito.ORANGE_COLOR.rgb)
            }
            .color(ThemeByKizito.ORANGE_COLOR.rgb)
    }
}






val LogoStyle = CssStyle{
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(Transition.of(property = "transform", duration = 200.ms))
    }

    hover {
        Modifier
            .transform { rotate((-10).deg) }
    }
}


val SocialLinkStyle = CssStyle {
    base {
        Modifier
            .color(ThemeByKizito.Primary.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }

    hover{
        Modifier.color(ThemeByKizito.ORANGE_COLOR.rgb)
    }
}



val MainButtonStyle = CssStyle{
    base {
        Modifier
            .width(100.px)
            .transition(Transition.of(property = "width", duration = 200.ms))

    }

    hover{

        Modifier.width(120.px)
    }

}
