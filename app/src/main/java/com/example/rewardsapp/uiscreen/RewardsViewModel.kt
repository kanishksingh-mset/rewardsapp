package com.example.rewardsapp.uiscreen

import androidx.lifecycle.ViewModel
import com.example.rewardsapp.core.BrazeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor(
    private val brazeManager: BrazeManager
) : ViewModel() {

    fun logScreenOpened() {
        brazeManager.logEvent("rewards_screen_opened")
    }

    fun logButtonClicked() {
        brazeManager.logEvent("rewards_button_clicked")
    }
}