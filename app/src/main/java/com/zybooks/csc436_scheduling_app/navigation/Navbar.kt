package com.zybooks.csc436_scheduling_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

enum class AppScreen(val route:Any, val title:String, val icon: ImageVector) {
        HOME(Routes.Home, "Home", Icons.Default.Home),
        CALENDAR(Routes.Calendar, "Calendar", Icons.Default.DateRange)
    }

    @Composable
    fun BottomNavBar(navController: NavController) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavigationBar {
            AppScreen.entries.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute?.endsWith(item.route.toString()) == true,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                        }
                    },
                    icon = {
                        Icon(item.icon, contentDescription = item.title)
                    },
                    label = {
                        Text(item.title)
                    }
                )
            }
        }
    }