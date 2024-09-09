package br.com.invocoders.cappybara.core.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.invocoders.cappybara.model.CategoriaEvento
import br.com.invocoders.cappybara.viewmodel.PreferenciaViewModel


@Composable
fun listarCategoriaEvento(categoriaViewModel: PreferenciaViewModel = viewModel()): List<CategoriaEvento> {
    val categoria by categoriaViewModel.categoriaEvento

    LaunchedEffect(Unit) {
        categoriaViewModel.listarCategoriaEvento()
    }

    if (categoria.isNotEmpty())
        return categoria

    return emptyList()
}