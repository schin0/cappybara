package br.com.invocoders.cappybara.view.screens.cadastroUsuario.preferenciaUsuario

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.core.services.cadastrarUsuario
import br.com.invocoders.cappybara.core.services.listarCategoriaEvento
import br.com.invocoders.cappybara.view.components.cadastroUsuario.preferenciasUsuario.CardsPreferenciaUsuarioComponent
import br.com.invocoders.cappybara.view.components.cadastroUsuario.preferenciasUsuario.LinhasCarregamentoPreferencia
import br.com.invocoders.cappybara.view.components.shared.BotaoVoltar
import br.com.invocoders.cappybara.view.screens.login.redirecionarParaHome

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PreferenciaUsuarioScreen(navController: NavController) {
    val lista = listarCategoriaEvento()

    Scaffold(
        content = {
            Column(modifier = Modifier.padding(20.dp)) {
                BotaoVoltar(navController)
                Text(
                    "Escolha Seus ",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
                Text(
                    "Eventos Favoritos",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp,
                    modifier = Modifier.padding(bottom = 30.dp)
                )
                LinhasCarregamentoPreferencia()
                Spacer(modifier = Modifier.height(20.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(lista.size) { index ->
                        CardsPreferenciaUsuarioComponent(item = lista[index])
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(130.dp),
                containerColor = Color.White,
                content = {
                    Button(
                        onClick = {
                            redirecionarParaHome(navController)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(36.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF5669FF)
                        )
                    ) {
                        Text(
                            text = "Criar Conta",
                            color = Color.White,
                        )
                    }
                }
            )
        },
        containerColor = Color.White
    )

}
