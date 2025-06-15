package sco.carlukesoftware.copperhat.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sco.carlukesoftware.copperhat.ui.theme.CopperHatTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Spiral(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .width(680.dp)
            .height(220.dp)
            .background(Color.Black)
    ) {
        val xc = size.width / 2f
        val yx = size.height / 2f

        var r = 0f
        var theta = 0f
        var c = 0f

        while (r < 239f) {
            val x = xc + r * cos(theta)
            val y = yx + r * sin(theta)

            drawPoints(
                points = listOf(Offset(x, y)),
                pointMode = PointMode.Points,
                color = Color.White,
                strokeWidth = 1f
            )

            c += 0.01f
            r += 0.01f
            theta = c
        }
    }
}

@Preview
@Composable
private fun SpiralPreview() {
    CopperHatTheme {
        Spiral()
    }
}
