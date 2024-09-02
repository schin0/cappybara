package br.com.invocoders.cappybara.view.screens.detalheevento

import android.location.Location
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.core.services.LocalizacaoService
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import br.com.invocoders.cappybara.view.components.home.CardEventoPertoComponent
import br.com.invocoders.cappybara.view.components.rotas.RotaComponent
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun RotaScreen(
    eventoDetalhe: EventoDetalhe,
    navController: NavController
) {
    val context = LocalContext.current
    var endereco by remember { mutableStateOf<Location?>(null) }
    var tempoRota by remember { mutableStateOf<String?>(null) }
    var distanciaRota by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        val localizacaoAtual = withContext(Dispatchers.Main) {
            LocalizacaoService(context).obterLocalizacaoAtual(context)
        }

        endereco = localizacaoAtual
    }

    val origem = endereco?.latitude?.let { endereco?.longitude?.let { it1 -> LatLng(it, it1) } }
    val destino = LatLng(eventoDetalhe.latitude, eventoDetalhe.longitude)
    val cameraPosition = rememberCameraPositionState()

    LaunchedEffect(origem, destino) {
        if (origem != null) {
            val midLat = (origem.latitude + destino.latitude) / 2
            val midLng = (origem.longitude + destino.longitude) / 2

            cameraPosition.position = CameraPosition.fromLatLngZoom(
                LatLng(midLat, midLng),
                10f
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPosition,
            uiSettings = MapUiSettings(zoomControlsEnabled = false)
        ) {
            if (origem != null) {
                RotaComponent(
                    key = "API_KEY",
                    localizacaoAtual = origem,
                    localizacaoEvento = destino,
                    deveConsiderarMarcadorInicial = true,
                    deveConsiderarMarcadorDestino = true,
                    clickable = true,
                    onTempoRotaChange = { tempo ->
                        tempoRota = tempo
                    },
                    onDistanciaRotaChange = { distancia ->
                        distanciaRota = distancia
                    }
                )
            }
        }

        val eventoResumo = EventoResumo(
            eventoDetalhe.id,
            eventoDetalhe.titulo,
            eventoDetalhe.latitude,
            eventoDetalhe.longitude,
            eventoDetalhe.dataHoraInicio,
            eventoDetalhe.imagens
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            CardEventoPertoComponent(eventoResumo, navController, tempoRota, distanciaRota)
        }

    }

}