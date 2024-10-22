package app.glucostats

import android.content.Intent
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
import app.glucostats.dexcom.api.DexcomApi
import app.glucostats.ui.theme.GlucostatsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GlucostatsActivity : ComponentActivity() {

    @Inject
    lateinit var dexcomApi: DexcomApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlucostatsTheme {
                Greeting(dexcomApi)
            }
        }
    }
}

@Composable
fun Greeting(dexcomApi: DexcomApi) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, dexcomApi.createDexcomLoginUrl())
            context.startActivity(intent)
        }) {
            Text(text = "Click Me")
        }
    }
}