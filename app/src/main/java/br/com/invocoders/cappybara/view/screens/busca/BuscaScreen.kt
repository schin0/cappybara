package br.com.invocoders.cappybara.view.screens.busca

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.view.components.home.EventosPertoDeMimComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscaScreen(navController: NavController) {
    val scrollState = rememberScrollState(0)
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))
    var showDefault by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
            .verticalScroll(scrollState),
    ) {
        Row(modifier = Modifier.padding()) {
            Image(
                painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Ícone de seta",
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = "Buscar",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF120D26),
                ),
                modifier = Modifier.padding(horizontal = 11.dp)
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
                    .clickable { }
            )
            TextField(
                value = "",
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Blue
                ),
                onValueChange = { },
                modifier = Modifier
                    .width(220.dp)
                    .height(60.dp),
                placeholder = { Text("Eventos, Lugares ...") },
                singleLine = true,
                maxLines = 1
            )

            Button(
                onClick = {
                    showDefault = true
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(35.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.salmao),
                    contentColor = Color.White
                ),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(Icons.Default.Menu, contentDescription = "EAE", tint = Color.White)

                    Text(
                        text = "Filtros",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFECEBFC),
                        )
                    )
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            FiltroModal(
                showSheet = showDefault,
                onDismissRequest = { showDefault = false }
            ) {
                FiltroScreen(navController)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        EventosPertoDeMimComponent(navController, 2)

        Spacer(modifier = Modifier.height(18.dp))

        TaBombandoScreen()
    }
}
