package com.example.rewardsapp.uiscreen

sealed class BottomNavItem(val route: String, val label: String) {
    object Home : BottomNavItem("home", "Home")
    object Rewards : BottomNavItem("rewards", "Rewards")
    object Scan : BottomNavItem("scan", "Scan")
    object Profile : BottomNavItem("profile", "Profile")
}