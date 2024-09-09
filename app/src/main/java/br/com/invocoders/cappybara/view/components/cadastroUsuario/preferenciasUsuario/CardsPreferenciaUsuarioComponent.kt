package br.com.invocoders.cappybara.view.components.cadastroUsuario.preferenciasUsuario

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.model.CategoriaEvento

@Composable
fun CardsPreferenciaUsuarioComponent(item: CategoriaEvento){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = item.nome, style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }
    }
}