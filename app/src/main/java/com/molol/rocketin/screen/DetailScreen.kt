package com.molol.rocketin.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.molol.rocketin.rememberMapViewWithLifecycle
import com.molol.rocketin.viewmodel.DetailViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//Major features of 1.0.0
//
//The androidx.hilt:hilt-navigation-compose artifact provides APIs that allow users to get a @HiltViewModel annotated ViewModel from a Navigation back stack entry within a Compose application using :navigation-compose.
//
//The function hiltViewModel() returns an existing ViewModel or creates a new one scoped to the current navigation graph present on the NavController back stack. The function can optionally take a NavBackStackEntry to scope the ViewModel to a parent back stack entry.

@Composable
fun DetailScreen(navController: NavController) {
    val viewModel :DetailViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail ${viewModel.instancesCount}") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {

        //Text("Detail screen $lat , $lng")
        Column() {
            Text("Count ${viewModel.instancesCount}")
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {
                navController.navigate("another")
            }) {
                Text("Another screen!")

            }
        }
    }

}


