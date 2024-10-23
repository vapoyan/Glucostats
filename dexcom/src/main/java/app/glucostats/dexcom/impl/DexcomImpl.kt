package app.glucostats.dexcom.impl

import android.net.Uri
import app.glucostats.dexcom.data.api.Dexcom

class DexcomImpl : Dexcom {

    override fun createDexcomLoginUrl(): Uri = Uri.parse(
        AUTH_URI +
                "?client_id=$CLIENT_ID" +
                "&redirect_uri=$REDIRECT_URI" +
                "&response_type=$RESPONSE_TYPE" +
                "&scope=$SCOPE" +
                "&state=$STATE"
    )

    companion object {
        private const val AUTH_URI = "https://sandbox-api.dexcom.com/v2/oauth2/login"
        private const val CLIENT_ID = "A6MgXWzJM7knvVPpMBos3vaANKuNiOMu"
        private const val REDIRECT_URI = "https://www.glucostats.app"
        private const val RESPONSE_TYPE = "code"
        private const val SCOPE = "offline_access"
        private const val STATE = "random_state_value"
    }
}