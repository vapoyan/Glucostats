package app.glucostats.dexcom.domain.usecase

import app.glucostats.dexcom.BuildConfig
import app.glucostats.dexcom.data.api.Dexcom
import app.glucostats.dexcom.data.model.TokenResponse
import app.glucostats.network.safeApiCall
import javax.inject.Inject

/**
 * Use case for authenticating with Dexcom using an authorization code.
 * @property dexcom The Dexcom API interface to perform the authentication.
 */
class AuthenticateUseCase @Inject constructor(private val dexcom: Dexcom) {
    /**
     * Executes the authentication process by exchanging the authorization code for an access token.
     * @param code The authorization code received from Dexcom.
     * @param redirectUri The redirect URI associated with the application.
     * @return A Result containing the TokenResponse or an error.
     */
    suspend fun execute(code: String, redirectUri: String): Result<TokenResponse> {
        return safeApiCall {
            dexcom.authenticate(
                clientId = BuildConfig.DEXCOM_CLIENT_ID,
                clientSecret = BuildConfig.DEXCOM_CLIENT_SECRET,
                code = code,
                redirectUri = redirectUri
            )
        }
    }
}