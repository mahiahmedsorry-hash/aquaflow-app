package com.aquaflow.app.core.navigation
sealed class Destination(val route: String, val title: String) {
    object Dashboard : Destination("dashboard", "Dashboard")
    object Body : Destination("body", "Body")
    object Analytics : Destination("analytics", "Analytics")
    object Settings : Destination("settings", "Settings")
}
val bottomNavItems = listOf(Destination.Dashboard, Destination.Body, Destination.Analytics, Destination.Settings)
