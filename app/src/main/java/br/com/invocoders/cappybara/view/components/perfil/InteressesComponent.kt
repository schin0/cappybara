package br.com.invocoders.cappybara.view.components.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InteressesComponent(interesses: List<String>) {
    Column {
        Text(
            text = "Interesses",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        val cores = listOf(
            Color(0xFFE1BEE7), // Games Online - roxo claro
            Color(0xFFFFCDD2), // Shows - vermelho claro
            Color(0xFFFFE0B2), // Música - laranja claro
            Color(0xFFC8E6C9), // Arte - verde claro
            Color(0xFFBBDEFB), // Filmes - azul claro
            Color(0xFFE3F2FD)  // Outros - azul muito claro
        )
        
        val interessesComCores = interesses.zip(cores)
        
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Primeira linha
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                interessesComCores.take(4).forEach { (interesse, cor) ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = cor,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = interesse,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            
            // Segunda linha
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                interessesComCores.drop(4).forEach { (interesse, cor) ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = cor,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = interesse,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
} 