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
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.FiltroEvento
import br.com.invocoders.cappybara.ui.theme.CappybaraTheme
import br.com.invocoders.cappybara.view.screens.busca.BuscaScreen
import br.com.invocoders.cappybara.view.screens.busca.RetornoBuscaScreen
import br.com.invocoders.cappybara.view.screens.cadastroUsuario.CadastroUsuarioScreen
import br.com.invocoders.cappybara.view.screens.cadastroUsuario.preferenciaUsuario.PreferenciaUsuarioScreen
import br.com.invocoders.cappybara.view.screens.cadastroevento.CadastroEventoScreen
import br.com.invocoders.cappybara.view.screens.detalheevento.DetalhesEventoScreen
import br.com.invocoders.cappybara.view.screens.detalheevento.RotaScreen
import br.com.invocoders.cappybara.view.screens.home.HomeScreen
import br.com.invocoders.cappybara.view.screens.inicio.InicioScreen
import br.com.invocoders.cappybara.view.screens.login.LoginScreen
import com.google.gson.Gson

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
                            InicioScreen(navController)
                        }

                        composable("login") {
                            LoginScreen(navController, contexto)
                        }

                        composable("cadastroUsuario") {
                            CadastroUsuarioScreen(navController)
                        }

                        composable("preferenciaUsuario") {
                            PreferenciaUsuarioScreen(navController)
                        }

                        composable("home") {
                            HomeScreen(navController)
                        }

                        composable("buscar") {
                            BuscaScreen(navController)
                        }

                        composable("cadastroEvento") {
                            CadastroEventoScreen(navController)
                        }

                        composable("detalhesEvento/{id}") {
                            val eventoId = it.arguments?.getString("id")
                            eventoId?.toLong()
                                ?.let { id -> DetalhesEventoScreen(id, navController) }
                        }

                        composable("rotaEvento/?eventoDetalhe={eventoDetalhe}") { backStackEntry->
                            val jsonEvento = backStackEntry.arguments?.getString("eventoDetalhe")

                            if (jsonEvento != null) {
                                val eventoDetalhe = Gson().fromJson(jsonEvento, EventoDetalhe::class.java)

                                RotaScreen(eventoDetalhe, navController)
                            }
                        }

                        composable("retornoBusca/?filtroEvento={filtroEvento}") { backStackEntry->
                            val jsonEvento = backStackEntry.arguments?.getString("filtroEvento")

                            if (jsonEvento != null) {
                                val filtroEvento = Gson().fromJson(jsonEvento, FiltroEvento::class.java)

                                RetornoBuscaScreen(filtroEvento, navController)
                            }
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
                    Toast.makeText(this, "Permissão de localização negada", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

// TODO: Ajustar padding tela home
// TODO: Adicionar funcionalidade de "bolinhas" embaixo do carrossel
// TODO: No resumo do evento, pensar em ícones de acessibilidades
// TODO: No cadastro de evento, buscar nome da rua