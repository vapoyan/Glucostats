package app.glucostats.dexcom.api

import android.net.Uri

interface Dexcom {

    fun createDexcomLoginUrl(): Uri
}