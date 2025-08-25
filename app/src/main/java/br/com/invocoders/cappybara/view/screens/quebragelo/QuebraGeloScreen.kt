package br.com.invocoders.cappybara.view.screens.quebragelo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.view.components.quebragelo.BotaoEscreverPropriaComponent
import br.com.invocoders.cappybara.view.components.quebragelo.BotaoGerarNovaSugestaoComponent
import br.com.invocoders.cappybara.viewmodel.QuebraGeloViewModel

@Composable
fun QuebraGeloScreen(navController: NavController) {
    val contexto = LocalContext.current
    val roboto = FontFamily.Default
    val viewModel: QuebraGeloViewModel = viewModel()
    
    val ideias by viewModel.ideias
    val carregando by viewModel.carregando
    val erro by viewModel.erro
    val mensagemMotivacional by viewModel.mensagemMotivacional

    LaunchedEffect(erro) {
        if (erro != null) {
            viewModel.limparErro()
        }
    }

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
        
        if (ideias.isNotEmpty()) {
            val pagerState = rememberPagerState(pageCount = { ideias.size })
            
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
                        .height(350.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    pageSpacing = 16.dp,
                    flingBehavior = PagerDefaults.flingBehavior(state = pagerState)
                ) { page ->
                    val ideiaAtual = ideias[page]
                    
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
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
                    ideias.forEachIndexed { index, _ ->
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
        
        if (carregando) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = colorResource(id = R.color.azul)
                )
            }
        }
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BotaoGerarNovaSugestaoComponent(
                onClick = {
                    viewModel.gerarNovasIdeias()
                },
                habilitado = !carregando
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