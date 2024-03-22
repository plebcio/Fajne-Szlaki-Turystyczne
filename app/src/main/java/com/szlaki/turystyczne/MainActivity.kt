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
import com.szlaki.turystyczne.ui.theme.SzlakiTurystyczneTheme


val trails = listOf(
    Trail(
        name = "Trail 1",
        description = "Trail 1 description",
        length = 10,
        difficulty = 1,
        durationMin = 60,
        distanceMeter = 1000,
        elevation = 100,
        imagePath = "xd",
        location = "Kraków"
    ),
    Trail(
        name = "Trail 2",
        description = "Trail 2 description",
        length = 20,
        difficulty = 2,
        durationMin = 120,
        distanceMeter = 2000,
        elevation = 200,
        imagePath = "xd",
        location = "Warszawa"
    ),
    Trail(
        name = "Trail 3",
        description = "Trail 3 description",
        length = 30,
        difficulty = 3,
        durationMin = 180,
        distanceMeter = 3000,
        elevation = 300,
        imagePath = "xd",
        location = "Wrocław"
    ),
    Trail(
        name = "Trail 4",
        description = "Trail 4 description",
        length = 40,
        difficulty = 4,
        durationMin = 240,
        distanceMeter = 4000,
        elevation = 400,
        imagePath = "xd",
        location = "Gdańsk"
    ),
    Trail(
        name = "Trail 5",
        description = "Trail 5 description",
        length = 50,
        difficulty = 5,
        durationMin = 300,
        distanceMeter = 5000,
        elevation = 500,
        imagePath = "xd",
        location = "Poznań"
    ),
    Trail(
        name = "Trail 6",
        description = "Trail 6 description",
        length = 60,
        difficulty = 6,
        durationMin = 360,
        distanceMeter = 6000,
        elevation = 600,
        imagePath = "xd",
        location = "Szczecin"
    ),
    Trail(
        name = "Trail 7",
        description = "Trail 7 description",
        length = 70,
        difficulty = 7,
        durationMin = 420,
        distanceMeter = 7000,
        elevation = 700,
        imagePath = "xd",
        location = "Lublin"
    ),
)


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

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.Second.route + "/{trailId}",
                            arguments = listOf(
                                navArgument("name") { type = NavType<Trail> }
                            )
                        ) {
                            SecondScreen(navController = navController)
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