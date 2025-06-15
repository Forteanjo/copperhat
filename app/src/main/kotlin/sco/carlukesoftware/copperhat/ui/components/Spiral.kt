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

/**
 * A Composable function that draws a spiral pattern on a Canvas.
 *
 * The spiral is drawn by iteratively calculating points along the curve
 * using polar coordinates (radius `r` and angle `theta`).
 * The radius and angle are incremented in a loop until the radius
 * reaches a predefined limit.
 *
 * The Canvas is set to a fixed width of 680.dp and height of 220.dp
 * with a black background. The spiral itself is drawn in white.
 *
 * @param modifier Modifier to be applied to the Canvas.
 */
@Composable
fun Spiral(
    modifier: Modifier = Modifier,
    spiralStep: Float = 0.08f
) {
    Canvas(
        modifier = modifier
            .width(680.dp)
            .height(220.dp)
            .background(Color.Black)
    ) {
        val xc = size.width / 2f
        val yc = size.height / 2f

        var r = 0f
        var theta = 0f

        val points = mutableListOf<Offset>()

        while (r < 239f) {
            val x = xc + r * cos(theta)
            val y = yc + r * sin(theta)
            points.add(Offset(x, y))

            r += spiralStep
            theta = r
        }

        drawPoints(
            points = points,
            pointMode = PointMode.Points,
            color = Color.White,
            strokeWidth = 2f
        )

    }
}

@Preview
@Composable
private fun SpiralPreview() {
    CopperHatTheme {
        Spiral()
    }
}
