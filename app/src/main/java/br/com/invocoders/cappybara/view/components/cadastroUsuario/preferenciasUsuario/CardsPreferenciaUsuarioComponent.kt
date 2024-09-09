package br.com.invocoders.cappybara.view.components.cadastroUsuario.preferenciasUsuario

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.CategoriaEvento

@Composable
fun CardsPreferenciaUsuarioComponent(item: CategoriaEvento) {
    val imagens = listOf(
        R.drawable.verde,
        R.drawable.amarelo,
        R.drawable.preto,
        R.drawable.laranja,
        R.drawable.rosa
    )

    val imagemAleatoria = imagens.random()

    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imagemAleatoria),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = item.nome,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    }


}