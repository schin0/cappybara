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
import br.com.invocoders.cappybara.model.Categoria

@Composable
fun CategoriaComponent() {
    val categorias = listOf(
        Categoria("Esportes", R.drawable.baseline_sports_basketball_24),
        Categoria("Música", R.drawable.baseline_queue_music_24),
        Categoria("Arte", R.drawable.baseline_palette_24),
        Categoria("Comida", R.drawable.baseline_restaurant_menu_24),
        Categoria("Bebida", R.drawable.baseline_sports_bar_24)
    )

    val categoriasSelecionadas = remember { mutableStateListOf<Categoria>() }

    fun selecionar(categoria: Categoria) {
        if (categoriasSelecionadas.contains(categoria)) {
            categoriasSelecionadas.remove(categoria)
            return
        }
        categoriasSelecionadas.add(categoria)
    }

    LazyRow(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categorias) { categoria ->
            ItemCategoriaComponent(
                filtro = categoria.nome,
                selecionado = categoriasSelecionadas.contains(categoria),
                iconeId = categoria.iconeId,
                onClick = { selecionar(categoria) }
            )
        }
    }


}
