package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.model.Evento
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun MapaScreen(evento: Evento) {
    var mapaCarregado by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val posicaoCamera = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(evento.localizacao, 15f)
        }

        GoogleMap(
            modifier = Modifier
                .fillMaxSize(),
            onMapLoaded = { mapaCarregado = true },
            googleMapOptionsFactory = {
                GoogleMapOptions().mapId("mapa-evento-${evento.titulo}")
            },
            cameraPositionState = posicaoCamera,
        ) {
            Marker(
                state = rememberMarkerState(position = evento.localizacao),
                title = evento.titulo,
//                snippet = evento.localizacao.toString(),
                tag = evento,
                onClick = { marker ->
                    false
                },
            )
        }
    }
}

