package com.aquaflow.app.core.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun RootScaffold() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { AquaflowBottomBar(navController) }) { innerPadding ->
        AquaflowNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}
