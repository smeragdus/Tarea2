package com.example.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app.BottomNavItem
import com.example.app.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var texto by remember { mutableStateOf("Hola Mundo") }
    var indiceSeleccionado by remember { mutableStateOf(0) }

    val items = listOf(
        BottomNavItem.HolaMundo,
        BottomNavItem.Mensaje
    )

    val textos = listOf("Hola Mundo", "Bienvenido a la App")

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = indiceSeleccionado == index,
                        onClick = {
                            indiceSeleccionado = index
                            texto = textos[index]
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = texto,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.popBackStack() }
            ) {
                Text("Regresar a Pantalla Principal")
            }
        }
    }
}
