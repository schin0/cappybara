package br.com.invocoders.cappybara

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.invocoders.cappybara.screens.DetalhesEventoScreenNovo
import br.com.invocoders.cappybara.screens.HomeScreenNovo
import br.com.invocoders.cappybara.screens.InicioAppSreen
import br.com.invocoders.cappybara.screens.PesquisaScreenNovo
import br.com.invocoders.cappybara.screens.telabuscar.BuscaScreen
import br.com.invocoders.cappybara.screens.telalogin.LoginScreen
import br.com.invocoders.cappybara.ui.theme.CappybaraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CappybaraTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val contexto = LocalContext.current

                    NavHost(
                        navController = navController,
                        startDestination = "inicio",
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        composable("inicio") {
                            InicioAppSreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController, contexto)
                        }

                        composable("home") {
                            HomeScreenNovo(navController)
                        }

                        composable("pesquisa") {
                            PesquisaScreenNovo(navController)
                        }

                        composable("buscar") {
                            BuscaScreen(navController)
                        }

                        composable("detalhesEventoNovo/{id}") {
                            val eventoId = it.arguments?.getString("id")
                            eventoId?.toLong()
                                ?.let { id -> DetalhesEventoScreenNovo(id) }
                        }
                    }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val REQUEST_CODE_PERMISSAO_LOCALIZACAO = 100

        when (requestCode) {
            REQUEST_CODE_PERMISSAO_LOCALIZACAO -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                } else {
                    Toast.makeText(this, "Permissão de localização negada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

// TODO: Ajustar padding tela home
// TODO: Adicionar funcionalidade de "bolinhas" embaixo do carrossel
// TODO: No resumo do evento, pensar em ícones de acessibilidades
// TODO: No cadastro de evento, buscar nome da rua