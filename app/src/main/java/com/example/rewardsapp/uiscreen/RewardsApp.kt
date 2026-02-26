package com.example.rewardsapp.uiscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun RewardsApp(
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val loggedIn by authViewModel.isLoggedIn.collectAsState()

    if (loggedIn) {
        MainScreen()
    } else {
        LoginScreen()
    }
}