package app.glucostats.dexcom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.glucostats.dexcom.data.model.TokenResponse
import app.glucostats.dexcom.domain.usecase.AuthenticateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing Dexcom authentication and interacting with the AuthenticateUseCase.
 */
@HiltViewModel
class DexcomViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {

    private val _authResult = androidx.lifecycle.MutableLiveData<Result<TokenResponse>>()
    val authResult: androidx.lifecycle.LiveData<Result<TokenResponse>> = _authResult

    fun authenticate(code: String, redirectUri: String) {
        viewModelScope.launch {
            val result = authenticateUseCase.execute(code, redirectUri)
            _authResult.postValue(result)
        }
    }
}