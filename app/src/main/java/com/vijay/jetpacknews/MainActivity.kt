package com.vijay.jetpacknews

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vijay.jetpacknews.presentation.home.HomeScreen
import com.vijay.jetpacknews.presentation.home.HomeViewModel
import com.vijay.jetpacknews.presentation.navgraph.NavGraph
import com.vijay.jetpacknews.ui.theme.JetPAckNewsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
//    @Inject
//    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        setContent {
            JetPAckNewsTheme {
//
//                    val isSystemInDarkMode = isSystemInDarkTheme()
//                val systemController = rememberSystemUiController()
//                SideEffect {
//                    systemController.setSystemBarsColor(
//                        color = Color.Transparent,
//                        darkIcons = !isSystemInDarkMode
//                    )
//                }
                // A surface container using the 'background' color from the theme
                    Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
//                        val startDestination = viewModel.startDestination
//                        NavGraph(startDestination =  startDestination)
                        val viewModel: HomeViewModel = hiltViewModel()
                        val articles = viewModel.news.collectAsLazyPagingItems()
                        HomeScreen(articles = articles, navigate = {})
                    }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPAckNewsTheme {
        Greeting("Android")
    }
}