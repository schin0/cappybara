package br.com.invocoders.cappybara.view.screens.quebragelo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.IdeiaQuebraGelo
//import br.com.invocoders.cappybara.view.components.shared.BotaoVoltarComponent
import br.com.invocoders.cappybara.view.components.quebragelo.BotaoGerarNovaSugestaoComponent
import br.com.invocoders.cappybara.view.components.quebragelo.BotaoEscreverPropriaComponent

@Composable
fun QuebraGeloScreen(navController: NavController) {
    val contexto = LocalContext.current
    val roboto = FontFamily.Default
    
    val ideiasMock = remember {
        listOf(
            IdeiaQuebraGelo(
                categoria = "Crescimento Pessoal",
                pergunta = "Qual é uma habilidade que você adoraria aprender e por quê?",
                corFundo = "#FF6B9D"
            ),
            IdeiaQuebraGelo(
                categoria = "Viagens",
                pergunta = "Se você pudesse viajar para qualquer lugar do mundo amanhã, para onde iria?",
                corFundo = "#4ECDC4"
            ),
            IdeiaQuebraGelo(
                categoria = "Sonhos",
                pergunta = "Qual é o seu maior sonho que ainda não realizou?",
                corFundo = "#45B7D1"
            ),
            IdeiaQuebraGelo(
                categoria = "Música",
                pergunta = "Qual música sempre te anima, não importa o seu humor?",
                corFundo = "#96CEB4"
            ),
            IdeiaQuebraGelo(
                categoria = "Comida",
                pergunta = "Qual é a refeição mais memorável que você já teve?",
                corFundo = "#FFEAA7"
            )
        )
    }
    
    var ideiasAtuais by remember { mutableStateOf(ideiasMock) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .padding(0.dp)
                        .width(40.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(size = 7.dp),
                    colors = CardColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = Color.Transparent
                    ),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Quebra-gelo",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = "Comece uma nova Conexão com IA",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.azul),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Use estas sugestões para iniciar conversas significativas e encontrar pontos em comum para o seu próximo encontro presencial.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        if (ideiasAtuais.isNotEmpty()) {
            val pagerState = rememberPagerState(pageCount = { ideiasAtuais.size })
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    pageSpacing = 16.dp,
                    flingBehavior = PagerDefaults.flingBehavior(state = pagerState)
                ) { page ->
                    val ideiaAtual = ideiasAtuais[page]
                    
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(horizontal = 8.dp),
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
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ideiasAtuais.forEachIndexed { index, _ ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(8.dp)
                                .background(
                                    color = if (pagerState.currentPage == index) Color.Gray else Color.LightGray,
                                    shape = RoundedCornerShape(4.dp)
                                )
                        )
                    }
                }
            }
        }
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BotaoGerarNovaSugestaoComponent(
                onClick = {
                    val novaIdeia = gerarNovaIdeia()
                    ideiasAtuais = ideiasAtuais + novaIdeia
                }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            BotaoEscreverPropriaComponent(
                onClick = {
                    // TODO: Implementar funcionalidade para escrever própria sugestão
                }
            )
        }
    }
}

private fun gerarNovaIdeia(): IdeiaQuebraGelo {
    val categorias = listOf(
        "Hobbies" to "Qual hobby você gostaria de experimentar se tivesse tempo ilimitado?",
        "Filmes" to "Qual filme você assistiria repetidamente e por quê?",
        "Tecnologia" to "Qual invenção tecnológica mudou mais a sua vida?",
        "Natureza" to "Qual é o lugar mais bonito da natureza que você já visitou?",
        "Aprendizado" to "Qual foi a lição mais importante que você aprendeu este ano?"
    )
    
    val cores = listOf("#FF6B9D", "#4ECDC4", "#45B7D1", "#96CEB4", "#FFEAA7", "#DDA0DD", "#98D8C8")
    
    val categoriaEscolhida = categorias.random()
    val corEscolhida = cores.random()
    
    return IdeiaQuebraGelo(
        categoria = categoriaEscolhida.first,
        pergunta = categoriaEscolhida.second,
        corFundo = corEscolhida
    )
} 