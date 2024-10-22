package app.glucostats.dexcom.api

import android.net.Uri

interface DexcomApi {

    fun createDexcomLoginUrl(): Uri
}