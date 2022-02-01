package com.molol.rocketin.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.molol.rocketin.viewmodel.ListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ListScreen(navController: NavController,viewModel: ListViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Starbucks") },
            )
        }

    ) {
        Column() {
            LazyColumn() {
                items( viewModel.starbacks.value) { bar ->

                    Text(bar.name, fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                        navController.navigate("detail/${bar.geometry.location?.lat}/${bar.geometry.location?.lng}")
                    })
                }
            }
        }

    }

}