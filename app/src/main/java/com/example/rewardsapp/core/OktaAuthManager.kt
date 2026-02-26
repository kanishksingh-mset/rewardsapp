package com.example.rewardsapp.core

import android.app.Activity
import android.content.Context
import com.example.rewardsapp.R
import com.okta.oidc.AuthorizationStatus
import com.okta.oidc.OIDCConfig
import com.okta.oidc.Okta
import com.okta.oidc.ResultCallback
import com.okta.oidc.clients.web.WebAuthClient
import com.okta.oidc.util.AuthorizationException
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OktaAuthManager @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    private val webAuthClient: WebAuthClient

    init {
        val config = OIDCConfig.Builder()
            .withJsonFile(context, R.raw.okta_config)
            .create()

        webAuthClient = Okta.WebAuthBuilder()
            .withConfig(config)
            .withContext(context)
            .create()
    }

    fun login(activity: Activity, callback: (Boolean) -> Unit) {
        // Register the callback for the result
        webAuthClient.registerCallback(object : ResultCallback<AuthorizationStatus, AuthorizationException> {
            override fun onSuccess(status: AuthorizationStatus) {
                if (status == AuthorizationStatus.AUTHORIZED) {
                    callback(true)
                }
            }

            override fun onCancel() {
                callback(false)
            }

            override fun onError(msg: String?, exception: AuthorizationException?) {
                callback(false)
            }
        }, activity)

        // Start the sign-in process with null payload
        webAuthClient.signIn(activity, null)
    }
}
