package br.com.invocoders.cappybara.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import kotlinx.coroutines.delay


@Composable
fun InicioAppSreen(navController: NavController) {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500) // Espera 500ms antes de iniciar a animação
        visible.value = true
        delay(1500)
        navController.navigate("login")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(1000)) + scaleIn(animationSpec = tween(1000), initialScale = 0.5f)

        ) {
            Column (
                modifier = Modifier
                    .size(200.dp)
                    .scale(1.2f), // Tamanho final após a animação
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                )

                val gradientColors = listOf(Color(0xFFFFA68D), Color(0xFFFD3A84))
                val brush = Brush.linearGradient(colors = gradientColors)
                // Conteúdo da tela inicial
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(brush = brush)) {
                            append("Cappybara")
                        }
                    },
                    style = TextStyle(
                        fontSize = 35.sp,
                        lineHeight = 48.37.sp,
                        // fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFA68D),

                        textAlign = TextAlign.Center,
                    )
                )

            }
        }
    }
}

