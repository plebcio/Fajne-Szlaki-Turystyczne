package com.szlaki.turystyczne.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ErrorScreen(
    navController: NavHostController,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Something went wrong!"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Go to Main Screen")
        }
    }
}