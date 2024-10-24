package app.glucostats.storage.domain.repository

/**
 * Repository interface for managing access and refresh tokens.
 */
interface TokenRepository {

    /**
     * Saves the provided access token.
     *
     * @param token The access token to be saved.
     */
    fun saveAccessToken(token: String)

    /**
     * Retrieves the saved access token.
     *
     * @return The saved access token, or null if no token is saved.
     */
    fun getAccessToken(): String?

    /**
     * Saves the provided refresh token.
     *
     * @param token The refresh token to be saved.
     */
    fun saveRefreshToken(token: String)

    /**
     * Retrieves the saved refresh token.
     *
     * @return The saved refresh token, or null if no token is saved.
     */
    fun getRefreshToken(): String?

    fun saveTokenType(tokenType: String)

    fun getTokenType(): String?

    fun saveExpiresIn(expiresIn: Int)

    fun getExpiresIn(): Int?

    fun getTokenSaveTime(): Long? // Timestamp of when the token was saved

    fun saveTokenSaveTime(time: Long)
}