package br.com.invocoders.cappybara.view.components.busca

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.core.services.listarCategoriaEvento
import br.com.invocoders.cappybara.model.CategoriaEvento

@Composable
fun CategoriaComponent(onCategoriasSelecionadas: (List<CategoriaEvento>) -> Unit) {
    val lista = listarCategoriaEvento()
    val categoriasSelecionadas = remember { mutableStateListOf<CategoriaEvento>() }

    fun selecionar(categoria: CategoriaEvento) {
        if (categoriasSelecionadas.contains(categoria)) {
            categoriasSelecionadas.remove(categoria)
        } else {
            categoriasSelecionadas.add(categoria)
        }
        onCategoriasSelecionadas(categoriasSelecionadas.toList())
    }

    LazyRow(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(lista) { categoria ->
            ItemCategoriaComponent(
                filtro = categoria.nome,
                selecionado = categoriasSelecionadas.contains(categoria),
                iconeId = obterIcone(categoria.nome),
                onClick = { selecionar(categoria) }
            )
        }
    }

}

fun obterIcone(descricaoCategoria: String): Int {
    return when (descricaoCategoria) {
        "Teatro" -> R.drawable.baseline_theater_comedy_24
        "Caridade" -> R.drawable.baseline_favorite_24
        "Concerto" -> R.drawable.baseline_music_note_24
        "Webinar" -> R.drawable.baseline_ondemand_video_24
        "Dança" -> R.drawable.baseline_accessibility_new_24

        else -> R.drawable.baseline_sports_bar_24
    }
}