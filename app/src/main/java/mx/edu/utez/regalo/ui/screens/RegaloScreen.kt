package mx.edu.utez.regalo.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.edu.utez.regalo.R
import mx.edu.utez.regalo.viewmodel.RegaloViewModel

@Composable
fun RegaloScreen(
    viewModel: RegaloViewModel = viewModel(),
    @DrawableRes idImagen: Int
){
    val isWrappedState = viewModel.isEnvuelto.collectAsState(initial=true)
    RegaloScreen(
        isEnvuelto = isWrappedState.value,
        envolverCaja = viewModel::envolverCaja,
        abrirCaja = viewModel::abrirCaja,
        idImagen = idImagen
    )
}


@Composable
fun RegaloScreen(
    isEnvuelto: Boolean,
    envolverCaja: () -> Unit,
    abrirCaja: () -> Unit,
    @DrawableRes idImagen: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    listOf(
                        Color(0xFFE3F2FD),
                        Color(0xFFEFEBE9)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (isEnvuelto) "🎄 ¡Tienes un regalo especial! 🎁" else "✨ ¡Sorpresa! ✨",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF37474F),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(320.dp)
                .shadow(14.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(id = idImagen),
                contentDescription = "Regalo revelado",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clickable {
                        if (!isEnvuelto) envolverCaja()
                    }
            )

            androidx.compose.animation.AnimatedVisibility(
                visible = isEnvuelto,
                exit = fadeOut(tween(800)) + scaleOut(tween(900), targetScale = 1.25f),
                modifier = Modifier.align(Alignment.Center)
            ) {
                CajaDeRegalo { abrirCaja() }
            }

            if (!isEnvuelto) {
                Text(
                    text = "Presiona el regalo para volver a envolverlo 🎁",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(12.dp)
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun RegaloScreenEnvueltoPreview(){
    RegaloScreen(
        isEnvuelto = true,
        envolverCaja = {},
        abrirCaja = {},
        idImagen = R.drawable.freddy)
}


@Composable
@Preview(showBackground = true)
fun RegaloScreenAbiertoPreview(){
    RegaloScreen(
        isEnvuelto = false,
        envolverCaja = {},
        abrirCaja = {},
        idImagen = R.drawable.freddy)
}