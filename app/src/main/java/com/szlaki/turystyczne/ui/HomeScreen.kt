package com.szlaki.turystyczne.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.szlaki.turystyczne.Screen


@Composable
fun HomeScreen(
    navController: NavHostController,
    names: List<String>
) {
    var name by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Przewodnik po szlakach"
        )
        Spacer(modifier = Modifier.width(8.dp))
        ClickableNameList(names = names, navController = navController)
    }
}

@Composable
fun ClickableNameList(
    names: List<String>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Text(text = "hello")
    LazyColumn {
        itemsIndexed(names) { index, currentName ->
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = currentName,
                    modifier = modifier
                        .weight(1f)
                        .height(50.dp)
                        .padding(16.dp)
                        .clickable {
                            navController.navigate(Screen.Second.route + "/$index")
                        }
                )
            }
            Divider()
        }
    }
}