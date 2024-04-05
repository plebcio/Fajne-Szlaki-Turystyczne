package com.szlaki.turystyczne.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.szlaki.turystyczne.Trail

@Composable
fun SecondScreen(
    secondScreenViewModel: SecondScreenViewModel = viewModel()
) {
    val trailUiState by secondScreenViewModel.uiState.collectAsState()

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = trailUiState.trail.name
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = trailUiState.trail.description
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Length: ${trailUiState.trail.length} km"
        )
        Button(onClick = {
            secondScreenViewModel.navigateBack()
        }) {
            Text(text = "Go to Main Screen")
        }

        Button(onClick = {
            secondScreenViewModel.toggleTimer()
        }) {
            Text(text = "Toggle Timer")
        }

        if (trailUiState.IsTimerStarted) {
            Text(text = "Timer is started")
        } else {
            Text(text = "Timer is stopped")
        }

    }
}