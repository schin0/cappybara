package br.com.invocoders.cappybara.view.components.busca

import android.app.DatePickerDialog
import android.widget.DatePicker
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.utils.mostrarMensagemEmConstrucao
import androidx.compose.runtime.*
import java.util.*

@Composable
fun SelecaoDataComponent(onDataSelecionada: (String) -> Unit) {
    val contexto = LocalContext.current

    val calendario = Calendar.getInstance()
    val ano = calendario.get(Calendar.YEAR)
    val mes = calendario.get(Calendar.MONTH)
    val dia = calendario.get(Calendar.DAY_OF_MONTH)

    var dataSelecionada by remember { mutableStateOf("") }
    var hojeSelecionado by remember { mutableStateOf(true) }

    val datePickerDialog = DatePickerDialog(
        contexto,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            dataSelecionada = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDataSelecionada(dataSelecionada)
        }, ano, mes, dia
    )

    Column {
        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    dataSelecionada = "$dia/${mes + 1}/$ano"
                    onDataSelecionada(dataSelecionada)
                    hojeSelecionado = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (hojeSelecionado) Color(0xFF6F7CF5) else Color(0xFFF0F0F0),
                    contentColor = if (hojeSelecionado) Color.White else Color.Black
                )
            ) {
                Text("Hoje")
            }
            Button(
                onClick = {
                    hojeSelecionado = false
                    calendario.add(Calendar.DAY_OF_MONTH, 1)
                    val amanhaDia = calendario.get(Calendar.DAY_OF_MONTH)
                    val amanhaMes = calendario.get(Calendar.MONTH)
                    val amanhaAno = calendario.get(Calendar.YEAR)
                    dataSelecionada = "$amanhaDia/${amanhaMes + 1}/$amanhaAno"
                    calendario.add(Calendar.DAY_OF_MONTH, -1)
                    onDataSelecionada(dataSelecionada)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (hojeSelecionado) Color(0xFFF0F0F0) else Color(0xFF6F7CF5),
                    contentColor = if (hojeSelecionado) Color.Black else Color.White
                )
            ) {
                Text("Amanhã")
            }
            Button(
                onClick = {
                    mostrarMensagemEmConstrucao(contexto)
                },
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
            onClick = {
                datePickerDialog.show()
            },
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
                Text(if (dataSelecionada.isEmpty()) "Escolha uma data" else dataSelecionada)
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }

}