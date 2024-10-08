package br.com.invocoders.cappybara.view.components.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.utils.mostrarMensagemEmConstrucao
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun BotaoMenuComponent(item: MenuItem, selecionado: Boolean, navController: NavController) {
    val contexto = LocalContext.current
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))

    Button(
        onClick = {
            if (!item.habilitado)
                mostrarMensagemEmConstrucao(contexto)
            else
                navController.navigate(item.nome)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = if (selecionado) item.iconeIdSelecionado else item.iconeId),
                contentDescription = item.descricaoIcone
            )

            Text(
                text = item.descricaoIcone,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(700),
                    color = colorResource(if (selecionado) R.color.azul else R.color.cinza),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
