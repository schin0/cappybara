package br.com.invocoders.cappybara.view.screens.preferenciaUsuario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.view.components.cadastroUsuario.LinhasCarregamento
import br.com.invocoders.cappybara.view.components.preferenciasUsuario.LinhasCarregamentoPreferencia
import br.com.invocoders.cappybara.view.components.shared.BotaoVoltar


@Composable
fun PreferenciaUsuarioScreen(navController: NavController){
    Column(modifier = Modifier.padding(20.dp)) {
        BotaoVoltar(navController)
        Text("Escolha Seus ", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 27.sp )
        Text("Eventos Favoritos", color = Color.Black, fontWeight = FontWeight.Bold , fontSize = 27.sp, modifier = Modifier.padding(bottom = 30.dp))
        LinhasCarregamentoPreferencia()
    }
}
