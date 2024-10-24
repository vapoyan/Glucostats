package app.glucostats.storage.domain.usecase

import app.glucostats.storage.domain.repository.TokenRepository
import javax.inject.Inject

/**
 * Use case for saving the provided access token.
 *
 * @property tokenRepository The repository used to manage token storage.
 */
class SaveAccessTokenUseCase @Inject constructor(private val tokenRepository: TokenRepository) {
    /**
     * Executes the use case to save the access token.
     *
     * @param token The access token to be saved.
     */
    fun execute(token: String) {
        tokenRepository.saveAccessToken(token)
    }
}
