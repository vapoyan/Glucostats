package app.glucostats

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import app.glucostats.dexcom.BuildConfig
import app.glucostats.ui.theme.GlucostatsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GlucostatsActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlucostatsTheme {
                Greeting()
            }
        }
    }


}

@Composable
fun Greeting() {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = {
            val clientId = BuildConfig.DEXCOM_CLIENT_ID
            val redirectUri = "https://www.glucostats.app"
            val authUrl = "https://sandbox-api.dexcom.com/v2/oauth2/login?client_id=$clientId&redirect_uri=$redirectUri&response_type=code&scope=offline_access"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(authUrl))
            context.startActivity(intent)
        }) {
            Text(text = "Connect Dexcom")
        }
    }
}