package br.com.invocoders.cappybara.view.components.busca

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.utils.mostrarMensagemEmConstrucao

@Composable
fun SelecaoLocalizacaoComponent() {
    Spacer(modifier = Modifier.height(10.dp))
    val contexto = LocalContext.current

    Column {
        OutlinedButton(
            onClick = {
                mostrarMensagemEmConstrucao(contexto)
            },
            border = BorderStroke(1.dp, Color(0xFFF0F0F0)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color(0xFFF0F0F0),
                contentColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_location_on_24_azul),
                contentDescription = null,
                tint = Color(0xFF6F7CF5)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("São Paulo", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
        }
    }

}