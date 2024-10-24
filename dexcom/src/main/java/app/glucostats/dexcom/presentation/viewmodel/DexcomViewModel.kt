package app.glucostats.dexcom.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.glucostats.dexcom.data.model.TokenResponse
import app.glucostats.dexcom.domain.usecase.AuthenticateUseCase
import app.glucostats.storage.domain.repository.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for handling Dexcom-related authentication and token management.
 *
 * @property tokenRepository The repository used to manage token storage.
 */
@HiltViewModel
class DexcomViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {

    private val _authResult = MutableLiveData<Result<TokenResponse>>()
    val authResult: LiveData<Result<TokenResponse>> get() = _authResult

    /**
     * Initiates the authentication process.
     *
     * @param code The authorization code received from Dexcom.
     * @param redirectUri The redirect URI used in the authentication process.
     */
    fun authenticate(code: String, redirectUri: String) {
        viewModelScope.launch {
            val result = authenticateUseCase.execute(code, redirectUri)
            _authResult.postValue(result)
        }
    }

    /**
     * Saves the token information for future use.
     *
     * @param tokenResponse The response containing the access token, token type, and expiration time.
     */
    fun saveToken(tokenResponse: TokenResponse) {
        tokenRepository.saveAccessToken(tokenResponse.accessToken)
        tokenRepository.saveTokenType(tokenResponse.tokenType)
        tokenRepository.saveExpiresIn(tokenResponse.expiresIn)
        tokenRepository.saveRefreshToken(tokenResponse.refreshToken)

    }
}