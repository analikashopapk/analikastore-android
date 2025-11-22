package com.analikastore.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.analikastore.app.ui.screens.*

@Composable
fun NavGraph(navController: androidx.navigation.NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        // Auth-aware navigation: login/signup routes are provided

        composable("home") { HomeScreen(onOpenCategory = { navController.navigate("products") }, onOpenBooking = { navController.navigate("booking") }, onOpenCart = { navController.navigate("cart") }) }
        composable("products") { ProductListScreen(onProductClick = { id -> navController.navigate("product/$id") }, onBack = { navController.popBackStack() }) }
        composable("product/{productId}", arguments = listOf(navArgument("productId") { type = NavType.IntType })) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("productId") ?: 0
            ProductDetailScreen(productId = id, onAddToCart = { /* use shared repo */ }, onBack = { navController.popBackStack() })
            composable("admin/products") { AdminProductsScreen() }
        composable("admin/orders") { AdminOrdersScreen() }
        composable("admin/bookings") { AdminBookingsScreen() }
    }
        composable("cart") { CartScreen(onCheckout = { navController.navigate("checkout") }, onBack = { navController.popBackStack() }) }
        composable("checkout") { CheckoutScreen(onComplete = { /* show confirmation */ }, onBack = { navController.popBackStack() }) }
        composable("booking") { ServiceBookingScreen(onBooked = { /* show confirmation */ }, onBack = { navController.popBackStack() }) }
        composable("admin/products") { AdminProductsScreen() }
        composable("admin/orders") { AdminOrdersScreen() }
        composable("admin/bookings") { AdminBookingsScreen() }
    }
}


    // Authentication routes
    composable("login") { com.analikastore.app.ui.screens.LoginScreen(onLoggedIn = { navController.navigate("home") { popUpTo("login") { inclusive = true } } }, onNavigateSignup = { navController.navigate("signup") }) }
    composable("signup") { com.analikastore.app.ui.screens.SignupScreen(onSignedUp = { navController.navigate("home") }, onBack = { navController.popBackStack() }) }
    composable("profile") { com.analikastore.app.ui.screens.ProfileScreen() }

}
