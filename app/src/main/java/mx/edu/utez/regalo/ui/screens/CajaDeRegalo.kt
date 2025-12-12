package mx.edu.utez.regalo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.regalo.ui.theme.RegaloNavidadTheme

@Composable
fun CajaDeRegalo(
    abrir: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(280.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(Color(0xFFFDF7F7)) // suave crema como papel del regalo
            .shadow(16.dp, RoundedCornerShape(22.dp))
            .clickable { abrir() }
    ) {

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFAE2E2),
                            Color(0xFFF6CFCF),
                            Color(0xFFF4BFBF)
                        )
                    )
                )
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(36.dp)
                .align(Alignment.Center)
                .background(
                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                        listOf(
                            Color(0xFFD81B60),
                            Color(0xFFE91E63),
                            Color(0xFFFF6384)
                        )
                    )
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .align(Alignment.Center)
                .background(
                    brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                        listOf(
                            Color(0xFFD81B60),
                            Color(0xFFE91E63),
                            Color(0xFFFF6384)
                        )
                    )
                )
        )
        Surface(
            shape = RoundedCornerShape(50),
            color = Color(0xFFE91E63),
            shadowElevation = 12.dp,
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.Center)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "\uD83C\uDF81",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
            }
        }
    }
}


@Preview (showBackground = true)
@Composable
fun CajaDeRegaloEnvueltoPreview(){
    RegaloNavidadTheme {
        CajaDeRegalo{}
    }
}