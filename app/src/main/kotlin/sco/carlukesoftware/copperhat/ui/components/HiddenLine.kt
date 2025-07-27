package sco.carlukesoftware.copperhat.ui.components

import android.R.attr.x
import android.R.attr.y
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sco.carlukesoftware.copperhat.ui.theme.CopperHatTheme
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt

private const val TARGET_X = 7f
private const val TARGET_Y = 13f
private const val Z_BUFFER_WIDTH = 630 // Should ideally match canvas pixel width
private const val Z_BUFFER_INITIAL_Y = 320f
private const val CANVAS_WIDTH_DP = 680
private const val CANVAS_HEIGHT_DP = 220

/**
 * Renders a 2D projection of lines with a simple hidden line removal effect.
 * Points further "behind" existing points on the same vertical scanline are not drawn.
 *
 * @param modifier Modifier for styling and layout.
 */
@Composable
fun HiddenLine(
    modifier: Modifier = Modifier
) {
    val visibilityBuffer = remember { // Or manage in a separate class
        FloatArray(Z_BUFFER_WIDTH) { Z_BUFFER_INITIAL_Y }
    }

    /**
     * Calculate the Euclidean distance between two points (start(x, y)) and
     * (end(x, y)) in a 2D space.
     *
     * @param start The starting point (Offset)
     * @param end The ending point (Offset)
     *
     * @return The Euclidean distance between the two points
     */
    fun calculateDistance(start: Offset, end: Offset): Float {
        return sqrt((start.x - end.x).pow(2) + (start.y - end.y).pow(2))
    }

    Canvas(
        modifier = modifier
            .width(CANVAS_WIDTH_DP.dp)
            .height(CANVAS_HEIGHT_DP.dp)
            .background(Color.Black)
    ) {
        var previousScreenX = 0f
        var previousScreenY = 0f

        for (yGrid in 24 downTo 0 ) {
            for (xGrid in 0..24) {
                val logicalDistance = calculateDistance(
                    start = Offset(xGrid.toFloat(), yGrid.toFloat()),
                    end = Offset(TARGET_X, TARGET_Y)
                )

                // Consider breaking down this calculation or adding comments
                val currentScreenX = 150 + 14 * yGrid + xGrid * 10f
                val currentScreenY = 400 - xGrid * 4 + yGrid * 4 - 180 * cos((logicalDistance / 5) / (logicalDistance + 1))

                if (xGrid > 0) { // Check against grid coordinate, not screen coordinate
                    val slope = (currentScreenY - previousScreenY) / (currentScreenX - previousScreenX)
                    var interpolatedScreenY = previousScreenY

                    var scanlineX = previousScreenX.coerceAtLeast(0f) // Ensure scanlineX is not negative
                    while (scanlineX < currentScreenX) {
                        val xPixel = scanlineX.toInt()
                        if (xPixel >= 0 && xPixel < Z_BUFFER_WIDTH) { // Boundary check
                            if (visibilityBuffer[xPixel] > interpolatedScreenY) {
                                drawPoints(
                                    points = listOf(Offset(scanlineX, interpolatedScreenY)),
                                    pointMode = PointMode.Points,
                                    color = Color.Green,
                                    strokeWidth = 1f
                                )
                                visibilityBuffer[xPixel] = interpolatedScreenY
                            }
                        }
                        scanlineX += 1f
                        // interpolatedScreenY += slope // If uncommented, be mindful of precision
                    }
                }
                previousScreenX = currentScreenX
                previousScreenY = currentScreenY
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HiddenLinePreview() {
    CopperHatTheme {
        HiddenLine()
    }
}
