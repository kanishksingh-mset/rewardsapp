package com.example.rewardsapp.core

import android.content.Context
import android.util.Log
import com.braze.Braze.Companion.getInstance
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class BrazeManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun logEvent(event: String) {
        try {
            getInstance(context).logCustomEvent(event)
        } catch (e: Exception) {
            Log.e("Braze", "Braze not configured properly")
        }
    }
}