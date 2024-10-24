package app.glucostats.storage.domain.usecase

import app.glucostats.storage.domain.repository.TokenRepository
import javax.inject.Inject

/**
 * Use case for retrieving the saved access token.
 *
 * @property tokenRepository The repository used to manage token storage.
 */
class GetAccessTokenUseCase @Inject constructor(private val tokenRepository: TokenRepository) {
    /**
     * Executes the use case to retrieve the access token.
     *
     * @return The saved access token, or null if no token is saved.
     */
    fun execute(): String? {
        return tokenRepository.getAccessToken()
    }
}