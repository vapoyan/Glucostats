package app.glucostats.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.glucostats.storage.domain.repository.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GlucostatsViewModel @Inject constructor(
    private val tokenRepository: TokenRepository
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

            _isAuthenticated.value = accessToken != null && (savedTime + (expiresIn ?: 0)) > currentTime
        }
    }
}