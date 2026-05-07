package com.zitos.web.binkes.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.FaRotateRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zitos.web.binkes.components.ContentCodeLayout
import com.zitos.web.binkes.components.ImageLayout
import com.zitos.web.binkes.components.VideoPlayer
import com.zitos.web.binkes.components.YouTubePlayer
import com.zitos.web.binkes.dialogs.ExpandedImageDialog
import com.zitos.web.binkes.models.ThemeByKizito
import com.zitos.web.binkes.models.WebCardContentData
import com.zitos.web.binkes.styles.showdownStyle
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.*
import kotlin.js.Date


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
    itemClickedData: WebCardContentData
) {


    val breakpoint = rememberBreakpoint()


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
            .fillMaxWidth(if (breakpoint <= Breakpoint.ZERO) 99.percent else
                if (breakpoint <= Breakpoint.SM) 97.percent else
                    if (breakpoint <= Breakpoint.MD) 90.percent else
                        if (breakpoint <= Breakpoint.LG) 75.percent else 55.percent)

        //.fillMaxWidth(if (breakpoint <= Breakpoint.SM) 70.percent else if (breakpoint <= Breakpoint.MD) 60.percent else 50.percent)
        .padding(top = 0.px,8.px)
            .transition(
                Transition.of(
                    property = TransitionProperty.All,
                    duration = 500.ms,
                    timingFunction = null,
                    delay = null
                )
                )
        //.backgroundColor(Color.blue)
        //.overflow(Overflow.Hidden)
    ) {

        HtmlRenderer(
            html = output.value,
            itemClickedData = itemClickedData
            )


    }





}







@OptIn(DelicateApi::class)
@Composable
fun HtmlRenderer(
    html: String,
    itemClickedData:WebCardContentData,
) {


    var element by remember { mutableStateOf<HTMLElement?>(null) }


    val breakpoint = rememberBreakpoint()

    val scope  =  rememberCoroutineScope()

    var isImageExpanded by remember { mutableStateOf(false) }
    var imageAndVideoExpandedLink by remember { mutableStateOf("") }



// Manually write <title> and <meta> as raw HTML
    /*
    SideEffect {
        val titleElement = document.createElement("title")
        titleElement.textContent = topic
        document.head?.appendChild(titleElement)

        val metaDescription = document.createElement("meta")
        metaDescription.setAttribute("name", "description")
        metaDescription.setAttribute("content", description)
        document.head?.appendChild(metaDescription)
    }

     */




    SideEffect {
        val doc: Document = document

        // <title>
        val titleElement = doc.querySelector("title") ?: doc.createElement("title").also {
            doc.head?.appendChild(it)
        }
        titleElement.textContent = itemClickedData.contentTopic

        // <meta name="description">
        val metaDescription = doc.querySelector("meta[name='description']") as? Element
            ?: doc.createElement("meta").also {
                it.setAttribute("name", "description")
                doc.head?.appendChild(it)
            }
        metaDescription.setAttribute("content", itemClickedData.contentDescription)

        // <meta name="keywords">
        val metaKeywords = doc.querySelector("meta[name='keywords']") as? Element
            ?: doc.createElement("meta").also {
                it.setAttribute("name", "keywords")
                doc.head?.appendChild(it)
            }
        metaKeywords.setAttribute("content", itemClickedData.contentSearchKeywords)

        // <meta property="og:image"> for social media preview thumbnails
        val ogImage = doc.querySelector("meta[property='og:image']") as? Element
            ?: doc.createElement("meta").also {
                it.setAttribute("property", "og:image")
                doc.head?.appendChild(it)
            }
        ogImage.setAttribute("content", itemClickedData.contentThumbnailUrl)

        // Structured Data (JSON-LD for breadcrumbs, FAQ, etc.)
        // Check if a Breadcrumb JSON-LD script already exists
        val existingJsonLd = doc.querySelectorAll("script[type='application/ld+json']")
            .asList()
            .firstOrNull { it.textContent?.contains("\"@type\": \"BreadcrumbList\"") == true }

        if (existingJsonLd == null) {
            val jsonLdScript = doc.createElement("script")
            jsonLdScript.setAttribute("type", "application/ld+json")
            jsonLdScript.textContent = """
        {
          "@context": "https://schema.org",
          "@type": "BreadcrumbList",
          "itemListElement": [
            {
              "@type": "ListItem",
              "position": 1,
              "name": "Home",
              "item": "https://zitoscode.com/"
            },
            {
              "@type": "ListItem",
              "position": 2,
              "name": "${itemClickedData.contentTopic}",
              "item": "https://zitoscode.com/post/${itemClickedData.documentID}"
            }
          ]
        }
    """.trimIndent()

            doc.head?.appendChild(jsonLdScript)
        }


    }





    if (isImageExpanded) {

        ExpandedImageDialog(
            breakpoint = breakpoint,
            imageUrl = imageAndVideoExpandedLink,
            onCancel = {
                isImageExpanded = false
                imageAndVideoExpandedLink = ""
            },
        )
    }




    Div(
        attrs = showdownStyle.toModifier()
            .whiteSpace(WhiteSpace.Normal)
            //.wordBreak(WordBreak.KeepAll)
            .fillMaxWidth()
            .lineHeight(1.5)
            .fontSize(
                if (breakpoint <= Breakpoint.ZERO) 13.5.px else
                if (breakpoint <= Breakpoint.SM) 16.px else
                    if (breakpoint <= Breakpoint.MD) 19.px else
                        if (breakpoint <= Breakpoint.LG) 19.5.px else 20.px
            )
            .color(ThemeByKizito.TextBlack.rgb)
            // .overflow(Overflow.Hidden)
            //.wordBreak(WordBreak.BreakAll) // 👈 this is the fix
            .overflowWrap(OverflowWrap.BreakWord)
            .fontFamily("Georgia", "serif") // ← This is the key change
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


                    // CENTER HEADINGS
                    val headingTags = listOf("h1", "h2", "h3", "h4", "h5", "h6")


                    headingTags.forEach { tag ->
                        el.querySelectorAll(tag).asList().forEach { node ->
                            /*
                            val heading = node as? HTMLElement ?: return@LaunchedEffect//@forEach

                            // Set center alignment
                            heading.style.textAlign = "center"

                            // Apply font size based on tag

                            heading.style.fontSize = when (tag) {
                                "h1" -> "2.5rem"
                                "h2" -> "2rem"
                                "h3" -> "1.75rem"
                                "h4" -> "1.5rem"
                                "h5" -> "1.25rem"
                                "h6" -> "1rem"
                                else -> "1rem"
                            }

                            heading.style.lineHeight = "1.2"
                            heading.style.fontFamily = "Roboto, sans-serif"
                            heading.style.fontFamily = FontWeight.ExtraBold.toString()


                             */


                            // Optional: Add spacing
                            //heading.style.marginTop = "1em"
                            // heading.style.marginBottom = "0.5em"


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

                                color = ThemeByKizito.TextBlue.rgb.toString()
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



                    // let's use a nuclear approach that guarantees the style will apply. We'll combine inline styles
                    // with dynamic HTML manipulation.
                    // Force-styling for ALL inline code blocks
                    // Inline code (code) → Prevents wrapping, keeps it in a single line
                    el.querySelectorAll("code:not(pre code)").asList().forEach { node ->
                        (node as? HTMLElement)?.style?.apply {
                            color = ThemeByKizito.TextBlack.rgb.toString() // 👈 Direct inline style
                            backgroundColor = "lightgray"
                            padding = "0 2px"
                            borderRadius = "4px"
                            fontFamily = "monospace"
                            whiteSpace = "nowrap"
                            // Debugging line (temporary):
                            // border = "1px solid red" // Verify this element is selected
                        }
                    }




                    // Handle spoiler elements
                    val spoilers = el.querySelectorAll(".spoiler").asList()
                    spoilers.forEach { insertBlurEffect(it as HTMLElement) }





                    val preBlocks = (element as? HTMLElement)?.querySelectorAll("pre")?.asList() ?: emptyList()

                    preBlocks.forEach { preBlock ->

                        (preBlock as? HTMLElement)?.style?.apply {
                            setProperty("max-width", "85%")
                            setProperty("max-height", "500px")
                            //  setProperty("background-color", "red")
                            setProperty("place-self", "center")
                            fontFamily = "monospace"
                            borderBottomLeftRadius = "8px"
                            borderBottomRightRadius = "8px"
                            // padding = "4px"
                        }


                        val codeElement =
                            (preBlock as? HTMLElement)?.querySelector("code") as? HTMLElement ?: return@forEach
                        val codeText = codeElement.textContent ?: ""


                        codeElement.style.apply {
                            setProperty("width", "100%")
                            setProperty("height", "100%")
                            // setProperty("background-color", "blue")
                            setProperty("scroll-behavior", "smooth")
                        }



                        //  Extract language properly
                        val language = codeElement.className
                            .split(" ")
                            .find { it.startsWith("language-") }
                            ?.removePrefix("language-")
                            ?: "Plain Text"


                        // highlight code
                        // HlJs.highlightElement(codeElement)





                        // Create a container div to replace the <pre> content
                        val containerId = "code-container-${preBlocks.indexOf(preBlock)}"
                        preBlock.innerHTML = "<div id='$containerId'></div>"

                        val container = document.getElementById(containerId)



                        if (container != null) {
                            renderComposable(container) {


                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center
                                    // verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ContentCodeLayout(
                                        modifier = Modifier,
                                        language = language,
                                        code = codeText,
                                        breakpoint = breakpoint
                                    )

                                }


                            }
                        }


                    }




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

                            firstLine.startsWith("[youtube]") -> {


                                val youTubeUrlList: List<String> = paragraphs.flatMap { p ->
                                    val pElement = p as HTMLElement
                                    val content = pElement.textContent ?: ""

                                    content.split("[youtube]")
                                        .mapNotNull { rawUrl ->
                                            val url = rawUrl.trim()
                                            if (url.isNotEmpty()) url else null
                                        }
                                }



                                // Remove ALL [youtube] lines from the DOM
                                paragraphs.forEach { p ->
                                    val text = (p as HTMLElement).textContent?.trim() ?: ""
                                    if (text.startsWith("[youtube]")) {
                                        p.remove()
                                    }
                                }


                                // Inject a new container after the text
                                val containerId = "youtube-container-${Date().getTime()}"
                                val youtubeDiv = document.createElement("div") as HTMLElement
                                youtubeDiv.id = containerId
                                youtubeDiv.style.marginTop = "12px"
                                blockquote.appendChild(youtubeDiv)




                                renderComposable(youtubeDiv) {

                                    val currentIndex = remember { mutableStateOf(0) }
                                    val currentVideo by remember { derivedStateOf { youTubeUrlList[currentIndex.value] } }

                                    var refresh by remember { mutableStateOf(true) }



                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.px),
                                        contentAlignment = Alignment.Center
                                    ) {

                                        FaRotateRight(
                                            modifier = Modifier
                                                .cursor(Cursor.Pointer)
                                                .onClick {
                                                    scope.launch {
                                                        refresh = false
                                                        delay(250)
                                                        refresh = true
                                                    }
                                                },
                                            size = IconSize.LG
                                        )
                                    }



                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {

                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(20.percent),
                                            horizontalArrangement = Arrangement.End
                                        ) {
                                            if (youTubeUrlList.size > 1) {
                                                if (currentIndex.value > 0) {

                                                    Box(
                                                        modifier = Modifier
                                                            .cursor(Cursor.Pointer)
                                                            .onClick {

                                                                if (currentIndex.value > 0) {
                                                                    currentIndex.value -= 1 // Move to the previous video
                                                                }

                                                            }
                                                    ) {
                                                        FaArrowLeft(
                                                            modifier = Modifier
                                                                .margin(all = 10.px), size = IconSize.XL
                                                        )
                                                    }

                                                }
                                            }

                                        }


                                        Row(
                                            modifier = Modifier
                                                // .fillMaxWidth(60.percent)
                                                .fillMaxWidth(if (breakpoint <= Breakpoint.SM) 80.percent else if (breakpoint <= Breakpoint.MD) 70.percent else 60.percent)
                                                .maxHeight(360.px)
                                                .margin(bottom = 8.px, top = 0.px, left = 10.px, right = 10.px)
                                                .overflow { x(Overflow.Hidden) },
                                            horizontalArrangement = Arrangement.Center
                                        ) {

                                            // refresh is jus for refresh just to hide abd show
                                            if (refresh) {

                                                YouTubePlayer(
                                                    modifier = Modifier,//.maxWidth(95.percent),
                                                    videoUrl = currentVideo
                                                )

                                            }else{

                                                // dommi it is not usefully only to keep the layout height and width
                                                YouTubePlayer(
                                                    modifier = Modifier,
                                                    videoUrl = ""
                                                )

                                            }

                                        }


                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(20.percent),
                                            horizontalArrangement = Arrangement.Start
                                        ) {
                                            if (youTubeUrlList.size > 1 && (currentIndex.value < youTubeUrlList.size - 1)) {

                                                Box(
                                                    modifier = Modifier
                                                        .cursor(Cursor.Pointer)
                                                        .onClick {
                                                            if (currentIndex.value < youTubeUrlList.size - 1) {
                                                                currentIndex.value += 1 // Move to the next video
                                                            }
                                                        }
                                                ) {
                                                    FaArrowRight(
                                                        modifier = Modifier
                                                            .margin(all = 10.px),
                                                        size = IconSize.XL
                                                    )
                                                }
                                            }
                                        }



                                    }


                                }

                            }

                            firstLine.startsWith("[video]") -> {


                                val videoUrlList: List<String> = paragraphs.flatMap { p ->
                                    val pElement = p as HTMLElement
                                    val content = pElement.textContent ?: ""

                                    content.split("[video]")
                                        .mapNotNull { rawUrl ->
                                            val url = rawUrl.trim()
                                            if (url.isNotEmpty()) url else null
                                        }
                                }



                                // Remove ALL [video] lines from the DOM
                                paragraphs.forEach { p ->
                                    val text = (p as HTMLElement).textContent?.trim() ?: ""
                                    if (text.startsWith("[video]")) {
                                        p.remove()
                                    }
                                }


                                // Inject a new container after the text
                                val containerId = "video-container-${Date().getTime()}"
                                val videoDiv = document.createElement("div") as HTMLElement
                                videoDiv.id = containerId

                                videoDiv.style.apply {
                                    display = "flex"               // Add this
                                    justifyContent = "center"      // Center children horizontally
                                    alignItems = "center"          // Center children vertically (optional)
                                    flexWrap = "wrap"              // Allow items to wrap
                                    width = "100%"
                                    marginTop = "12px"
                                }

                                blockquote.appendChild(videoDiv)




                                renderComposable(videoDiv) {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(if (breakpoint <= Breakpoint.SM) 80.percent else if (breakpoint <= Breakpoint.MD) 70.percent else 60.percent)
                                                .alignSelf(org.jetbrains.compose.web.css.AlignSelf.SafeCenter),
                                            contentAlignment = Alignment.Center
                                        ) {

                                            val listSize by remember { derivedStateOf { videoUrlList.size  } }

                                            SimpleGrid(
                                                numColumns = numColumns(
                                                    base = 1,
                                                    sm = if (listSize >= 2) 2 else 1,
                                                    lg = if (listSize >= 3) 3 else if (listSize >= 2) 2 else 1
                                                ),
                                                modifier = Modifier.alignContent(com.varabyte.kobweb.compose.css.AlignContent.Center)
                                            ) {

                                                videoUrlList.forEach { videoUrl ->


                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            //.display(DisplayStyle.Flex)
                                                            //.justifyContent(JustifyContent.Center)
                                                           // .alignItems(AlignItems.Center)

                                                            .display(DisplayStyle.Block)
                                                            .textAlign(TextAlign.Center)
                                                    ) {


                                                        VideoPlayer(
                                                            breakpoint = breakpoint,
                                                            videoUrl = videoUrl
                                                        )
                                                    }

                                                }


                                            }


                                        }

                                    }


                                }

                            }

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




                    // Find all image elements
                    val allImages = el.querySelectorAll("img").asList()

                    // Group consecutive images
                    val imageGroups = mutableListOf<List<HTMLImageElement>>()
                    val currentGroup = mutableListOf<HTMLImageElement>()

                    // Helper function to check if two nodes are siblings
                    fun areSiblings(a: Node, b: Node): Boolean {
                        return a.parentNode == b.parentNode
                    }

                    allImages.forEachIndexed { index, img ->
                        if (currentGroup.isEmpty()) {
                            // Start new group
                            currentGroup.add(img as HTMLImageElement)
                        } else {
                            val prevImg = currentGroup.last()
                            // Check if this image is consecutive to previous one
                            if (areSiblings(prevImg, img) &&
                                prevImg.nextSibling?.let { it == img || it.textContent.isNullOrBlank() } == true) {
                                currentGroup.add(img as HTMLImageElement)
                            } else {
                                // Finalize current group and start new one
                                imageGroups.add(currentGroup.toList())
                                currentGroup.clear()
                                currentGroup.add(img as HTMLImageElement)
                            }
                        }
                    }

                    // Add the last group if it exists
                    if (currentGroup.isNotEmpty()) {
                        imageGroups.add(currentGroup.toList())
                    }

                    // Process each image group
                    imageGroups.forEachIndexed { groupIndex, group ->

                        // Create a container div for this group
                        val container = document.createElement("div") as HTMLElement
                        container.id = "image-group-$groupIndex"

                        container.style.apply {
                            display = "flex"               // Add this
                            justifyContent = "center"      // Center children horizontally
                            alignItems = "center"          // Center children vertically (optional)
                            flexWrap = "wrap"              // Allow items to wrap
                            width = "100%"
                        }



                        // Insert container before the first image in the group
                        group.first().parentNode?.insertBefore(container, group.first())

                        // Remove original images from DOM
                        group.forEach { it.remove() }

                        // Render the image group
                        renderComposable(container) {



                            val listSize by remember { derivedStateOf { group.size } }


                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .margin(all = 5.px),
                                contentAlignment = Alignment.Center
                            ) {
                                SimpleGrid(
                                    numColumns = numColumns(
                                        base = 1,
                                        sm = if (listSize >= 2) 2 else 1,
                                        lg = if (listSize >= 3) 3 else if (listSize >= 2) 2 else 1
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    group.forEachIndexed { index, img ->

                                        val globalIndex = groupIndex * group.size + index

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .display(DisplayStyle.Flex)
                                                .justifyContent(JustifyContent.Center)
                                                .alignItems(AlignItems.Center)
                                        ) {

                                            ImageLayout(
                                                breakpoint = breakpoint,
                                                imageUrl = img.src,
                                                altId = img.alt.ifEmpty { "content img thumbnail $globalIndex" },
                                                onImageClicked = { src ->
                                                    isImageExpanded = true
                                                    imageAndVideoExpandedLink = src
                                                }
                                            )
                                        }

                                    }
                                }
                            }
                        }
                    }






                    // TABLES
                    el.querySelectorAll("table").asList().forEach { tableNode ->

                        val table = tableNode as? HTMLElement ?: return@forEach

                        val tableBorderColor = ThemeByKizito.Black.rgb.toString()// << set your custom table line color here

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

                                backgroundColor = ThemeByKizito.LightPersianOrange.rgb.toString()
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






