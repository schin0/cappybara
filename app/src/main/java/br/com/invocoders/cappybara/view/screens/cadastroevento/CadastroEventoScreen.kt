package br.com.invocoders.cappybara.view.screens.cadastroevento

import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.services.listarCategoriaEvento
import br.com.invocoders.cappybara.model.CategoriaEvento
import br.com.invocoders.cappybara.model.ItemAcessibilidade
import br.com.invocoders.cappybara.view.components.shared.BotaoVoltar
import coil.compose.rememberAsyncImagePainter
import java.time.Instant
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroEventoScreen(navController: NavController) {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))
    var titulo by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var localizacao by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var categoria2 by remember { mutableStateOf(CategoriaEvento(0, "")) }
    var faixaEtaria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var acessibilidadesSelecionadas by remember { mutableStateOf(listOf<String>()) }
    val imagensSelecionadas by remember { mutableStateOf(listOf<Uri>()) }
    val lista = listarCategoriaEvento()

    val acessibilidadesOpcoes = listOf(
        ItemAcessibilidade("Cadeirante", R.drawable.baseline_wheelchair_pickup_24),
        ItemAcessibilidade("Libras", R.drawable.baseline_waving_hand_24),
        ItemAcessibilidade("Idoso", R.drawable.baseline_elderly_24)
    )

    val state = rememberDatePickerState()
    var abrirDatePicker by remember { mutableStateOf(false) }

    AnimatedVisibility(abrirDatePicker) {
        DatePickerDialog(
            onDismissRequest = {
                abrirDatePicker = false
            }, confirmButton = {
                Button(onClick = {
                    data = state.selectedDateMillis?.let { ms ->
                        Instant
                            .ofEpochMilli(ms)
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()
                    }.toString()
                    abrirDatePicker = false
                }) {
                    Text("selecionar")
                }
            }) {
            DatePicker(state)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        BotaoVoltar(navController)

        Text(
            text = "Criar evento",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = roboto,
                fontWeight = FontWeight(700),
                color = Color(0xFF120D26),
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título do evento", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color(0xFFE4DFDF)
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = "Título do evento",
                    tint = Color.LightGray
                )
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            OutlinedTextField(
                value = data,
                onValueChange = { data = it },
                label = { Text("Data", color = Color.Gray) },
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    IconButton(onClick = { abrirDatePicker = true }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_calendar_month_24_black),
                            contentDescription = "Localização"
                        )
                    }
                },
                textStyle = TextStyle(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color(0xFFE4DFDF)
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedTextField(
                value = localizacao,
                onValueChange = { localizacao = it },
                label = { Text("Localização", color = Color.Gray) },
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.outline_location_on_24),
                        contentDescription = "Localização"
                    )
                },
                textStyle = TextStyle(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color(0xFFE4DFDF)
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Acessibilidade:",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 23.sp,
                fontFamily = roboto,
                fontWeight = FontWeight(400),
                color = Color(0xFF747688),
            )
        )
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            acessibilidadesOpcoes.forEach { opcao ->
                val isSelected = acessibilidadesSelecionadas.contains(opcao.descricao)

                FilterChip(
                    selected = isSelected,
                    onClick = {
                        acessibilidadesSelecionadas =
                            if (isSelected) {
                                acessibilidadesSelecionadas - opcao.descricao
                            } else {
                                acessibilidadesSelecionadas + opcao.descricao
                            }
                    },
                    label = {
                        Text(
                            opcao.descricao,
                            color = if (isSelected) Color.White else Color.Gray
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = opcao.iconeId),
                            contentDescription = opcao.descricao,
                            tint = Color(0xFF5669FF)
                        )
                    },
                    modifier = Modifier.padding(7.dp),
                    border = if (isSelected) null else BorderStroke(1.dp, Color.LightGray)
                )
            }
        }

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição do evento", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color(0xFFE4DFDF)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        var expanded by remember { mutableStateOf(false) }
        Box {
            OutlinedTextField(
                value = categoria,
                onValueChange = { categoria = it },
                label = { Text("Categoria do evento", color = Color.Gray) },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                },
                textStyle = TextStyle(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color(0xFFE4DFDF)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.List,
                        contentDescription = "Categoria",
                        tint = Color.LightGray
                    )
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                lista.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option.nome, color = Color.Black) },
                        onClick = {
                            categoria2 = option
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            OutlinedTextField(
                value = faixaEtaria,
                onValueChange = { faixaEtaria = it },
                label = { Text("Faixa etária", color = Color.Gray) },
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color(0xFFE4DFDF)
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_cake_24),
                        contentDescription = "Faixa etária",
                        tint = Color.LightGray
                    )
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedTextField(
                value = preco,
                onValueChange = { preco = it },
                label = { Text("Preço", color = Color.Gray) },
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color(0xFFE4DFDF)
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_attach_money_24),
                        contentDescription = "Preço",
                        tint = Color.LightGray
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            imagensSelecionadas.forEach { uri ->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(4.dp)
                )
            }
            IconButton(onClick = {
                // TODO: Abrir seletor de imagens (Coil ou Glide)
            }) {
                Icon(Icons.Default.Check, contentDescription = "Adicionar Imagem")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // TODO: Lógica para salvar evento
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonColors(
                containerColor = Color(0xFF5669FF),
                contentColor = Color.Black,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            )
        ) {
            Text("Criar Evento", color = Color.White)
        }
    }

}