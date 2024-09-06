package br.com.invocoders.cappybara.view.components.busca

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R

@Composable
fun SelecaoDataComponent() {
    Column {
        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { /* TODO: ação de selecionar "Hoje" */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF0F0F0),
                    contentColor = Color.Black
                )
            ) {
                Text("Hoje")
            }
            Button(
                onClick = { /* TODO: ação de selecionar "Amanhã" */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6F7CF5),
                    contentColor = Color.White
                )
            ) {
                Text("Amanhã")
            }
            Button(
                onClick = { /* TODO: ação de selecionar "Essa semana" */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF0F0F0),
                    contentColor = Color.Black
                )
            ) {
                Text("Essa semana")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = { /* TODO: ação de escolher uma data */ },
            border = BorderStroke(1.dp, Color(0xFF6F7CF5)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF6F7CF5)
            ),
            modifier = Modifier
                .width(241.dp)
                .padding(end = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painterResource(id = R.drawable.baseline_calendar_month_24_azul),
                    contentDescription = null
                )
                Text("Escolha uma data")
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}