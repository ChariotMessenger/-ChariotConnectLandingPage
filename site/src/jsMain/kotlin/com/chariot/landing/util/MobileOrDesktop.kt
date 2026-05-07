package com.chariot.landing.util

import kotlinx.browser.window

fun isDesktop(): Boolean {
    val ua = window.navigator.userAgent.lowercase()
    return !(
            ua.contains("android") ||
                    ua.contains("iphone") ||
                    ua.contains("ipad") ||
                    ua.contains("mobile")
            )
}
