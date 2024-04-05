package com.szlaki.turystyczne.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.szlaki.turystyczne.Trail
import com.szlaki.turystyczne.data.TrailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel (
    private var trailId: Int?,
    private val navController: NavHostController,
    private val trailRepo: TrailRepository
): ViewModel() {
    fun navigateBack() {
        navController.popBackStack()
    }

    // get trailId parameter from saved state
    private val _uiState = MutableStateFlow(TrailUiState())
    val uiState: StateFlow<TrailUiState> = _uiState.asStateFlow()
    private var isTrailChosen: Boolean = false

    fun toggleTimer() {
        // start timer
        val timerState = _uiState.value.IsTimerStarted
        _uiState.value = _uiState.value.copy(IsTimerStarted = !timerState)
    }

    init {
        // add some check if trailId is valid
        if (trailId != null) {
            val trail = trailRepo.getTrailbyId(trailId!!)
            _uiState.value = TrailUiState(trail = trail)
            isTrailChosen = true
        } else {
            _uiState.value = TrailUiState()
            isTrailChosen = false
        }
    }


}