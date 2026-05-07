package com.chariot.landing.components

import androidx.compose.runtime.*
import com.chariot.landing.models.ThemeByKizito
import com.chariot.landing.styles.showdownStyle
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import org.w3c.dom.asList


// Top-level declarations
@JsName("showdown")
external object Showdown {
    class Converter(options: dynamic) {
        fun makeHtml(markdown: String): String
    }
}



@JsName("hljs")
external object HlJs {
    fun highlightElement(element: dynamic)
    fun highlightBlock(block: dynamic)
    fun highlight(language: String, code: String): dynamic
}



@OptIn(DelicateApi::class)
@Composable
fun RenderMarkdown(
    editText: String,
    fontWeightValue:  FontWeight,
    fontFamilyValue: String = ConstantsObject.FONT_FAMILY,
    textColor: CSSColorValue,
    fontSize: CSSSizeValue<CSSUnit.px>
) {



    val output = remember { mutableStateOf("") }


    LaunchedEffect(editText) {
        // Wait briefly to ensure Showdown is loaded
       // delay(1000)




        // Create an options object dynamically
        val options = js("{}")
        options.simpleLineBreaks = true // (false) enable multiple line breaks
        options.strikethrough = true
        options.emoji = true
        options.tasklists = true
        options.ghCodeBlocks = true
        options.simplifiedAutoLink = true
        options.underline = true
        options.ellipsis = true

        //options.literalMidLists = true  // Prevents merging lines inside lists
        options.smoothPreview = true
        options.parseBlockquotes = true    // Fix blockquotes

        options.openLinksInNewWindow = true
        options.noHeaderId = true  //[default false] Disable the automatic generation of header ids. Setting to true overrides prefixHeaderId
        options.tables = true
        options.tablesHeaderId = false // If enabled adds an id property to table headers tags
        // options.ghCompatibleHeaderId = true // Helps with GitHub-style markdown
        options.encodeEmails = false
        options.parseImgDimension = true

        options.ghMentions = true
        //By default, mentions link to https://github.com/{username}.
        // However, you can customize this behavior using ghMentionsLink.
        options.ghMentionsLink = "http://mysite.com/{u}/profile"

        // options.requireSpaceBeforeHeadingText = false // Allows headers without space after #

        //options.literalMidLists = true  // Prevents wrapping list item






        val converter = Showdown.Converter(options = options)

        output.value = converter.makeHtml(editText)  //Convert user input





    }


    Column(
        Modifier
            .transition(
                Transition.of(
                    property = TransitionProperty.All,
                    duration = 500.ms,
                    timingFunction = null,
                    delay = null
                )
                )
    ) {

        HtmlRenderer(
            html = output.value,
            textColor = textColor,
            fontWeightValue = fontWeightValue,
            fontFamilyValue = fontFamilyValue,
            fontSize = fontSize
        )


    }





}







@OptIn(DelicateApi::class)
@Composable
fun HtmlRenderer(
    html: String,
    textColor: CSSColorValue,
    fontWeightValue: FontWeight,
    fontFamilyValue: String,
    fontSize: CSSSizeValue<CSSUnit.px>
) {


    var element by remember { mutableStateOf<HTMLElement?>(null) }


    val breakpoint = rememberBreakpoint()


    Div(
        attrs = showdownStyle.toModifier()
            .whiteSpace(WhiteSpace.Normal)
            //.wordBreak(WordBreak.KeepAll)
            //.fillMaxWidth()
            //.lineHeight(1)
            .fontWeight(fontWeightValue)
            .fontSize(
                fontSize
            )
            .color(textColor)
            // .overflow(Overflow.Hidden)
            //.wordBreak(WordBreak.BreakAll) // 👈 this is the fix
            .overflowWrap(OverflowWrap.BreakWord)
            .fontFamily(fontFamilyValue, ConstantsObject.FALL_BACK_FONT)
            .styleModifier {
                property("margin", "0")  // Remove default margins
                property("padding", "0") // Remove default padding
            }
            //.fontFamily("Roboto", "sans-serif")
            .toAttrs(),
        content = {


            DisposableEffect(Unit) {

                element = scopeElement

                onDispose {
                    element?.innerHTML = ""
                }
            }


            LaunchedEffect(html) {


                if (element != null) {

                    val el = element!!
                    el.innerHTML = html


                    // Apply styles to all paragraphs to remove extra spacing
                    el.querySelectorAll("p").asList().forEach { node ->
                        (node as? HTMLElement)?.style?.apply {
                            marginBottom = "0"  // Remove bottom margin
                            marginTop = "0"     // Remove top margin
                            paddingBottom = "0" // Remove bottom padding
                            paddingTop = "0"    // Remove top padding
                            lineHeight = "1.5"  // Consistent line height
                        }
                    }


                    // CENTER HEADINGS
                    val headingTags = listOf("h1", "h2", "h3", "h4", "h5", "h6")


                    headingTags.forEach { tag ->
                        el.querySelectorAll(tag).asList().forEach { node ->
                            (node as? HTMLElement)?.style?.apply {
                                when (tag) {
                                    "h1" -> {
                                        textAlign = "center"

                                    }
                                    "h2" -> {
                                        textAlign = "center"
                                    }
                                    "h3" -> {
                                        textAlign = "center"
                                    }
                                    "h4" ->{
                                        textAlign = "start"
                                    }
                                    "h5" -> {
                                        textAlign = "start"
                                    }
                                    "h6" -> {
                                        textAlign = "start"
                                    }
                                    else -> {
                                        textAlign = "center"
                                    }
                                }

                               // textAlign = "center"
                                wordBreak = "break-word"
                                overflowWrap = "break-word"
                                lineHeight = "1.2"
                                fontFamily = "Roboto, sans-serif"
                                fontWeight = FontWeight.ExtraBold.toString()

                                val leftAndRightMargin = if (breakpoint <= Breakpoint.ZERO) "10px" else
                                    if (breakpoint <= Breakpoint.SM) "15px" else "0px"

                                val topAndBottomMargin = if (breakpoint <= Breakpoint.ZERO) "5px" else "8px"


                                marginLeft = leftAndRightMargin
                                marginRight=  leftAndRightMargin

                                marginTop=  topAndBottomMargin
                                marginBottom = topAndBottomMargin

                                color = textColor.toString()
                            }


                        }
                    }


                    // BOLD TEXT
                    el.querySelectorAll("strong, b").asList().forEach { node ->
                        (node as? HTMLElement)?.style?.apply {
                            wordBreak = "break-word"
                            overflowWrap = "break-word"
                            lineHeight = "1.5"
                        }
                    }


                    // ITALIC TEXT
                    // el.querySelectorAll("em, i").asList().forEach { node ->
                    el.querySelectorAll(".italic, .emphasis, i, em").asList().forEach {  node ->
                        (node as? HTMLElement)?.style?.apply {
                            wordBreak = "break-word"
                            overflowWrap = "break-word"
                            lineHeight = "1.5"
                        }
                    }


                    // UNORDERED & ORDERED LISTS
                    el.querySelectorAll("ul, ol").asList().forEach { listNode ->

                        val list = listNode as? HTMLElement ?: return@forEach
                        list.style.apply {
                            lineHeight = "1.5"

                        }

                    }




                    // Handle spoiler elements
                    val spoilers = el.querySelectorAll(".spoiler").asList()
                    spoilers.forEach { insertBlurEffect(it as HTMLElement) }





                    //  blockquote
                    fun replaceTags(line: String): String {
                        return when {
                            line.trim().startsWith("[error]") -> line.replaceFirst("[error]", "🚨 Error")
                            line.trim().startsWith("[warning]") -> line.replaceFirst("[warning]", "⚠️ Warning")
                            line.trim().startsWith("[success]") -> line.replaceFirst("[success]", "✅ Success")
                            line.trim().startsWith("[info]") -> line.replaceFirst("[info]", "ℹ️ Info")
                            else -> line
                        }
                    }


                    fun processBlockquote(blockquote: HTMLElement, nestingLevel: Int = 0) {

                        val paragraphs = blockquote.querySelectorAll(":scope > p").asList()

                        paragraphs.forEach { p ->
                            val pElement = p as HTMLElement
                            val content = pElement.textContent ?: ""
                            val processedLines = content
                                .split("\n")
                                .map(::replaceTags)

                            // Preserve multiline with <br>
                            pElement.innerHTML = processedLines.joinToString("<br>")
                        }

                        // Style based on first line
                        val firstLine = paragraphs.firstOrNull()
                            ?.textContent
                            ?.split("\n")
                            ?.firstOrNull()
                            ?.trim() ?: ""



                        when {
                            firstLine.startsWith("🚨 Error") -> applyBlockquoteStyle(
                                blockquote,
                                nestingLevel,
                                "error"
                            )

                            firstLine.startsWith("⚠️ Warning") -> applyBlockquoteStyle(
                                blockquote,
                                nestingLevel,
                                "warning"
                            )

                            firstLine.startsWith("✅ Success") -> applyBlockquoteStyle(
                                blockquote,
                                nestingLevel,
                                "success"
                            )

                            firstLine.startsWith("ℹ️ Info") -> applyBlockquoteStyle(
                                blockquote,
                                nestingLevel,
                                "info"
                            )

                            else -> applyBlockquoteStyle(blockquote, nestingLevel, "default")
                        }

                        // Recursively handle nested blockquotes
                        val nestedBlockquotes = blockquote.querySelectorAll(":scope > blockquote").asList()
                        nestedBlockquotes.forEach { nested ->
                            processBlockquote(nested as HTMLElement, nestingLevel + 1)
                        }
                    }

                    // Start with top-level blockquotes
                    val topLevelBlockquotes = element!!.querySelectorAll("blockquote").asList()
                    topLevelBlockquotes.forEach {
                        processBlockquote(it as HTMLElement)
                    }




                    // TABLES
                    el.querySelectorAll("table").asList().forEach { tableNode ->

                        val table = tableNode as? HTMLElement ?: return@forEach

                        val tableBorderColor = textColor.toString()// << set your custom table line color here

                        // Create a scrollable wrapper div
                        val scrollContainer = document.createElement("div") as HTMLElement
                        scrollContainer.style.apply {
                            overflowX = "auto"       // <-- Make the container scroll horizontally
                            width = "100%"           // <-- Container fills available width

                        }

                        table.parentNode?.replaceChild(scrollContainer, table)
                        scrollContainer.appendChild(table)

                        // Style the table
                        table.style.apply {
                            minWidth = "70px"       // <-- Force table wider than screen
                            borderCollapse = "collapse"

                            //this will center the table
                            marginLeft = "auto"
                            marginRight = "auto"
                        }

                        // Style headers
                        table.querySelectorAll("th").asList().forEach { header ->
                            (header as? HTMLElement)?.style?.apply {

                                val leftAmdRightPadding = if (breakpoint <= Breakpoint.ZERO) "10px" else
                                    if (breakpoint <= Breakpoint.SM) "12px" else
                                        if (breakpoint <= Breakpoint.MD) "13px" else
                                            if (breakpoint <= Breakpoint.LG) "14px" else "15px"

                                val topAmdBottomPadding = if (breakpoint <= Breakpoint.ZERO) "6px" else
                                    if (breakpoint <= Breakpoint.SM) "8px" else
                                        if (breakpoint <= Breakpoint.MD) "10px" else
                                            if (breakpoint <= Breakpoint.LG) "12px" else "14px"

                                paddingLeft = leftAmdRightPadding
                                paddingRight = leftAmdRightPadding
                                paddingTop = topAmdBottomPadding
                                paddingBottom = topAmdBottomPadding

                                backgroundColor = ThemeByKizito.ORANGE_COLOR.rgb.toString()
                                border = "0.7px solid $tableBorderColor"
                                //  fontSize = FontSize.Large.toString()
                                fontWeight = FontWeight.Bold.toString()
                                // maxWidth = "300px"

                            }
                        }

                        // Style cells
                        table.querySelectorAll("td").asList().forEach { cell ->
                            (cell as? HTMLElement)?.style?.apply {
                                padding = "5px"
                                //  wordBreak = "break-word"
                                overflowWrap = "break-word"
                                border = "0.7px solid $tableBorderColor"
                                //fontSize = FontSize.Medium.toString()
                                //fontWeight = FontWeight.Normal.toString()
                                // maxWidth = "400px"

                            }
                        }



                        // Apply zebra striping
                        table.querySelectorAll("tr").asList().forEachIndexed { index, row ->
                            (row as? HTMLElement)?.style?.apply {
                                backgroundColor = if (index % 2 == 0) "white" else "#EFEFEF"
                            }
                        }


                    }





                }


            }


        }
    )
}




// Function to apply blur effect to spoilers
private fun insertBlurEffect(spoilerElement: HTMLElement) {
    // Apply initial blur to the spoiler element
    spoilerElement.style.filter = "blur(5px)"  // Adjust the value of the blur to your preference

    // Add hover effect to remove the blur
    spoilerElement.addEventListener("mouseover", {
        spoilerElement.style.filter = "none"  // Remove blur on hover
    })

    spoilerElement.addEventListener("mouseout", {
        spoilerElement.style.filter = "blur(5px)"  // Reapply blur when mouse leaves
    })
}





private fun applyBlockquoteStyle(
    element: HTMLElement,
    nestingLevel: Int,
    type: String
) {
    val (baseR, baseG, baseB) = when (type) {
        "error" -> Triple(211, 47, 47)
        "warning" -> Triple(255, 152, 0)
        "success" -> Triple(46, 125, 50)
        "info" -> Triple(2, 136, 209)
        else -> Triple(85, 102, 140)
    }

    val bgColor = when (type) {
        "error" -> "rgb(${255 - (nestingLevel * 10)}, ${235 - (nestingLevel * 10)}, ${233 - (nestingLevel * 10)})"
        "warning" -> "rgb(${255 - (nestingLevel * 10)}, ${243 - (nestingLevel * 10)}, ${205 - (nestingLevel * 10)})"
        "success" -> "rgb(${223 - (nestingLevel * 10)}, ${240 - (nestingLevel * 10)}, ${216 - (nestingLevel * 10)})"
        "info" -> "rgb(${227 - (nestingLevel * 10)}, ${242 - (nestingLevel * 10)}, ${253 - (nestingLevel * 10)})"
        else -> "rgb(${48 + (nestingLevel * 10)}, ${50 + (nestingLevel * 10)}, ${54 + (nestingLevel * 10)})"
    }

    with(element.style) {
        fontFamily = "Roboto, sans-serif"
        setProperty("background-color", bgColor)
        setProperty("border-left", "4px solid rgb($baseR, $baseG, $baseB)")
        setProperty("padding", "10px")
        // setProperty("margin", "${10 - nestingLevel}px ${20 - nestingLevel}px")
        setProperty("color", when (type) {
            "error" -> "rgb(${183 - (nestingLevel * 10)}, ${28 - (nestingLevel * 2)}, ${28 - (nestingLevel * 2)})"
            "warning" -> "rgb(${230 - (nestingLevel * 10)}, ${81 - (nestingLevel * 2)}, 0)"
            "success" -> "rgb(${27 - (nestingLevel * 2)}, ${94 - (nestingLevel * 5)}, ${32 - (nestingLevel * 2)})"
            "info" -> "rgb(${1 - (nestingLevel * 0.5).toInt()}, ${87 - (nestingLevel * 5)}, ${155 - (nestingLevel * 5)})"
            else -> "rgb(${188 + (nestingLevel * 2)}, ${190 + (nestingLevel * 2)}, ${195 + (nestingLevel * 2)})"
        })
        // setProperty("max-width", "${60 + (nestingLevel * 5)}%")
        setProperty("width", "${95 - (nestingLevel * 5)}%")
        setProperty("margin", "0")
        // setProperty("box-sizing", "border-box")
        //setProperty("align-items", "center")
        // setProperty("align-self", "center")
        setProperty("place-self", "center")
       // setProperty("font-style", "italic")  // This makes the text italic
        setProperty("line-height", "1.5")  // Added line height here

    }
}






