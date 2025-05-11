package com.apptive.wotd.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onKakaoLoginClicked() {
        _uiState.value = LoginUiState.Loading
        // TODO : 로그인 로직
        _uiState.value = LoginUiState.Success
    }

    fun onGoogleLoginClicked() {
        _uiState.value = LoginUiState.Loading
        // TODO : 로그인 로직
        _uiState.value = LoginUiState.Error("Google 로그인 실패")
    }
}