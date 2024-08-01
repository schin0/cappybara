package br.com.invocoders.cappybara.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.services.LocalizacaoService
import br.com.invocoders.cappybara.services.obterEnderecoTexto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun CabecalhoComponent() {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardColors(
            containerColor = colorResource(id = R.color.azul),
            contentColor = Color.White,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.White,
        ),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomEnd = 33.dp,
            bottomStart = 33.dp
        )
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                var endereco by remember { mutableStateOf("Carregando...") }
                val scope = rememberCoroutineScope()
                val context = LocalContext.current

                LaunchedEffect(Unit) {
                    val localizacaoAtual = withContext(Dispatchers.Main) {
                        LocalizacaoService(context).obterLocalizacaoAtual(context)
                    }

                    localizacaoAtual?.let {
                        scope.launch {
                            endereco = obterEnderecoTexto(it.latitude, it.longitude)
                        }
                    }
                }

                Text(
                    text = endereco,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = -(20).dp)
                    .padding(end = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(Icons.Default.Notifications, contentDescription = "Notificações")
            }
        }
    }
}
