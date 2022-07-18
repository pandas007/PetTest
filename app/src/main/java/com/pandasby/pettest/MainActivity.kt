package com.pandasby.pettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pandasby.pettest.ui.classes.DND_CLASSES_SCREEN
import com.pandasby.pettest.ui.classes.DnDClassesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = DND_CLASSES_SCREEN) {
                    composable(DND_CLASSES_SCREEN) { DnDClassesScreen() }
                }
            }
        }
    }
}