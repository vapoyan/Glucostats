package app.glucostats.dexcom.data.api

import android.net.Uri

interface Dexcom {

    fun createDexcomLoginUrl(): Uri
}