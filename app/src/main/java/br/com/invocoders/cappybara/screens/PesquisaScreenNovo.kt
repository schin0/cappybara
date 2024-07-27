package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.services.mostrarMensagemEmConstrucao

@Composable
fun PesquisaScreenNovo(navController: NavController) {
    val contexto = LocalContext.current
    val andikaNewBasicFont = FontFamily(Font(R.font.andika_new_basic))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, top = 16.dp, end = 32.dp, bottom = 64.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.Black
                )
            }

            Text(
                text = "Explorar",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = andikaNewBasicFont,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF120D26),
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { mostrarMensagemEmConstrucao(contexto) },
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Pesquisar",
                    tint = colorResource(id = R.color.azul)
                )
            }

            Text(
                text = "Buscar...",
                style = TextStyle(
                    fontSize = 24.33.sp,
                    fontFamily = andikaNewBasicFont,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000).copy(alpha = 0.3f)
                ),
            )

            // Botao Filtrar
            Box(
                modifier = Modifier
                    .width(82.dp)
                    .height(32.dp)
                    .background(
                        color = Color(0xFFFF8C00),
                        shape = RoundedCornerShape(size = 100.dp)
                    ),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Filtrar",
                        tint = Color.White,
                    )

                    Text(
                        text = "Filtros",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = andikaNewBasicFont,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFECEBFC),
                            textAlign = TextAlign.Center,
                        )
                    )

                }
            }


        }


    }

}