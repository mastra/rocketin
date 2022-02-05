package com.molol.rocketin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AnotherScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.background(Color.Yellow),
        topBar = {
            TopAppBar(
                title = { Text("Another Screen") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        //Text("Detail screen $lat , $lng")
        Column( ) {
            Text( "ANOTHER SCREEN", fontSize = 40.sp)
        }
    }
}