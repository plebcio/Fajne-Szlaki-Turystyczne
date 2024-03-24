package com.szlaki.turystyczne

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.szlaki.turystyczne.data.TrailRepository
import com.szlaki.turystyczne.ui.ErrorScreen
import com.szlaki.turystyczne.ui.HomeScreen
import com.szlaki.turystyczne.ui.SecondScreen
import com.szlaki.turystyczne.ui.theme.SzlakiTurystyczneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SzlakiTurystyczneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val trailRepo = TrailRepository()
                    trailRepo.create()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            trailRepo.getTrailNames().forEach { println(it) }
                            HomeScreen(navController = navController, names = trailRepo.getTrailNames())
                        }
                        composable(
                            route = Screen.Second.route + "/{trailId}",
                            arguments = listOf(
                                navArgument("trailId") { type = NavType.IntType }
                            )
                        ) {
                            val trailId = it.arguments?.getInt("trailId")
                            if (trailId != null) {
                                val trail = trailRepo.getTrailbyId(trailId)
                                SecondScreen(navController = navController, trail = trail)
                            } else {
                                ErrorScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SzlakiTurystyczneTheme {
        Greeting("Android")
    }
}