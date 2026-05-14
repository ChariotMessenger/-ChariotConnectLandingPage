import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.chariot.landing"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Umali")


            // Add Google Fonts preconnect and Manrope font
            head.add {
                link {
                    rel = "preconnect"
                    href = "https://fonts.googleapis.com"
                }
                link {
                    rel = "preconnect"
                    href = "https://fonts.gstatic.com"
                    attributes["crossorigin"] = "crossorigin"
                }
                link {
                    rel = "stylesheet"
                    href = "https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&display=swap"
                }
            }



            head.add {

                script {
                    src = "/showdown.js"
                }

            }


            head.add {
                script {
                    src = "/highlight.js"
                }

                link {
                    rel = "stylesheet"

                    href =   "/atom-one-dark.css"
                }

            }




        }
    }
}

kotlin {
    configAsKobwebApplication("landing", includeServer = true)

    sourceSets {
//        commonMain.dependencies {
//          // Add shared dependencies between JS and JVM here
//        }
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            implementation(project(":worker"))

            implementation(libs.kobwebx.markdown)

        }
        jvmMain.dependencies {
            compileOnly(libs.kobweb.api) // Provided by Kobweb backend at runtime
        }
    }
}
