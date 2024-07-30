package br.com.invocoders.cappybara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.invocoders.cappybara.screens.DetalhesEventoScreen
import br.com.invocoders.cappybara.screens.HomeScreenNovo
import br.com.invocoders.cappybara.screens.PesquisaScreenNovo
import br.com.invocoders.cappybara.screens.telabuscar.BuscaScreen
import br.com.invocoders.cappybara.ui.theme.CappybaraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CappybaraTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        composable("home") {
                            HomeScreenNovo(navController)
                        }

                        composable("pesquisa") {
                            PesquisaScreenNovo(navController)
                        }

                        composable("buscar") {
                            BuscaScreen(navController)
                        }

                        composable("detalhesEvento/{eventoId}") {
                            val eventoId = it.arguments?.getString("eventoId")
                            eventoId?.toInt()
                                ?.let { it1 -> DetalhesEventoScreen(navController, it1) }
                        }
                    }
                }
            }
        }
    }
}
