package app.glucostats

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import app.glucostats.ui.theme.GlucostatsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GlucostatsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlucostatsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.data?.let { uri ->
            // Extract the URL from the intent and handle it as needed
            val path = uri.path
            // Do something with the path (e.g., navigate to a specific screen)
            Log.d("DeepLink", "Deep link URL: $uri")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = {
            val clientId = "A6MgXWzJM7knvVPpMBos3vaANKuNiOMu"
            val redirectUri = "https://www.glucostats.app"
            val responseType = "code"
            val scope = "offline_access"
            val state = "random_state_value"
            val dexcomLoginUrl = "https://sandbox-api.dexcom.com/v2/oauth2/login" +
                    "?client_id=$clientId" +
                    "&redirect_uri=$redirectUri" +
                    "&response_type=$responseType" +
                    "&scope=$scope" +
                    "&state=$state"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(dexcomLoginUrl))
            context.startActivity(intent)
        }) {
            Text(text = "Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GlucostatsTheme {
        Greeting("Android")
    }
}