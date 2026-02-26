package com.example.rewardsapp.uiscreen

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.rewardsapp.core.OktaAuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val oktaAuthManager: OktaAuthManager
) : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun login(activity: Activity) {
        oktaAuthManager.login(activity) {
            _isLoggedIn.value = it
        }
    }
}