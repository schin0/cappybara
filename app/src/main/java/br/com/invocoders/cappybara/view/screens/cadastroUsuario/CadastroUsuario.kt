package br.com.invocoders.cappybara.view.screens.cadastroUsuario

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.services.LoginService
import br.com.invocoders.cappybara.view.components.cadastroUsuario.LinhasCarregamento
import br.com.invocoders.cappybara.view.components.shared.BotaoVoltar
import br.com.invocoders.cappybara.view.screens.login.mostrarMensagemErro
import br.com.invocoders.cappybara.view.screens.login.redirecionarParaHome
import kotlinx.coroutines.flow.collectLatest
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroUsuarioScreen(navController: NavController){
    var nome by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    var abrirDatePicker by remember { mutableStateOf(false) }

    Column (modifier = Modifier.padding(20.dp)){

        BotaoVoltar(navController)
        Text(text = "Crie a sua Conta", color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold , modifier = Modifier.padding(bottom = 30.dp))
        LinhasCarregamento()
        Column(modifier = Modifier.padding(top = 35.dp)) {
            TextField(
                value = nome,
                onValueChange = {
                    nome = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    ,
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Nome Completo")
                    }
                },
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = data,
                onValueChange = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp),
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Data de Nascimento")
                    }
                },
                interactionSource = remember {
                    MutableInteractionSource()
                }.also {
                    LaunchedEffect(it) {
                        it.interactions.collectLatest { interaction ->
                            if(interaction is PressInteraction.Release)
                                abrirDatePicker = true
                        }
                    }

                },
                readOnly = true,
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )

            )
            val state = rememberDatePickerState()
            AnimatedVisibility(abrirDatePicker) {
                DatePickerDialog(
                    onDismissRequest = {
                        abrirDatePicker = false
                    },  confirmButton = {
                        Button(onClick = {
                           data = state.selectedDateMillis?.let { millis ->
                               Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime()
                           }.toString()
                                abrirDatePicker = false
                            abrirDatePicker = false
                        }) {
                            Text("selecionar")
                        }
                    }) {
                    DatePicker(state)
                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp),
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Abc@email.com")
                    }
                },
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )

            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = senha,
                onValueChange = {
                    senha = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp),
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_password_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Digite sua senha")
                    }
                },
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )

            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = confirmarSenha,
                onValueChange = {
                    confirmarSenha = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp),
                singleLine = true,
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_password_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Confirme sua senha")
                    }
                },
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            Button(
                onClick = {
                    navController.navigate("PreferenciaUsuario")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5669FF)
                )
            ) {
                Text(
                    text = "Avançar",
                    color = Color.White,
                )
            }
        }
    }
}