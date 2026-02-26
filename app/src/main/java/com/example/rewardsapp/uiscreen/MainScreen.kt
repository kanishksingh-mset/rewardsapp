package com.example.rewardsapp.uiscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Rewards,
                    BottomNavItem.Scan,
                    BottomNavItem.Profile
                ).forEach { item ->

                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            navController.navigate(item.route)
                        },
                        icon = { Icon(Icons.Default.Home, null) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {

            composable("home") { HomeScreen() }
            composable("rewards") { RewardsScreen() }
            composable("scan") { ScanScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun CenterText(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 20.sp)
    }
}