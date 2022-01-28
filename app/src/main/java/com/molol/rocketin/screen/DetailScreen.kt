package com.molol.rocketin.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.molol.rocketin.rememberMapViewWithLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(navController: NavController, lat: Float?, lng: Float?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        //Text("Detail screen $lat , $lng")
        Map(lat ?: -35.016f, lng ?: -50.321f )
    }

}

@Composable
fun Map(lat: Float, lng: Float) {
    val mapView = rememberMapViewWithLifecycle()

    Column {
        AndroidView({ mapView }) { mapV ->
            CoroutineScope(Dispatchers.Main).launch {
                mapV.getMapAsync {
                    val destination = LatLng(lat.toDouble(), lng.toDouble())
                    it.moveCamera(CameraUpdateFactory.newLatLngZoom(destination, 14f))
                    val markerOptions = MarkerOptions()
                        .title("Starbucks")
                        .position(destination)
                    it.addMarker(markerOptions)
                }
            }


        }
    }
}
