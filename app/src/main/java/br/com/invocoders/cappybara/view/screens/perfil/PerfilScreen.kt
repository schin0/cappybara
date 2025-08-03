package br.com.invocoders.cappybara.view.screens.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.model.PerfilUsuario
import br.com.invocoders.cappybara.view.components.perfil.BotaoCappyCodeComponent
import br.com.invocoders.cappybara.view.components.perfil.BotaoEditarPerfilComponent
import br.com.invocoders.cappybara.view.components.perfil.InfoPerfilComponent
import br.com.invocoders.cappybara.view.components.perfil.InteressesComponent
import br.com.invocoders.cappybara.view.components.perfil.StatisticasComponent

@Composable
fun PerfilScreen(navController: NavController) {
    val perfilMock = remember {
        PerfilUsuario(
            nome = "David Batista",
            conexoes = 350,
            eventos = 36,
            interesses = listOf("Games Online", "Shows", "Música", "Arte", "Filmes", "Outros"),
            descricao = "Sou o David! Curioso por tudo que envolve som, arte e diversão. Se tiver um bom show ou um game desafiador, tô dentro!"
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.navigateUp() }
            ) {
                            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color.Black
            )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Perfil",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        InfoPerfilComponent(perfil = perfilMock)
        
        Spacer(modifier = Modifier.height(24.dp))
        
        StatisticasComponent(
            conexoes = perfilMock.conexoes,
            eventos = perfilMock.eventos
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            BotaoCappyCodeComponent(
                texto = "Meu Cappy\nCode",
                onClick = { /* TODO: Implementar funcionalidade */ },
                modifier = Modifier.weight(1f)
            )
            
            BotaoCappyCodeComponent(
                texto = "Scan Cappy\nCode",
                onClick = { /* TODO: Implementar funcionalidade */ },
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        InteressesComponent(interesses = perfilMock.interesses)
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Text(
                text = perfilMock.descricao,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        BotaoEditarPerfilComponent(
            onClick = { /* TODO: Implementar edição de perfil */ }
        )
    }
} 