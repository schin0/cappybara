package br.com.invocoders.cappybara.view.components.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.data.model.ArtistaInfo
import coil.compose.AsyncImage

@Composable
fun ArtistaInfoComponent(artistaInfo: ArtistaInfo) {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardColors(
            containerColor = Color(0xFFF8F9FA),
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Cabeçalho do Artista
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Foto do Artista
                    if (artistaInfo.imagens.isNotEmpty()) {
                        AsyncImage(
                            model = artistaInfo.imagens.first(),
                            contentDescription = "Foto do ${artistaInfo.nome}",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE0E0E0)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = artistaInfo.nome.take(1).uppercase(),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = roboto,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF757575)
                                )
                            )
                        }
                    }
                    
                    Column {
                        Text(
                            text = artistaInfo.nome,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = roboto,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF120D26)
                            )
                        )
                        
                        Text(
                            text = if (artistaInfo.tipo == "attraction") "Atração" else artistaInfo.tipo,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = roboto,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF757575)
                            )
                        )
                    }
                }
                
            }
            
            // Classificações do Artista
            if (artistaInfo.classificacoes.isNotEmpty()) {
                val classificacao = artistaInfo.classificacoes.first()
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Gênero:",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF757575)
                        )
                    )
                    Text(
                        text = "${classificacao.genero.nome} - ${classificacao.subGenero.nome}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF120D26)
                        )
                    )
                }
            }
            
            
            // Próximos Eventos
            if (artistaInfo.proximosEventos.total > 0) {
                Text(
                    text = "Próximos eventos: ${artistaInfo.proximosEventos.total}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF5669FF)
                    )
                )
            }
        }
    }
}

