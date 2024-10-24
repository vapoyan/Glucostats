package app.glucostats.dexcom.domain.usecase

import app.glucostats.dexcom.BuildConfig
import app.glucostats.dexcom.data.api.Dexcom
import app.glucostats.dexcom.data.model.TokenResponse
import app.glucostats.network.safeApiCall
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val dexcom: Dexcom
) {
    suspend fun execute(refreshToken: String): Result<TokenResponse> {
        return safeApiCall {
            dexcom.refreshAccessToken(
                clientId = BuildConfig.DEXCOM_CLIENT_ID,
                clientSecret = BuildConfig.DEXCOM_CLIENT_SECRET,
                refreshToken = refreshToken,
            )
        }
    }
}