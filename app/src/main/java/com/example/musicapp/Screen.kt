package com.example.musicapp

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {
    sealed class DrawerScreen(
        val dTitle: String,
        val dRoute: String,
        @DrawableRes val icon: Int
    ) : Screen(dTitle, dRoute) {
        object Account : DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_account_box_24
        )
        object AddAccount : DrawerScreen(
            "AddAccount",
            "add_account",
            R.drawable.baseline_person_add_24
        )
        object Subscribe : DrawerScreen(
            "Subscribe",
            "subscribe",
            R.drawable.baseline_subscriptions_24
        )
    }
}

val drawerInScreen:List<Screen.DrawerScreen> = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subscribe
)