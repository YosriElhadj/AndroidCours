package tn.esprit.jetpack_nascar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tn.esprit.jetpack_nascar.ui.theme.NascarTheme
import tn.esprit.jetpack_nascar.ui.theme.ToolbarLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NascarTheme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ToolbarLayout(onNavigationIconClick = {
                // Handle navigation icon click here if needed
            })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavigationButtons(navController)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            NavigationHost(navController)
        }
    }
}

@Composable
fun NavigationButtons(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { navController.navigate("news") }) {
            Text(text = "News")
        }
        Button(onClick = { navController.navigate("events") }) {
            Text(text = "Events")
        }
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Profile")
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "news") {
        composable("news") { NewsScreen() }
        composable("events") { EventsScreen() }
        composable("profile") { ProfileScreen() }
        composable("about") { AboutScreen() }
    }
}
