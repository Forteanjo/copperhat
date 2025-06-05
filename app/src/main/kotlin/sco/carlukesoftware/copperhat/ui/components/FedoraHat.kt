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
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun FedoraHat(
    modifier: Modifier = Modifier,
    zoomFactor: Float = 2f
) {
    Canvas(
        modifier = modifier
            .width(680.dp)
            .height(220.dp)
            .background(Color.Black)
    ) {
        val xp = 180
        val yp = 90
        val xr = PI * 1.5
        val xf = xr / xp
        val zf = xr / yp

        for (zi in -yp..yp) {
            val zt = zi.toDouble() * xp / yp
            val xl = (sqrt(abs(xp * xp - zt * zt)) + 0.5f).toInt()
            for (xi in -xl..xl) {
                val xt = sqrt(xi * xi + zt * zt) * xf
                val yy = (sin(xt) + sin(xt * 3) * 0.4) * yp
                val x1 = ((xi + zi + 140) / 2f).toFloat()
                val y1 = (yy - zi + 90).toFloat()

                drawPoints(
                    points = listOf(Offset(50 + x1, 340 - y1)),
                    pointMode = PointMode.Points,
                    color = Color.White,
                    strokeWidth = zoomFactor*1.5f

                )

                drawLine(
                    color = Color.Black,
                    start = Offset(50 + x1, 339 - y1),
                    end = Offset(50 + x1, 540f),
                    strokeWidth = zoomFactor
                )
            }
        }
    }
}

@Preview
@Composable
private fun FedoraHatPreview() {
    FedoraHat(
        zoomFactor = 1f
    )
}
