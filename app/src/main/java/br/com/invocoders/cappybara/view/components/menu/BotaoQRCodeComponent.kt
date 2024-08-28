package br.com.invocoders.cappybara.view.components.menu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.MenuItem
import br.com.invocoders.cappybara.core.utils.mostrarMensagemEmConstrucao

@Composable
fun BotaoQRCodeComponent(item: MenuItem, navController: NavController) {
    val contexto = LocalContext.current

    Button(
        onClick = {
            if (!item.habilitado)
                mostrarMensagemEmConstrucao(contexto)
            else
                navController.navigate(item.nome)
        },
        shape = CircleShape,
        modifier = Modifier
            .then(
                Modifier
                    .size(50.dp)
                    .zIndex(1f)
                    .offset(y = (25).dp)
                    .shadow(8.dp, CircleShape, ambientColor = Color.Black)
            ),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            containerColor = colorResource(id = R.color.salmao)
        )
    ) {
        Icon(
            painter = painterResource(id = item.iconeId),
            contentDescription = item.descricaoIcone,
            tint = Color.White,
            modifier = Modifier
                .size(30.dp)
        )
    }
}
