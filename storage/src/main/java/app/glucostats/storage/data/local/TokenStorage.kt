package app.glucostats.storage.data.local

/**
 * Storage class for managing access tokens and their metadata.
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
     * Saves the provided token type.
     *
     * @param tokenType The token type to be saved.
     */
    fun saveTokenType(tokenType: String) {
        preferencesManager.saveString("token_type", tokenType)
    }

    /**
     * Retrieves the saved token type.
     *
     * @return The saved token type, or null if no token type is saved.
     */
    fun getTokenType(): String? {
        return preferencesManager.getString("token_type")
    }

    /**
     * Saves the expiration time of the access token.
     *
     * @param expiresIn The expiration time in seconds to be saved.
     */
    fun saveExpiresIn(expiresIn: Int) {
        preferencesManager.saveString("expires_in", expiresIn.toString())
    }

    /**
     * Retrieves the saved expiration time of the access token.
     *
     * @return The saved expiration time in seconds, or null if no expiration time is saved.
     */
    fun getExpiresIn(): Int? {
        return preferencesManager.getString("expires_in")?.toInt()
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
