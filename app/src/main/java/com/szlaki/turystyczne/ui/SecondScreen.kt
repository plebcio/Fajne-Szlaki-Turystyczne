package com.szlaki.turystyczne.ui


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SecondScreen(
    secondScreenViewModel: SecondScreenViewModel = viewModel()
) {
    val trailUiState by secondScreenViewModel.uiState.collectAsState()
    var timerState by remember { mutableStateOf(TimerState.Stopped) }
    var elapsedTime by remember { mutableIntStateOf(0) }
    var job: Job? by remember { mutableStateOf(null) }

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

        Text(
            text = formatTime(elapsedTime),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                if (timerState == TimerState.Stopped) {
                    job = CoroutineScope(Dispatchers.Main).launch {
                        timerState = TimerState.Running
                        while (timerState == TimerState.Running) {
                            delay(Duration.ofSeconds(1))
                            elapsedTime++
                        }
                    }
                }
            }) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                timerState = TimerState.Stopped
                job?.cancel()
            }) {
                Text(text = "Stop")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                timerState = TimerState.Stopped
                job?.cancel()
                elapsedTime = 0
                job = null
            }) {
                Text(text = "Restart")
            }
        }
    }
}

@Composable
fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return "%02d:%02d".format(minutes, remainingSeconds)
}

enum class TimerState {
    Running,
    Stopped
}
