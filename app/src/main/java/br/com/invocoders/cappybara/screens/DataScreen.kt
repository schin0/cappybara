package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

private fun Long.formatarParaDataBrasileira(
    formato: String = "dd/MM/yyyy"
): String {
    return SimpleDateFormat(
        formato, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }.format(Date(this))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen() {
    val focusManager = LocalFocusManager.current

    var selecaoData by remember {
        mutableStateOf(false)
    }

    val estadoSelecao = rememberDatePickerState()

    var dataSelecionada by remember {
        mutableStateOf("")
    }
    if (selecaoData) {
        DatePickerDialog(
            modifier = Modifier.fillMaxWidth(),
            colors = DatePickerDefaults.colors(
                containerColor = Color.Black
            ),
            onDismissRequest = { selecaoData = false },
            confirmButton = {
                Button(
                    onClick = {
                        estadoSelecao
                            .selectedDateMillis?.let { millis ->
                                dataSelecionada = millis.formatarParaDataBrasileira()
                            }
                        selecaoData = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.cinza_claro),
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Escolher data")
                }
            }) {
            DatePicker(state = estadoSelecao)
        }
    }

    ProvideTextStyle(TextStyle(color = Color.Black)) {
        TextField(
            value = dataSelecionada,
            onValueChange = { },
            Modifier
                .fillMaxWidth()
                .onFocusEvent {
                    if (it.isFocused) {
                        selecaoData = true
                        focusManager.clearFocus(force = true)
                    }
                }
                .border(border = BorderStroke(1.dp, Color.Black)),
            shape = RoundedCornerShape(8.dp),
            label = {
                Text("Escolher data", color = Color.Black)
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
            ),
            readOnly = true
        )
    }
    
    Spacer(modifier = Modifier.height(32.dp))
}