package br.com.invocoders.cappybara.view.components.rotas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.invocoders.cappybara.viewmodel.RotaViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.ButtCap
import com.google.android.gms.maps.model.Cap
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PatternItem
import com.google.android.gms.maps.model.Polyline
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun RotaComponent(
    key: String,
    localizacaoAtual: LatLng,
    localizacaoEvento: LatLng,
    clickable: Boolean = false,
    colors: List<Color>? = null,
    endCap: Cap = ButtCap(),
    geodesic: Boolean = false,
    jointType: Int = JointType.DEFAULT,
    pattern: List<PatternItem>? = null,
    startCap: Cap = ButtCap(),
    visible: Boolean = true,
    width: Float = 10f,
    zIndex: Float = 0f,
    onClick: (Polyline) -> Unit = {},
    deveConsiderarMarcadorInicial: Boolean = false,
    deveConsiderarMarcadorDestino: Boolean = false,
    tituloOrigem: String = "",
    tituloDestino: String = "",
    snippetOrigem: String? = null,
    snippetDestino: String? = null,
    deveConsiderarAlternativas: Boolean = false
) {
    val rotaCores = colors ?: listOf(Color.Blue, Color.Red, Color.Green, Color.Magenta)
    val apiService: RotaViewModel = viewModel()
    val rotas by apiService.rotas.observeAsState()
    apiService.obterRota(key, localizacaoAtual, localizacaoEvento, deveConsiderarAlternativas)

    val marcadorDestinoState = rememberMarkerState(position = localizacaoEvento)
    val marcadorInicialState = rememberMarkerState(position = localizacaoAtual)

    marcadorDestinoState.showInfoWindow()
    marcadorInicialState.showInfoWindow()

    if (deveConsiderarMarcadorInicial) {
        Marker(
            state = marcadorInicialState,
            title = tituloOrigem,
            onClick = {
                marcadorInicialState.showInfoWindow()
                true
            },
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE),
            snippet = snippetOrigem
        )
    }

    if (deveConsiderarMarcadorDestino) {
        Marker(
            state = marcadorDestinoState,
            title = tituloDestino,
            onClick = {
                marcadorDestinoState.showInfoWindow()
                true
            },
            snippet = snippetDestino,
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
        )
    }

    if (rotas != null) {
        rotas!!.indices.forEach {
            Polyline(
                points = rotas!![it],
                color = rotaCores[it % rotaCores.size],
                clickable = clickable,
                endCap = endCap,
                geodesic = geodesic,
                jointType = jointType,
                pattern = pattern,
                startCap = startCap,
                visible = visible,
                width = width,
                zIndex = zIndex,
                onClick = onClick
            )
        }
    }

}
