package com.aquaflow.app.core.navigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AquaflowBottomBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    NavigationBar {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) { popUpTo(navController.graph.startDestinationId) { saveState = true }; launchSingleTop = true; restoreState = true } },
                icon = { Icon(imageVector = when(item) { Destination.Dashboard -> Icons.Default.WaterDrop; Destination.Body -> Icons.Default.Accessibility; Destination.Analytics -> Icons.Default.BarChart; Destination.Settings -> Icons.Default.Settings }, contentDescription = item.title) },
                label = { Text(item.title) }
            )
        }
    }
}
