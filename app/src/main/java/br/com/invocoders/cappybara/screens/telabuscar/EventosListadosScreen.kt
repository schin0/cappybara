package br.com.invocoders.cappybara.screens.telabuscar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R

@Composable
fun EventosListadosScreen(){
    Column {
        Row(modifier = Modifier) {
            Card(
                modifier = Modifier.padding(end = 15.dp),
                elevation = CardDefaults.cardElevation(8.dp),

                shape = RoundedCornerShape(8.dp) // Define canto arredondado para o Card

            ){
                Image(
                    painter = painterResource(R.drawable.next2023),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(120.dp)
                        .width(90.dp)
                )

            }
            Column() {

                Text(
                    text = "11 JUL - QUI - 15h00",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFEE544A),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.width(200.dp),
                    text = "Bar do Alemão - Samba ao vivo",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 25.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF120D26),
                    )
                )
            }



        }
    }

    Spacer(modifier = Modifier.height(26.dp))

    Column {
        Row(modifier = Modifier) {
            Card(
                modifier = Modifier.padding(end = 15.dp),
                elevation = CardDefaults.cardElevation(8.dp),

                shape = RoundedCornerShape(8.dp) // Define canto arredondado para o Card

            ){
                Image(
                    painter = painterResource(R.drawable.next2023),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(120.dp)
                        .width(90.dp)
                )

            }
            Column() {

                Text(
                    text = "11 JUL - QUI - 15h00",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFEE544A),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.width(200.dp),
                    text = "Respire-Aula de Yoga ao vivo",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 25.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF120D26),
                    )
                )
            }



        }
    }
}