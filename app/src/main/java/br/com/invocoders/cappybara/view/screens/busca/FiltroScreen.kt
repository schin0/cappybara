package br.com.invocoders.cappybara.view.screens.busca

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.data.model.FiltroEvento
import br.com.invocoders.cappybara.model.CategoriaEvento
import br.com.invocoders.cappybara.view.components.busca.CategoriaComponent
import br.com.invocoders.cappybara.view.components.busca.SelecaoDataComponent
import br.com.invocoders.cappybara.view.components.busca.SelecaoFaixaPrecoComponent
import br.com.invocoders.cappybara.view.components.busca.SelecaoLocalizacaoComponent
import com.google.gson.Gson

@Composable
fun FiltroScreen(navController: NavController) {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))

    var categoriasSelecionadas by remember { mutableStateOf<List<CategoriaEvento>>(emptyList()) }
    var data by remember { mutableStateOf("") }
    val valorMinimo by remember { mutableFloatStateOf(20f) }
    var valorMaximo by remember { mutableFloatStateOf(120f) }

    fun aplicarFiltros() {
        val filtroBusca =
            FiltroEvento(categoriasSelecionadas.map { it.id }, valorMinimo, valorMaximo, data)
        val jsonFiltro = Gson().toJson(filtroBusca)

        navController.navigate("retornoBusca/?filtroEvento=$jsonFiltro")
    }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(top = 0.dp, start = 20.dp, end = 0.dp, bottom = 30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Filtros",
                style = TextStyle(
                    fontSize = 25.sp,
                    lineHeight = 33.33.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(900),
                    color = Color(0xFF000000),
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            CategoriaComponent(onCategoriasSelecionadas = { selecionadas ->
                categoriasSelecionadas = selecionadas
            })
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Data e horário",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 34.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF120D26),
                )
            )
        }

        SelecaoDataComponent(onDataSelecionada = { dataSelecionada ->
            data = dataSelecionada
        })

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Localização",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 34.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF120D26),
                )
            )
        }

        SelecaoLocalizacaoComponent()

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Faixa de Preço",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 34.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF120D26),
                )
            )
        }

        SelecaoFaixaPrecoComponent(onPrecoSelecionado = { preco ->
            valorMaximo = preco
        })

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = { /* TODO: ação de limpar filtros */ },
                border = BorderStroke(1.dp, Color(0xFFD0D0D0)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("LIMPAR")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    aplicarFiltros()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF65A38),
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("APLICAR")
            }
        }


    }

}

