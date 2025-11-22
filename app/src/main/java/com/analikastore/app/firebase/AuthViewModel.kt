package com.analikastore.app.firebase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _user = MutableStateFlow<FirebaseUser?>(FirebaseAuthWrapper.currentUser())
    val user: StateFlow<FirebaseUser?> = _user

    fun refreshUser() {
        _user.value = FirebaseAuthWrapper.currentUser()
    }

    fun signOut() {
        FirebaseAuthWrapper.signOut()
        refreshUser()
    }

    fun signIn(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val u = FirebaseAuthWrapper.signInWithEmail(email, password)
                _user.value = u
                onResult(true, null)
            } catch (e: Exception) {
                onResult(false, e.message)
            }
        }
    }

    fun signUp(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val u = FirebaseAuthWrapper.signUpWithEmail(email, password)
                _user.value = u
                onResult(true, null)
            } catch (e: Exception) {
                onResult(false, e.message)
            }
        }
    }
}
