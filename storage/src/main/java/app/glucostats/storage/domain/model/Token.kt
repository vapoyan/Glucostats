package app.glucostats.storage.domain.model

/**
 * Data class representing an access and refresh token pair.
 *
 * @property accessToken The access token used for API authentication.
 * @property refreshToken The refresh token used to obtain a new access
 * token when the current one expires.
 */
data class Token(
    val accessToken: String,
    val refreshToken: String
)