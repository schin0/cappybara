package br.com.invocoders.cappybara.view.screens.detalheevento

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun MapaScreen(evento: EventoDetalhe) {
    var mapaCarregado by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (evento.latitude != 0.0 && evento.longitude != 0.0) {

            val posicaoCamera = rememberCameraPositionState {
                position =
                    CameraPosition.fromLatLngZoom(LatLng(evento.latitude, evento.longitude), 15f)
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
                    state = rememberMarkerState(
                        position = LatLng(
                            evento.latitude,
                            evento.longitude
                        )
                    ),
                    title = evento.titulo,
                    tag = evento,
                    onClick = { marker ->
                        false
                    },
                )
            }
        }
    }

}

