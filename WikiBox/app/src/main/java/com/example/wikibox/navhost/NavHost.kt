package com.example.wikibox.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wikibox.tipper.TipperFragmentScreen

@Composable
fun WikiNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.TipperScreen.route // TODO, update to home/overview screen
    ) {
        composable(route = Screen.TipperScreen.route) {
            TipperFragmentScreen()
        }
    }
}

//private fun NavHostController.navigateToSingleAccount(accountType: String) {
//    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
//}

//fun NavHostController.navigateSingleTopTo(route: String) =
//    this.navigate(route) { launchSingleTop = true }
