package com.example.wikibox.navhost

sealed class Screen(val route: String) {
    object TipperScreen : Screen("tipper")
}
