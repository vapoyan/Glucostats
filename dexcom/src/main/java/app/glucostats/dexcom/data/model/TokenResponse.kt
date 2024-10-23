package app.glucostats.dexcom.data.model

import com.google.gson.annotations.SerializedName

/**
 * Represents the response for an authentication token.
 * @property accessToken The token to access Dexcom APIs.
 * @property tokenType The type of the token.
 * @property expiresIn The duration in seconds for which the token is valid.
 */
data class TokenResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int
)