package com.analikastore.app.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun EcommerceApp() {
    MaterialTheme {
        Surface {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }
    }
}
