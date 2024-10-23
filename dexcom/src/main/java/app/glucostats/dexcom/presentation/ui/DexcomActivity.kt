package app.glucostats.dexcom.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
            val code = it.getQueryParameter("code")
            if (code != null) {
                // Exchange authorization code for access token
                dexcomViewModel.authenticate(code)
            }
        }

        dexcomViewModel.authResult.observe(this) { result ->
            if (result.isSuccess) {
                val tokenResponse = result.getOrNull()
                // Use the access token for further API calls
            } else {
                // Handle error
            }
        }
    }
}