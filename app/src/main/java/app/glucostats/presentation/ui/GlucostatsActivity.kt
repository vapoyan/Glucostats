package app.glucostats.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import app.glucostats.dexcom.BuildConfig
import app.glucostats.presentation.theme.GlucostatsTheme
import app.glucostats.presentation.viewmodel.GlucostatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GlucostatsActivity : ComponentActivity() {

    private val glucostatsViewModel: GlucostatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlucostatsTheme {
                Greeting(glucostatsViewModel)
            }
        }
    }
}

@Composable
fun Greeting(viewModel: GlucostatsViewModel) {
    val context = LocalContext.current
    val isAuthenticated by viewModel.isAuthenticatedFlow.collectAsState(initial = false)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (!isAuthenticated) {
            Button(onClick = {
                val clientId = BuildConfig.DEXCOM_CLIENT_ID
                val redirectUri = "https://www.glucostats.app"
                val authUrl = "https://sandbox-api.dexcom.com/v2/oauth2/login?client_id=$clientId&redirect_uri=$redirectUri&response_type=code&scope=offline_access"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(authUrl))
                context.startActivity(intent)
            }) {
                Text(text = "Connect Dexcom")
            }
        } else {
            Text(text = "You are already authenticated")
        }
    }
}