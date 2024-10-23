package app.glucostats.dexcom.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import app.glucostats.dexcom.presentation.viewmodel.DexcomViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity for handling Dexcom OAuth authentication and managing Dexcom-related operations.
 */
@AndroidEntryPoint
class DexcomActivity : ComponentActivity() {

    private val dexcomViewModel: DexcomViewModel by viewModels()

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntentData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntentData()
    }

    private fun handleIntentData() {
        val data: Uri? = intent?.data
        data?.let {
            val redirectUri = (it.scheme + "://" + it.host + it.path).removeSuffix("/")
            val code = it.getQueryParameter("code")
            if (code != null) {
                // Exchange authorization code for access token
                dexcomViewModel.authenticate(code, redirectUri)
            } else if (it.getQueryParameter("error") == "access_denied") {
                // TODO: Handle case where user denied access
            }
        }

        dexcomViewModel.authResult.observe(this) { result ->
            if (result.isSuccess) {
                val tokenResponse = result.getOrNull()
                // Use the access token for further API calls
                Log.d("DexcomActivity", "Access Token: ${tokenResponse?.accessToken}")
            } else {
                // Handle error
                Log.d("DexcomActivity", "Error")
            }
        }
    }
}