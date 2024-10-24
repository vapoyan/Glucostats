package app.glucostats.storage.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Manager for handling encrypted shared preferences operations.
 *
 * @param context The context used to initialize encrypted shared preferences.
 */
class PreferencesManager(context: Context) {

    // Master key for encrypting the shared preferences
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    // Encrypted shared preferences instance
    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "glucostats_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Saves a string value in the shared preferences.
     *
     * @param key The key for the value to be saved.
     * @param value The string value to be saved.
     */
    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    /**
     * Retrieves a string value from the shared preferences.
     *
     * @param key The key for the value to be retrieved.
     * @return The string value associated with the key, or null if not found.
     */
    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    /**
     * Saves a boolean value in the shared preferences.
     *
     * @param key The key for the value to be saved.
     * @param value The boolean value to be saved.
     */
    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    /**
     * Retrieves a boolean value from the shared preferences.
     *
     * @param key The key for the value to be retrieved.
     * @return The boolean value associated with the key, or false if not found.
     */
    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}
