package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.CabecalhoComponent
import br.com.invocoders.cappybara.components.CardEventoProximo
import br.com.invocoders.cappybara.components.EventosIniciaisComponent
import br.com.invocoders.cappybara.components.home.ProximosEventosComponent

@Composable
fun HomeScreenNovo(navController: NavController) {
    val scrollState = rememberScrollState(0)
    val scrollStateEventosIniciais = rememberScrollState(0)
    rememberScrollState(0)
    val andikaNewBasicFont = FontFamily(Font(R.font.andika_new_basic))

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        CabecalhoComponent()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 64.dp)
                .offset(y = -(65).dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollStateEventosIniciais),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                EventosIniciaisComponent("Atrações")
                EventosIniciaisComponent("Perto de você")
                EventosIniciaisComponent("Teste")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Próximos eventos",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 34.sp,
                        fontFamily = andikaNewBasicFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF120D26),
                    )
                )

                Text(
                    text = "Ver tudo",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        fontFamily = andikaNewBasicFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF747688),
                        textAlign = TextAlign.Right,
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            ProximosEventosComponent()
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .horizontalScroll(scrollStateEventos),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            CardEventoComponent(R.drawable.exposicao_chaves)
//            CardEventoComponent(R.drawable.next2023)
//            CardEventoComponent(R.drawable.braziljs)
//        }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Perto de mim",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 34.sp,
                        fontFamily = andikaNewBasicFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF120D26),
                    )
                )

                Text(
                    text = "Ver tudo",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        fontFamily = andikaNewBasicFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF747688),
                        textAlign = TextAlign.Right,
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CardEventoProximo()
                CardEventoProximo()
            }


        }

    }

    MenuScreenNovo(navController, "home")
}