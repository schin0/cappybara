package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import br.com.invocoders.cappybara.components.CabecalhoComponent

@Composable
fun HomeScreenNovo(navController: NavController) {
    val scrollState = rememberScrollState(0)
    val andikaNewBasicFont = FontFamily(Font(R.font.andika_new_basic))

    CabecalhoComponent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 85.dp, end = 16.dp, bottom = 64.dp)
            .verticalScroll(scrollState)
    ) {
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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                Modifier
                    .shadow(
                        elevation = 30.dp,
                        spotColor = Color(0x0F505588),
                        ambientColor = Color(0x0F505588)
                    )
                    .padding(0.dp)
                    .width(237.dp)
                    .height(255.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 18.dp)),
                colors = CardColors(
                    containerColor = Color(0xFFFFFFFF),
                    contentColor = Color.Black,
                    disabledContentColor = Color(0xFFFFFFFF),
                    disabledContainerColor = Color(0xFFFFFFFF)
                )
            ) {
                Card(
                    Modifier
                        .padding(10.dp)
                        .width(237.dp)
                        .height(120.dp),
                    colors = CardColors(
                        containerColor = colorResource(id = R.color.azul),
                        contentColor = Color.White,
                        disabledContentColor = Color(0xFFFFFFFF),
                        disabledContainerColor = Color(0xFFFFFFFF)
                    )
                ) {

                }

                Text(
                    text = "FIAP NEXT 2024",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = andikaNewBasicFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier.padding(start = 10.dp)
                )

                Row {
                    Card(modifier = Modifier
                        .border(width = 1.dp, color = Color(0xFFFF0000))
                        .padding(start = 10.dp)
                        .width(24.dp)
                        .height(24.dp),
                        shape = RoundedCornerShape(size = 50.dp)) {

                    }

                    Card(modifier = Modifier
                        .border(width = 1.dp, color = Color(0xFFFF0000))
                        .width(24.dp)
                        .height(24.dp),
                        shape = RoundedCornerShape(size = 50.dp)) {

                    }
                }

            }
        }
    }

    MenuScreenNovo(navController, "home")
}