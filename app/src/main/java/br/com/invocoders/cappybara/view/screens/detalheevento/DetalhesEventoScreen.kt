package br.com.invocoders.cappybara.view.screens.detalheevento

import com.google.gson.Gson
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.services.obterEnderecoTexto
import br.com.invocoders.cappybara.core.services.obterEventoDetalhePorId
import br.com.invocoders.cappybara.core.utils.formatarDataHora
import br.com.invocoders.cappybara.core.utils.mostrarMensagemEmConstrucao
import br.com.invocoders.cappybara.view.components.shared.ImagemUsuarioComponent
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DetalhesEventoScreen(eventoId: Long, navController: NavController) {
    val evento = obterEventoDetalhePorId(eventoId)

    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))
    val contexto = LocalContext.current
    val scrollState = rememberScrollState(0)

    Column(
        Modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .fillMaxSize(),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .zIndex(1f)
                    .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .shadow(
                                elevation = 20.dp,
                                spotColor = Color(0x154AD2E4),
                                ambientColor = Color(0x154AD2E4)
                            )
                            .padding(0.dp)
                            .width(40.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(size = 7.dp),
                        colors = CardColors(
                            containerColor = colorResource(id = R.color.cinza_escuro),
                            contentColor = colorResource(id = R.color.cinza_escuro),
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.White
                        ),
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = "Salvar",
                                tint = colorResource(id = R.color.branco)
                            )
                        }
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .shadow(
                                elevation = 20.dp,
                                spotColor = Color(0x154AD2E4),
                                ambientColor = Color(0x154AD2E4)
                            )
                            .padding(0.dp)
                            .width(40.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(size = 7.dp),
                        colors = CardColors(
                            containerColor = Color(0x31C0BDBD),
                            contentColor = colorResource(id = R.color.cinza_escuro),
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.White
                        )
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Rounded.Favorite,
                                contentDescription = "Salvar",
                                tint = colorResource(id = R.color.salmao)
                            )
                        }
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(225.dp)
            ) {
                AsyncImage(
                    model = evento.imagens.firstOrNull(),
                    contentDescription = "Concertos no Parque",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 191.dp, bottom = 0.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .shadow(
                                elevation = 20.dp,
                                spotColor = Color.Black,
                                ambientColor = Color.Black
                            )
                            .padding(0.dp)
                            .width(295.dp)
                            .height(60.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(100)),
                        colors = CardColors(
                            containerColor = Color.White,
                            contentColor = Color.White,
                            disabledContainerColor = Color.White,
                            disabledContentColor = Color.White,
                        ),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 13.dp)
                        ) {
                            Column {
                                Row {
                                    ImagemUsuarioComponent(
                                        34.dp,
                                        34.dp,
                                        3f,
                                        Color.Red,
                                        Color.Black,
                                        0.dp
                                    )

                                    ImagemUsuarioComponent(
                                        34.dp,
                                        34.dp,
                                        2f,
                                        Color.Blue,
                                        Color.Black,
                                        -(20).dp
                                    )

                                    ImagemUsuarioComponent(
                                        34.dp,
                                        34.dp,
                                        1f,
                                        Color.Green,
                                        Color.Black,
                                        -(40).dp
                                    )
                                }
                            }

                            Column {
                                Text(
                                    text = "+20 outros",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = roboto,
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF3F38DD),
                                    ),
                                    modifier = Modifier.offset(x = -(35).dp)
                                )
                            }

                            Column {
                                Button(
                                    onClick = {
                                        mostrarMensagemEmConstrucao(contexto)
                                    },
                                    modifier = Modifier
                                        .shadow(
                                            elevation = 20.dp,
                                            spotColor = Color(0x154AD2E4),
                                            ambientColor = Color(0x154AD2E4)
                                        )
                                        .padding(0.dp)
                                        .fillMaxWidth()
                                        .height(28.dp)
                                        .padding(end = 14.dp),
                                    shape = RoundedCornerShape(size = 7.dp),
                                    colors = ButtonColors(
                                        containerColor = Color(0xFF5669FF),
                                        contentColor = Color(0xFF5669FF),
                                        disabledContainerColor = Color.White,
                                        disabledContentColor = Color.White
                                    )
                                ) {
                                    Text(
                                        text = "Check-in",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(900),
                                            color = Color(0xFFFFFFFF),
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                            }

                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Text(
                        text = evento.titulo,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(900),
                            color = Color(0xFF120D26),
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(48.dp)
                                    .height(48.dp),
                                shape = RoundedCornerShape(size = 12.dp),
                                colors = CardColors(
                                    containerColor = Color(0x31576AFF),
                                    contentColor = colorResource(id = R.color.azul),
                                    disabledContentColor = Color.White,
                                    disabledContainerColor = Color.White
                                )
                            ) {
                                Column(
                                    Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painterResource(id = R.drawable.baseline_calendar_month_24_azul),
                                        contentDescription = "Calendário"
                                    )
                                }
                            }

                            Column(
                                Modifier.padding(start = 14.dp),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                val (dataFormatada, horarioFormatado) = formatarDataHora(
                                    evento.dataHoraInicio,
                                    evento.dataHoraTermino
                                )

                                Row {
                                    Text(
                                        text = dataFormatada,
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            lineHeight = 34.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(600),
                                            color = Color(0xFF120D26),
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Row {
                                    Text(
                                        text = horarioFormatado,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF747688),
                                        )
                                    )
                                }
                            }
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .shadow(
                                    elevation = 20.dp,
                                    spotColor = Color(0x154AD2E4),
                                    ambientColor = Color(0x154AD2E4)
                                )
                                .padding(0.dp)
                                .width(66.dp)
                                .height(28.dp),
                            shape = RoundedCornerShape(size = 7.dp),
                            colors = CardColors(
                                containerColor = Color(0x31576AFF),
                                contentColor = colorResource(id = R.color.azul),
                                disabledContentColor = Color.White,
                                disabledContainerColor = Color.White
                            )
                        ) {
                            Column(
                                Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                val formato = NumberFormat.getNumberInstance(Locale("pt", "BR"))
                                formato.minimumFractionDigits = 2
                                formato.maximumFractionDigits = 2

                                Text(
                                    text = "R$ ${formato.format(evento.preco)}",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = roboto,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF5669FF),
                                        textAlign = TextAlign.Center,
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(48.dp)
                                    .height(48.dp),
                                shape = RoundedCornerShape(size = 12.dp),
                                colors = CardColors(
                                    containerColor = Color(0x31576AFF),
                                    contentColor = colorResource(id = R.color.azul),
                                    disabledContentColor = Color.White,
                                    disabledContainerColor = Color.White
                                )
                            ) {
                                Column(
                                    Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painterResource(id = R.drawable.baseline_location_on_24_azul),
                                        contentDescription = "Localização"
                                    )
                                }
                            }

                            Column(
                                Modifier.padding(start = 14.dp),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row {
                                    Text(
                                        text = evento.titulo,
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            lineHeight = 34.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(600),
                                            color = Color(0xFF120D26),
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Row {
                                    var endereco by remember { mutableStateOf("Carregando...") }
                                    val scope = rememberCoroutineScope()

                                    LaunchedEffect(Unit) {
                                        scope.launch {
                                            endereco = obterEnderecoTexto(evento.latitude, evento.longitude)
                                        }
                                    }

                                    Text(
                                        text = endereco,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF747688),
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        MapaScreen(evento = (evento))
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row {
                            AsyncImage(
                                model = "https://images.unsplash.com/photo-1530649159659-c8beb2992433?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                contentDescription = evento.artistas,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(48.dp)
                                    .height(48.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                            )

                            Column(
                                Modifier.padding(start = 14.dp),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Spacer(modifier = Modifier.height(5.dp))

                                Row {
                                    Text(
                                        text = evento.artistas,
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            lineHeight = 25.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(900),
                                            color = Color(0xFF0D0C26),
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(5.dp))

                                Row {
                                    Text(
                                        text = "Organizador",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = roboto,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF747688),
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Text(
                        text = "Sobre o evento",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 25.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF0D0C26),
                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Text(
                        text = evento.descricao,
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 25.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF0D0C26),
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(bottom = 24.dp),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Button(
                onClick = {
                    val jsonEvento = Gson().toJson(evento)

                    navController.navigate("rotaEvento/?eventoDetalhe=$jsonEvento")
                },
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = Color(0x154AD2E4),
                        ambientColor = Color(0x154AD2E4)
                    )
                    .padding(0.dp)
                    .width(271.dp)
                    .height(58.dp)
                    .padding(end = 14.dp),
                shape = RoundedCornerShape(size = 12.dp),
                colors = ButtonColors(
                    containerColor = Color(0xFF5669FF),
                    contentColor = Color(0xFF5669FF),
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White
                )
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "COMO CHEGAR",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.sp,
                        )
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .shadow(
                                    elevation = 20.dp,
                                    spotColor = Color(0x154AD2E4),
                                    ambientColor = Color(0x154AD2E4)
                                )
                                .padding(0.dp)
                                .width(40.dp)
                                .height(40.dp),
                            shape = RoundedCornerShape(100),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.salmao),
                                contentColor = colorResource(id = R.color.cinza_escuro),
                                disabledContentColor = Color.White,
                                disabledContainerColor = Color.White
                            )
                        ) {
                            Column(
                                Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Rounded.ArrowForward,
                                    contentDescription = "Como chegar",
                                    tint = colorResource(id = R.color.branco)
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}