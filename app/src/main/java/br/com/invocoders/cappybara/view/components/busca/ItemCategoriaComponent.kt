package br.com.invocoders.cappybara.view.components.busca

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ItemCategoriaComponent(filtro: String, selecionado: Boolean, iconeId: Int, onClick: () -> Unit) {
    val corFundo by animateColorAsState(
        if (selecionado) Color(0xFF6F7CF5) else Color(0xFFF0F0F0), label = ""
    )
    val corIcone by animateColorAsState(
        if (selecionado) Color.White else Color.Gray, label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(onClick = onClick)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(corFundo, shape = CircleShape)
                .padding(16.dp),
        ) {
            Icon(
                painter = painterResource(id = iconeId),
                contentDescription = null,
                tint = corIcone,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = filtro,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }

}
