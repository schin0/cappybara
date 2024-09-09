package br.com.invocoders.cappybara.view.components.cadastroUsuario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LinhasCarregamento(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(4.dp)
                .background(Color(0xFF586BFF))
        )

        Spacer(modifier = Modifier.width(15.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .height(4.dp)
                .background(Color.Gray)
        )
    }

}