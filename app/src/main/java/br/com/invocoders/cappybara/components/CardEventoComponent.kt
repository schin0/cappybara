package br.com.invocoders.cappybara.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.invocoders.cappybara.R

@Composable
fun CardEventoComponent(imagemId: Int) {
    val andikaNewBasicFont = FontFamily(Font(R.font.andika_new_basic))

    Card(
        Modifier
            .shadow(
                elevation = 30.dp,
                spotColor = Color(0x0F505588),
                ambientColor = Color(0x0F505588)
            )
            .padding(10.dp)
            .width(237.dp)
            .height(255.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 18.dp)
            ),
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
                containerColor = Color.Transparent,
                contentColor = Color.White,
                disabledContentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFFFFFFFF)
            )
        ) {
            Box {
                Image(
                    painterResource(id = imagemId),
                    contentDescription = "Evento",
                    modifier = Modifier
                        .fillMaxSize()
                        .zIndex(-1f)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .zIndex(1f)
                ) {
                    Card(
                        modifier = Modifier
                            .width(45.dp)
                            .height(45.dp),
                        colors = CardColors(
                            containerColor = colorResource(id = R.color.cinza_escuro),
                            contentColor = Color.White,
                            disabledContentColor = Color(0xFFFFFFFF),
                            disabledContainerColor = Color(0xFFFFFFFF)
                        ),
                        shape = RoundedCornerShape(size = 7.dp)
                    ) {
                        Text(
                            text = "12\nJUL",
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 18.sp,
                                fontFamily = andikaNewBasicFont,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFE7215F),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Card(
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp),
                        colors = CardColors(
                            containerColor = colorResource(id = R.color.cinza_escuro),
                            contentColor = Color.White,
                            disabledContentColor = Color(0xFFFFFFFF),
                            disabledContainerColor = Color(0xFFFFFFFF)
                        ),
                        shape = RoundedCornerShape(size = 7.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.baseline_bookmark_24),
                            contentDescription = "Salvar",
                            tint = colorResource(
                                id = R.color.salmao
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        )
                    }
                }
            }
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

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row {
                    ImagemUsuarioComponent(
                        24.dp,
                        24.dp,
                        3f,
                        Color.Red,
                        Color.Black,
                        0.dp
                    )

                    ImagemUsuarioComponent(
                        24.dp,
                        24.dp,
                        2f,
                        Color.Blue,
                        Color.Black,
                        -(20).dp
                    )

                    ImagemUsuarioComponent(
                        24.dp,
                        24.dp,
                        1f,
                        Color.Green,
                        Color.Black,
                        -(40).dp
                    )
                }
            }

            Column {
                Text(
                    text = "+5 Confirmados",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 19.24.sp,
                        fontFamily = andikaNewBasicFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF3F38DD),
                    ),
                    modifier = Modifier.offset(x = -(30).dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Icon(
                Icons.Default.LocationOn,
                contentDescription = "Localização",
                tint = colorResource(
                    id = R.color.cinza
                )
            )

            Text(
                text = "Av. Higienópolis, 257 - São P...",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = andikaNewBasicFont,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF2B2849),
                )
            )
        }
    }
}