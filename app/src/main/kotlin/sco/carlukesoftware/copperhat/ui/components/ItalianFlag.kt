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
fun ItalianFlag(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .width(680.dp)
            .height(220.dp)
            .background(Color.Black)
    ) {
        val cx = 128
        val cy = 16
        val dx1 = 1
        val dx2 = 1
        val dy1 = 1
        val dy2 = 1

        for (x in 120 downTo -20 step -4) {
            for (y in 100 downTo 0 step -4) {
                val color = when {
                    x < 16 -> Color.Green
                    x < 75 -> Color.Red
                    else -> Color.White
                }

                val z = 30 + ((10 * sin(x.toDouble() / 11))) * cos(y.toDouble() / 52)

                drawPoints(
                    points = listOf(
                        Offset(
                            (cx + x - y).toFloat(),
                            (cy + x + y).toFloat()
                        ),
                        Offset(
                            (cx + x + y).toFloat(),
                            (cy + (x / 2) + (y / 2 + z)).toFloat()
                        )
                    ),
                    pointMode = PointMode.Points,
                    color = color,
                    strokeWidth = 2f
                )

                if (x in 69..81 || x in 9..23) {
                    drawPoints(
                        points = listOf(
                            Offset(
                                dx1.toFloat(),
                                dy1.toFloat()
                            ),
                            Offset(
                                -dx2.toFloat(),
                                dy2.toFloat()
                            ),
                            Offset(
                                -dx1.toFloat(),
                                -dy1.toFloat()
                            ),
                            Offset(
                                dx2.toFloat(),
                                -dy2.toFloat()
                            )
                        ),
                        pointMode = PointMode.Points,
                        color = color,
                        strokeWidth = 2f
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItalianFlagPreview() {
    CopperHatTheme {
        ItalianFlag()
    }
}
