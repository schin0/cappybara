package br.com.invocoders.cappybara.view.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.res.colorResource
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
import br.com.invocoders.cappybara.data.model.EventoResumo
import br.com.invocoders.cappybara.core.services.obterEnderecoTexto
import br.com.invocoders.cappybara.core.utils.abreviarDuracao
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun CardEventoPertoComponent(evento: EventoResumo, navController: NavController, duracaoRota: String? = null, distanciaRota: String? = null) {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))

    Card(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color.LightGray,
                ambientColor = Color(0x0F505588)
            )
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .height(112.dp)
            .clickable {
                if (duracaoRota == null && distanciaRota == null)
                    navController.navigate("detalhesEvento/${evento.id}")
            },
        shape = RoundedCornerShape(size = 18.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.White,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.White,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp)
                    .clip(RoundedCornerShape(18.dp))
            ) {
                AsyncImage(
                    model = evento.urlImagem.firstOrNull(),
                    contentDescription = evento.titulo,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(top = 0.dp, end = 0.dp, start = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // TODO: Ajustar data
                    Text(
                        text = "11 JUL - QUI - 15h00",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFEE544A),
                        )
                    )

                    Icon(
                        painterResource(id = R.drawable.baseline_bookmark_24),
                        contentDescription = "Salvar",
                        tint = colorResource(
                            id = R.color.salmao
                        ),
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }

                Row {
                    Text(
                        text = evento.titulo,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF120D26),
                        )
                    )
                }

                if (duracaoRota != null && distanciaRota != null) {
                    Row {
                        Text(
                            text = "${abreviarDuracao(duracaoRota)} ($distanciaRota)",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = roboto,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF120D26),
                            ),
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Localização",
                        tint = colorResource(
                            id = R.color.cinza_escuro
                        )
                    )

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
                            fontSize = 13.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF2B2849),
                        )
                    )
                }
            }

        }
    }
}