package br.com.invocoders.cappybara.view.components.quebragelo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.model.IdeiaQuebraGelo

@Composable
fun CarrosselIdeiasComponent(
    ideias: List<IdeiaQuebraGelo>,
    indiceAtual: Int,
    onIndiceMudou: (Int) -> Unit
) {
    val roboto = FontFamily.Default
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (ideias.isNotEmpty()) {
            val ideiaAtual = ideias[indiceAtual]
            
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(android.graphics.Color.parseColor(ideiaAtual.corFundo))
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = ideiaAtual.categoria,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = ideiaAtual.pergunta,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            textAlign = TextAlign.Start
                        )
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ideias.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(8.dp)
                            .background(
                                color = if (index == indiceAtual) Color.Gray else Color.LightGray,
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (indiceAtual > 0) {
                            onIndiceMudou(indiceAtual - 1)
                        }
                    },
                    enabled = indiceAtual > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = if (indiceAtual > 0) Color.Gray else Color.LightGray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Anterior")
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Button(
                    onClick = {
                        if (indiceAtual < ideias.size - 1) {
                            onIndiceMudou(indiceAtual + 1)
                        }
                    },
                    enabled = indiceAtual < ideias.size - 1,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = if (indiceAtual < ideias.size - 1) Color.Gray else Color.LightGray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Próxima")
                }
            }
        }
    }
} 