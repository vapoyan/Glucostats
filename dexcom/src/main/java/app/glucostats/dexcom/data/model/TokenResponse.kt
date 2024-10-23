package app.glucostats.dexcom.data.model

/**
 * Represents the response for an authentication token.
 * @property accessToken The token to access Dexcom APIs.
 * @property tokenType The type of the token.
 * @property expiresIn The duration in seconds for which the token is valid.
 */
data class TokenResponse(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int
)