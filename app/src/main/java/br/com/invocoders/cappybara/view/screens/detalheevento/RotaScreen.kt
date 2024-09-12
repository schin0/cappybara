package br.com.invocoders.cappybara.view.screens.detalheevento

import android.location.Location
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.invocoders.cappybara.BuildConfig
import br.com.invocoders.cappybara.R
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

    var modoTransporte by remember { mutableStateOf("driving") }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPosition,
            uiSettings = MapUiSettings(zoomControlsEnabled = false)
        ) {
            if (origem != null) {
                RotaComponent(
                    key = BuildConfig.MAPS_API_KEY,
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
                    },
                    modo = modoTransporte
                )
            }
        }

        val scrollState = rememberScrollState(0)

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .fillMaxWidth()
                .zIndex(2f),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { modoTransporte = "driving" },
                    modifier = Modifier.width(120.dp),
                    colors = ButtonColors(
                        containerColor = if (modoTransporte == "driving") Color(0xFF5669FF) else Color.White,
                        contentColor = if (modoTransporte == "driving") Color.White else Color.Gray,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_car_24),
                            contentDescription = "Carro",
                            tint = if (modoTransporte == "driving") Color.White else Color.Black
                        )
                        Text(text = "Carro")
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { modoTransporte = "walking" },
                    modifier = Modifier.width(120.dp),
                    colors = ButtonColors(
                        containerColor = if (modoTransporte == "walking") Color(0xFF5669FF) else Color.White,
                        contentColor = if (modoTransporte == "walking") Color.White else Color.Gray,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_walk_24),
                            contentDescription = "A pé",
                            tint = if (modoTransporte == "walking") Color.White else Color.Black
                        )
                        Text(text = "A pé")
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { modoTransporte = "transit" },
                    modifier = Modifier.width(150.dp),
                    colors = ButtonColors(
                        containerColor = if (modoTransporte == "transit") Color(0xFF5669FF) else Color.White,
                        contentColor = if (modoTransporte == "transit") Color.White else Color.Gray,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_bus_24),
                            contentDescription = "Transporte",
                            tint = if (modoTransporte == "transit") Color.White else Color.Black
                        )
                        Text(text = "Transporte")
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))
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