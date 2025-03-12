package sco.carlukesoftware.copperhat.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CopperHat(
    modifier: Modifier = Modifier,
    zoomFactor: Float = 2f
) {
    Canvas(
        modifier = modifier
            .width(680.dp)
            .height(220.dp)
            .background(Color.Black)
    ) {
        val degreesToRadians = (PI / 180).toFloat()
        val rotationAngleRadians = 15 * degreesToRadians
        val centerX = size.width / 2 //Center of the Canvas
        val centerY = size.height / 2 //Center of the Canvas
        val maxRadius = 320

        // Use a Sequence for Lazy Computation
        val pointsSequence = sequence {
            for (radius in 30 until maxRadius) {
                for (theta in 0 until 360) {
                    val thetaRadians = theta * degreesToRadians

                    val x = (radius * cos(thetaRadians) * 0.5f)
                    val y = (radius * sin(radius * degreesToRadians) / PI).toFloat()
                    val z = (radius * sin(thetaRadians) * 0.5f)

                    val projectedX = ((x + (cos(rotationAngleRadians) * z)) * zoomFactor).toInt() + centerX
                    val projectedY = centerY - ((y + (sin(rotationAngleRadians) * z)) * zoomFactor).toInt()

                    yield(Offset(projectedX, projectedY))
                }
            }
        }

        // Draw Only Once and use toList()
        val points = pointsSequence.toList()
        drawPoints(
            points = points,
            pointMode = PointMode.Points,
            color = Color.White,
            strokeWidth = zoomFactor
        )
    }

}

@Preview
@Composable
private fun CopperHatPreview() {
    CopperHat()
}
