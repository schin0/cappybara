package br.com.invocoders.cappybara.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.model.MenuItem
import br.com.invocoders.cappybara.services.mostrarMensagemEmConstrucao

@Composable
fun BotaoComponente(item: MenuItem, selecionado: Boolean, navController: NavController) {
    val contexto = LocalContext.current

    Button(
        onClick = {
            if (!item.habilitado)
                mostrarMensagemEmConstrucao(contexto)
            else
                navController.navigate(item.nome)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selecionado) Color.Black else Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Black),
        enabled = item.habilitado
    ) {
        Image(
            painter = painterResource(id = if (selecionado) item.iconeIdSelecionado else item.iconeId),
            contentDescription = item.descricaoIcone
        )
    }
}
