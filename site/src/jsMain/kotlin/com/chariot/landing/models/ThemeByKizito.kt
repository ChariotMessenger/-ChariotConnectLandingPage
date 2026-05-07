package com.chariot.landing.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba


enum class ThemeByKizito(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#FFFFFF", rgb = rgb(r = 252, g = 252, b = 252)),
    Secondary(hex = "#2C2BD1", rgb = rgb(r = 44, g = 43, b = 209)),
    SecondaryLighter(hex = "#6F6FD1", rgb = rgb(111, 111, 209)),
    Gray(hex = "#CFCFCF", rgb = rgb(r = 207, g = 207, b = 207)),

    // Typography colors - convert hex to RGB values
    Typography_Color_Body_Text(hex = "#334155", rgb = rgb(51, 65, 85)),
    Typography_Header_Title_Color(hex = "#0F172A", rgb = rgb(15, 23, 42)),
    Typography_Sec_Hint_Color(hex = "#64748B", rgb = rgb(100, 116, 139)),
    Typography_Disabled_Color(hex = "#94A3B8", rgb = rgb(148, 163, 184)),

    ORANGE_COLOR(hex = "#FF8C00", rgb = rgb(255, 140, 0)),

    Neutral_Color_Stroke(hex = "#E2E8F0", rgb = rgb(226, 232, 240)),
    Neutral_Color_Surface_Card(hex = "#F8F9FC", rgb = rgb(248, 249, 252)),

    Faq_Color_Stroke(hex = "#E7EEEC", rgb = rgb(231, 238, 236)),

    Gray2(hex = "#B5B5B5", rgb = rgb(181, 181, 181)),

    LightBlack(hex = "#585858", rgb = rgb(88, 88, 88)),




    Hint2_Color(hex = "#8E8E8E", rgb = rgb(142, 142, 142)),


    Icon_Neutal_State(hex = "#64748B", rgb = rgb(100, 116, 139)),

    Semantic_Error_Color(hex = "#EF4444", rgb = rgb(239, 68, 68)),
    Semantic_Success_Color(hex = "#10B981", rgb = rgb(16, 185, 129)),

    Button_Blue_Color(hex = "#2C2BD1", rgb = rgb(44, 43, 209)),

    Pink_Color(hex = "#F418B2", rgb = rgb(244, 24, 178)),
    Purple_Color(hex = "#6C19FF", rgb = rgb(108, 25, 255)),
    Grey_Color(hex = "#D9D9D9", rgb = rgb(217, 217, 217)),
    Light_Grey_Color(hex = "#EFEFEF", rgb = rgb(239, 239, 239)),

    // Alpha variants
    Primary_ALPHA1(hex = "#2C2BD1", rgb = rgba(r = 252, g = 252, b = 252, a = 0.20f)),
    Primary_ALPHA4(hex = "#CB7154", rgb = rgba(r = 203, g = 113, b = 84, a = 0.02f)),


    ORANGE_ALPHA(hex = "#FF8C00", rgb = rgba(255, 140, 0, a = 0.10f)),
    Button_Blue_ALPHA1(hex = "#2C2BD1", rgb = rgba(r = 44, g = 43, b = 209, a = 0.10f)),

    Purple_ALPHA2(hex = "#6C19FF", rgb = rgba(108, 25, 255, a = 0.20f)),

    Button_Blue_ALPHA2(hex = "#2C2BD1", rgb = rgba(r = 44, g = 43, b = 209, a = 0.02f)),

    LightBlackAlpha(hex = "#585858", rgb = rgba(r = 88, g = 88, b = 88, a = 0.2f)),


}




