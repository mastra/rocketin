package com.molol.rocketin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.molol.rocketin.screen.AnotherScreen
import com.molol.rocketin.screen.DetailScreen
import com.molol.rocketin.screen.ListScreen
import com.molol.rocketin.ui.theme.RocketinTheme
import com.molol.rocketin.viewmodel.DetailViewModel
import com.molol.rocketin.viewmodel.ListViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RocketinTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RocketinTheme {
        Greeting("Android")
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            val viewModel = getViewModel<ListViewModel>()
            ListScreen(navController, viewModel )
        }
        composable("detail" ) { entry ->
            val viewModel = getViewModel<DetailViewModel>()
            DetailScreen(  navController , viewModel )
        }
        composable( "another") {
            AnotherScreen(navController = navController)
        }
    }
}