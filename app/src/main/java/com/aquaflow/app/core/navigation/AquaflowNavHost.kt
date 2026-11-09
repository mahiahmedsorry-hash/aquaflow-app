package com.aquaflow.app.core.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aquaflow.app.feature.analytics.AnalyticsScreen
import com.aquaflow.app.feature.body.BodyScreen
import com.aquaflow.app.feature.dashboard.DashboardScreen
import com.aquaflow.app.feature.settings.SettingsScreen

@Composable
fun AquaflowNavHost(navController: NavHostController, modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier) {
    NavHost(navController = navController, modifier = modifier, startDestination = Destination.Dashboard.route) {
        composable(Destination.Dashboard.route) { DashboardScreen() }
        composable(Destination.Body.route) { BodyScreen() }
        composable(Destination.Analytics.route) { AnalyticsScreen() }
        composable(Destination.Settings.route) { SettingsScreen() }
    }
}
