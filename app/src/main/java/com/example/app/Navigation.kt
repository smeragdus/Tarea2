package com.example.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Home : Screen("home")
    object Form : Screen("form")
    object Welcome : Screen("welcome/{email}") {
        fun createRoute(email: String) = "welcome/$email"
    }
}

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object HolaMundo : BottomNavItem("hola_mundo", "Hola Mundo", Icons.Default.Home)
    object Mensaje : BottomNavItem("mensaje", "Mensaje", Icons.Default.Email)
}
