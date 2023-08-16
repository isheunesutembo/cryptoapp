package com.example.cryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapp.presentation.Screen
import com.example.cryptoapp.presentation.coin_detail.CoinDetailScreen
import com.example.cryptoapp.presentation.coin_list.CoinListScreen
import com.example.cryptoapp.presentation.ui.theme.CryptoappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController= rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.CoinListScreen.route){
                        composable(
                            route=Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route=Screen.CoinDetailScreen.route+ "/{coinId}"
                        ){
                           CoinDetailScreen()
                        }
                    }

                }

            }
        }
    }
}

