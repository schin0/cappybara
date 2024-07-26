package br.com.invocoders.cappybara.screens.telabuscar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R

@Composable
fun TaBombandoScreen(){

     Column(modifier = Modifier.fillMaxWidth()) {
         Text(
             modifier = Modifier.padding(bottom = 8.dp),
             text = "Ta bombando!",
             style = TextStyle(
                 fontSize = 19.73.sp,
                 lineHeight = 17.54.sp,
                 fontWeight = FontWeight(700),
                 color = Color(0xFF464655),
             )
         )
         Row(modifier = Modifier.fillMaxWidth(),
             horizontalArrangement = Arrangement.SpaceAround){
             Card(
                 modifier = Modifier.height(150.dp)
                     .width(150.dp),
                 elevation = CardDefaults.cardElevation(8.dp),
                 shape = RoundedCornerShape(8.dp), // Define canto arredondado para o Card
                 colors = CardDefaults.cardColors(
                     containerColor = colorResource(id = R.color.azul),
                     contentColor = Color.Gray
                 )
             ){
                 Column(
                     modifier = Modifier.padding(8.dp),
                 ) {
                     Spacer(modifier = Modifier.height(80.dp))

                     Text(
                         text = "Top 10 Eventos",
                         style = TextStyle(
                             fontSize = 19.73.sp,
                             fontWeight = FontWeight(700),
                             color = Color(0xFFFFFFFF),
                             letterSpacing = 0.88.sp
                         )
                     )
                 }
             }


             Card(
                 modifier = Modifier.height(150.dp)
                     .width(150.dp),
                 elevation = CardDefaults.cardElevation(8.dp),
                 shape = RoundedCornerShape(8.dp), // Define canto arredondado para o Card
                 colors = CardDefaults.cardColors(
                     containerColor = colorResource(id = R.color.azul),
                     contentColor = Color.Gray
                 )

             ){
                 Column(
                     modifier = Modifier.padding(8.dp),
                 ) {
                     Spacer(modifier = Modifier.height(80.dp))

                     Text(
                         text = "Pra mim",
                         style = TextStyle(
                             fontSize = 19.73.sp,
                             fontWeight = FontWeight(700),
                             color = Color(0xFFFFFFFF),
                             letterSpacing = 0.88.sp
                         )
                     )
                 }
             }
         }
         Spacer(modifier = Modifier.height(15.dp))

         Row(modifier = Modifier.fillMaxWidth(),
             horizontalArrangement = Arrangement.SpaceAround) {
             Card(
                 modifier = Modifier.height(150.dp)
                     .width(150.dp),
                 elevation = CardDefaults.cardElevation(8.dp),
                 shape = RoundedCornerShape(8.dp), // Define canto arredondado para o Card
                 colors = CardDefaults.cardColors(
                     containerColor = colorResource(id = R.color.azul),
                     contentColor = Color.Gray
                 )

             ){
                 Column(
                     modifier = Modifier.padding(8.dp),
                 ) {
                     Spacer(modifier = Modifier.height(80.dp))

                     Text(
                         text = "Meus Amigos",
                         style = TextStyle(
                             fontSize = 19.73.sp,
                             fontWeight = FontWeight(700),
                             color = Color(0xFFFFFFFF),
                             letterSpacing = 0.88.sp
                         )
                     )
                 }
             }
             Card(
                 modifier = Modifier.height(150.dp)
                     .width(150.dp),
                 elevation = CardDefaults.cardElevation(8.dp),
                 shape = RoundedCornerShape(8.dp), // Define canto arredondado para o Card
                 colors = CardDefaults.cardColors(
                     containerColor = colorResource(id = R.color.azul),
                     contentColor = Color.Gray
                 )

             ){
                 Column(
                     modifier = Modifier.padding(8.dp),
                 ) {
                     Spacer(modifier = Modifier.height(80.dp))

                     896
                     Text(
                         text = "Favoritos dos Cappybaras",
                         style = TextStyle(
                             fontSize = 19.73.sp,
                             fontWeight = FontWeight(700),
                             color = Color(0xFFFFFFFF),
                             letterSpacing = 0.88.sp
                         )
                     )
                 }
             }
         }

     }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewRaBombandoScreen() {
    TaBombandoScreen()
}