package com.zitos.web.binkes.styles

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.*
import com.zitos.web.binkes.models.ThemeByKizito






val showdownStyle = CssStyle {

    /*
    // Table Borders
    cssRule("table") {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Color.black
            )
            .borderCollapse(BorderCollapse.Collapse)  // Ensures clean table lines to add Borders for Table Header & Cells
    }

    //  Borders for Table Header & Cells
    cssRule("th, td") {
        Modifier
            .backgroundColor(Color.white)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Color.black
            )
            //.borderCollapse(BorderCollapse.Collapse)
            .alignContent(com.varabyte.kobweb.compose.css.AlignContent.Center)
            .textAlign(TextAlign.Center)
            .padding(8.px)
    }

    // Header Background & Styling
    cssRule("th") {
        Modifier
            .backgroundColor(ThemeByKizito.PersianOrange.rgb)
           // .color(Color.black)
            .fontFamily("Roboto", "sans-serif")
            .fontWeight(FontWeight.Bold)
    }

    // Row Borders (Optional: Improves Table Readability)
    cssRule("tr") {
        Modifier
            .borderBottom(
                width = 1.px,
                style = LineStyle.Solid,
                color = Color.red
            )
    }


    */



    /*
    //  Code Block Styling
    cssRule("pre code") {
        Modifier
            // .backgroundColor(Color.yellow)  // Dark background
            // .color(Color.white)  // Light text color
            .padding(4.px)
            .borderRadius(bottomLeft = 8.px, bottomRight = 8.px)
            .fontFamily("monospace")
            .maxHeight(500.px)
            .fillMaxWidth(50.percent)
            .fontSize(FontSize.Medium)
        //.outline(style = LineStyle.Groove)
    }


    // Inline code (code) → Prevents wrapping, keeps it in a single line
    cssRule("code:not(pre code)") {  // Inline `code` (but not inside <pre>)
        Modifier
            .display(DisplayStyle.InlineBlock)  // Prevents unwanted line breaks
            .backgroundColor(Color.black)
            .color(Color.orange)
            .padding(2.px, 4.px)
            .borderRadius(4.px)
            .fontFamily("monospace")
            .fontSize(FontSize.Small)
            .whiteSpace(WhiteSpace.NoWrap)  //  Prevents line breaks inside inline code
    }


     */





    /*

    // Spoiler class (hover-to-reveal)
    cssRule(".spoiler") {
        Modifier
            .backgroundColor(Color.black)
            .color(Color.red)
            .borderRadius(4.px)
            .padding(2.px, 4.px)
            .cursor(Cursor.Pointer)
            .transition(
                com.varabyte.kobweb.compose.css.Transition.of(
                    property = "color",
                    duration = 0.3.s,
                    timingFunction = AnimationTimingFunction.Ease
                ))

    }

    cssRule("spoiler:hover") {
        Modifier.color(Color.red) // or any color you want for reveal
    }

     */



    //  Ordered list styling
    cssRule("ol li::marker") {
        Modifier.fontWeight(FontWeight.Bold)
    }

    // Ordered list
    cssRule("ol") {
        Modifier
            .margin(0.px)
            .padding(left = 0.px)
            .styleModifier {
                //listStyleType(ListStyleType.Disc) // Can also use Circle or Square
               // listStylePosition(ListStylePosition.Inside.toString())
            }
            .lineHeight(1.5)
    }


    // Unordered list
    cssRule("ul li::marker") {
        Modifier.fontWeight(FontWeight.Bold)
    }

    // Unordered list styling
    cssRule("ul") {
        Modifier
            .margin(0.px)
            .padding(left = 0.px)
            .styleModifier {
                // listStyleType(ListStyleType.Disc) // Can also use Circle or Square
               // listStylePosition(ListStylePosition.Inside.toString())
            }
            .lineHeight(1.5)
    }








    /*
    // inline code Styling
    cssRule("code") {
        Modifier
            .backgroundColor(Color.black)   // Dark background
            .color(Color.orange)            // Text color
            .padding(2.px, 4.px)            // Add padding for readability
            .borderRadius(4.px)             // Rounded corners
            .fontFamily("monospace")        // Use monospace font
            .fontSize(FontSize.Small)       // Smaller text size
    }

     */




    /*

    // Lists (ul, ol) → Proper indentation, no extra <p> inside <li>
     // Showdown options → Fixes rendering inconsistencies
    cssRule("ul, ol") {
        Modifier
            .padding(0.px)
            .margin(0.px, 0.px, 0.px, 20.px) // Indent for readability
    }
    cssRule("li") {
        Modifier
            .padding(4.px, 0.px)
            .lineHeight(1.5)  // Improve readability
    }
    cssRule("li p") {
        Modifier
            .margin(0.px)  // Prevent Showdown from adding <p> inside <li>
    }

     */



    /*

    // Default Blockquote Styling
    cssRule("blockquote") {
        Modifier
            .padding(10.px)
            .margin(10.px, 20.px)
            .borderLeft(width = 4.px, style = LineStyle.Solid, color = Color.gray)
            .backgroundColor(Color.lightgray)
            .color(Color.black)
            .fontStyle(FontStyle.Italic)
    }

    // Error Blockquote
    cssRule(".blockquote-error") {
        Modifier
            .backgroundColor(Color("#ffebe9")) // rgb(255, 235, 233)
            .borderLeft(width = 5.px, style = LineStyle.Solid, color = Color("#d32f2f")) //  rgb(211, 47, 47)
            .color(Color("#b71c1c")) // #b71c1c rgb(183, 28, 28)
            .padding(10.px)
            .margin(10.px, 20.px)
    }

    // Warning Blockquote
    cssRule(".blockquote-warning") {
        Modifier
            .backgroundColor(Color("#fff3cd")) //  rgb(255, 243, 205)
            .borderLeft(width = 5.px, style = LineStyle.Solid, color = Color("#ff9800")) // rgb(255, 152, 0)
            .color(Color("#e65100")) // rgb(230, 81, 0)
            .padding(10.px)
            .margin(10.px, 20.px)
    }

    // Success Blockquote
    cssRule(".blockquote-success") {
        Modifier
            .backgroundColor(Color("#dff0d8")) // rgb(223, 240, 216)
            .borderLeft(width = 5.px, style = LineStyle.Solid, color = Color("#2e7d32")) // rgb(46, 125, 50)
            .color(Color("#1b5e20")) //  rgb(27, 94, 32)
            .padding(10.px)
            .margin(10.px, 20.px)
    }

    // Info Blockquote
    cssRule(".blockquote-info") {
        Modifier
            .backgroundColor(Color("#e3f2fd")) // #e3f2fd .rgb(227, 242, 253)
            .borderLeft(width = 5.px, style = LineStyle.Solid, color = Color("#0288d1")) //  rgb(2, 136, 209)
            .color(Color("#01579b")) //   rgb(1, 87, 155)
            .padding(10.px)
            .margin(10.px, 20.px)
    }

     */



}









/*

val showdownStyle = CssStyle {

    cssRule("table") {
        Modifier
            .border(
                width = 0.2.px,
                style = LineStyle.Solid,
                color = Color.red
            )
    }

    cssRule( "th, td"){
        Modifier .backgroundColor(ThemeByKizito.PersianOrange.rgb)
            .border(
                width = 0.2.px,
                style = LineStyle.Solid,
                color = Color.red
            )
            //.borderCollapse(BorderCollapse.Collapse)
            .alignContent(com.varabyte.kobweb.compose.css.AlignContent.Center)
            .textAlign(TextAlign.Center)
    }

    cssRule( "th") {
        Modifier.backgroundColor(Color.lightgray)
    }


    // Code Block Styling
    cssRule("pre code") {  // Fenced code block
        Modifier
           // .backgroundColor(Color.yellow)  // Dark background
           // .color(Color.white)  // Light text color
            .padding(4.px)
            .borderRadius(bottomLeft = 8.px, bottomRight = 8.px)
            .fontFamily("monospace")

            .maxHeight(500.px)
            .fillMaxWidth(50.percent)
            .fontSize(FontSize.Medium)
            //.outline(style = LineStyle.Groove)
    }




}


 */



