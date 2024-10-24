package app.glucostats.storage.data.local

/**
 * Storage class for managing access and refresh tokens.
 *
 * @property preferencesManager The preferences manager used for saving and retrieving token values.
 */
class TokenStorage(private val preferencesManager: PreferencesManager) {

    /**
     * Saves the provided access token.
     *
     * @param token The access token to be saved.
     */
    fun saveAccessToken(token: String) {
        preferencesManager.saveString("access_token", token)
    }

    /**
     * Retrieves the saved access token.
     *
     * @return The saved access token, or null if no token is saved.
     */
    fun getAccessToken(): String? {
        return preferencesManager.getString("access_token")
    }

    /**
     * Saves the provided refresh token.
     *
     * @param token The refresh token to be saved.
     */
    fun saveRefreshToken(token: String) {
        preferencesManager.saveString("refresh_token", token)
    }

    /**
     * Retrieves the saved refresh token.
     *
     * @return The saved refresh token, or null if no token is saved.
     */
    fun getRefreshToken(): String? {
        return preferencesManager.getString("refresh_token")
    }
}
