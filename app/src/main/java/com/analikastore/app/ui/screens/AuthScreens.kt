package com.analikastore.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.analikastore.app.firebase.AuthViewModel

@Composable
fun LoginScreen(onLoggedIn: () -> Unit, onNavigateSignup: () -> Unit, vm: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Login")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            vm.signIn(email, password) { ok, msg ->
                if (ok) onLoggedIn() else error = msg
            }
        }) { Text("Sign in") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onNavigateSignup) { Text("Create account") }
        error?.let { Text("Error: $it") }
    }
}

@Composable
fun SignupScreen(onSignedUp: () -> Unit, onBack: () -> Unit, vm: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Create Account")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            vm.signUp(email, password) { ok, msg ->
                if (ok) onSignedUp() else error = msg
            }
        }) { Text("Sign up") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onBack) { Text("Back") }
        error?.let { Text("Error: $it") }
    }
}

@Composable
fun ProfileScreen(vm: AuthViewModel = viewModel()) {
    val user by vm.user.collectAsState()
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Profile")
        Spacer(modifier = Modifier.height(8.dp))
        Text("User: ${'$'}{user?.email ?: "(not logged in)"}")
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { vm.signOut() }) { Text("Sign out") }
    }
}
