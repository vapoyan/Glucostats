package app.glucostats.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.glucostats.dexcom.domain.usecase.AuthenticateUseCase
import app.glucostats.dexcom.domain.usecase.RefreshTokenUseCase
import app.glucostats.storage.domain.repository.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GlucostatsViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val refreshTokenUseCase: RefreshTokenUseCase
) : ViewModel() {

    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticatedFlow: StateFlow<Boolean> get() = _isAuthenticated.asStateFlow()

    init {
        checkAuthenticationStatus()
    }

    private fun checkAuthenticationStatus() {
        viewModelScope.launch {
            val accessToken = tokenRepository.getAccessToken()
            val expiresIn = tokenRepository.getExpiresIn()
            val currentTime = System.currentTimeMillis() / 1000
            val savedTime = tokenRepository.getTokenSaveTime() ?: 0

            if (accessToken != null && (savedTime + (expiresIn ?: 0)) > currentTime) {
                // Access token is still valid
                _isAuthenticated.value = true
            } else {
                // Access token is expired, try to refresh
                val refreshToken = tokenRepository.getRefreshToken()
                if (refreshToken != null) {
                    refreshAccessToken(refreshToken)
                } else {
                    // No refresh token available, user needs to authenticate again
                    _isAuthenticated.value = false
                }
            }
        }
    }

    private fun refreshAccessToken(refreshToken: String) {
        viewModelScope.launch {
            val result = refreshTokenUseCase.execute(refreshToken)
            if (result.isSuccess) {
                val tokenResponse = result.getOrNull()
                if (tokenResponse != null) {
                    // Save the new tokens
                    tokenRepository.saveAccessToken(tokenResponse.accessToken)
                    tokenRepository.saveTokenType(tokenResponse.tokenType)
                    tokenRepository.saveExpiresIn(tokenResponse.expiresIn)
                    tokenRepository.saveRefreshToken(tokenResponse.refreshToken)
                    tokenRepository.saveTokenSaveTime(System.currentTimeMillis() / 1000)

                    _isAuthenticated.value = true
                }
            } else {
                // Refresh token failed, user needs to authenticate again
                _isAuthenticated.value = false
            }
        }
    }
}