package com.szlaki.turystyczne

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.szlaki.turystyczne.data.TrailRepository
import com.szlaki.turystyczne.ui.HomeScreen
import com.szlaki.turystyczne.ui.SecondScreen
import com.szlaki.turystyczne.ui.SecondScreenViewModel
import com.szlaki.turystyczne.ui.theme.SzlakiTurystyczneTheme
import dagger.hilt.android.lifecycle.HiltViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SzlakiTurystyczneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowInfo = rememberWindowInfo()
                    val navController = rememberNavController()

                    val trailRepo = TrailRepository()
                    trailRepo.create()
                    // Create some viewmodel here cause this will load everytime
                    // we don't want to call the repo create everytime

                    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
                        NavigationMode(navController = navController, trailRepo = trailRepo)
                    } else {
                        SideBySideMode(navController = navController, trailRepo = trailRepo)
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationMode(
    navController: NavHostController,
    trailRepo: TrailRepository
) {
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
            val viewModel = SecondScreenViewModel(
                trailId = it.arguments?.getInt("trailId"),
                navController = navController,
                trailRepo = trailRepo
            )
            SecondScreen(viewModel)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SideBySideMode(
    navController: NavHostController,
    trailRepo: TrailRepository
) {
    SzlakiTurystyczneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {

                HomeScreen(
                    navController = navController, names = listOf("a", "b", "c")
                )

                SecondScreen(
                )
            }

        }
    }
}