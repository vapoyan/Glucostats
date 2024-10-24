package app.glucostats.storage.data.repository

import app.glucostats.storage.data.local.TokenStorage
import app.glucostats.storage.domain.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenStorage: TokenStorage
) : TokenRepository {

    override fun saveAccessToken(token: String) {
        tokenStorage.saveAccessToken(token)
    }

    override fun getAccessToken(): String? {
        return tokenStorage.getAccessToken()
    }

    override fun saveRefreshToken(token: String) {
        tokenStorage.saveRefreshToken(token)
    }

    override fun getRefreshToken(): String? {
        return tokenStorage.getRefreshToken()
    }
}