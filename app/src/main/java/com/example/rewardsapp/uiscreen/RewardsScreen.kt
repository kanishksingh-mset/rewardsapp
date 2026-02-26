package com.example.rewardsapp.uiscreen

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.crashlytics.FirebaseCrashlytics

@Composable
fun RewardsScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Rewards Screen")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            FirebaseCrashlytics.getInstance()
                .log("Rewards button clicked")
        }) {
            Text(text = "Log Event")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            throw RuntimeException("Test Crash")
        }) {
            Text(text = "Force Crash")
        }
    }
}
