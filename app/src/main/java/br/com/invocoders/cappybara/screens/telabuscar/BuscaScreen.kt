package br.com.invocoders.cappybara.screens.telabuscar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.screens.MenuScreenNovo

@Composable
fun BuscaScreen(navController: NavController) {
    val scrollState = rememberScrollState(0)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 64.dp)
            .verticalScroll(scrollState),
    ) {

        Row(modifier = Modifier.padding()) {
            Image(
                painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Ícone de seta",
                modifier = Modifier
                    .size(25.dp, 25.dp)

                    .clickable {

                    }
            )
            Text(
                text = "Buscar",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF120D26),
                )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Ícone de seta",
                modifier = Modifier
                    .size(33.dp, 33.dp)
                    .clickable {

                    }
            )
            TextField(
                value = "",
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black, // Cor do texto quando o campo está focado
                    unfocusedTextColor = Color.Black, // Cor do texto quando o campo não está focado
                    focusedContainerColor = Color.White, // Cor de fundo quando o campo está focado
                    unfocusedContainerColor = Color.White, // Cor de fundo quando o campo não está focado
                    focusedIndicatorColor = Color.Blue, // Cor da linha de indicador quando o campo está focado
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha de indicador quando o campo não está focado
                    cursorColor = Color.Blue // Cor do cursor
                ),
                onValueChange = {

                },
                modifier = Modifier
                    .width(240.dp)
                    .height(60.dp), // Ajuste a altura conforme necessário
                placeholder = { Text("Eventos, Lugares ...") },
                singleLine = true,
                maxLines = 1
            )

            Button(
                onClick = {

                },

                modifier = Modifier
                    .width(90.dp)
                    .height(32.1428.dp)

            ) {
                //Icon(Icons.Default.Edit, contentDescription = "Check Icon", modifier = Modifier.padding(end = 2.dp))
                Text(
                    text = "Filtros",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFECEBFC),

                        )
                )

            }


        }

        Spacer(modifier = Modifier.height(32.dp))

        EventosListadosScreen()

        Spacer(modifier = Modifier.height(18.dp))

        TaBombandoScreen()


    }
    MenuScreenNovo(navController, "buscar")
}




