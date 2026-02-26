package com.example.rewardsapp

import android.app.Application
import com.braze.Braze
import com.braze.configuration.BrazeConfig
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics

class RewardsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        FirebaseApp.initializeApp(this)
        
        FirebaseCrashlytics.getInstance()

        val brazeConfig = BrazeConfig.Builder()
            .setApiKey("DUMMY_API_KEY_123456")
            .build()

        Braze.configure(this, brazeConfig)
    }
}
