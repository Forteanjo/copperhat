package sco.carlukesoftware.copperhat.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sco.carlukesoftware.copperhat.ui.theme.CopperHatTheme

@Composable
fun Circles(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .width(680.dp)
            .height(220.dp)
            .background(Color.Black)
    ) {
        for (index in 0..100 step 2) {
            val offset = Offset(
                x = index.toFloat(),
                y = 0f
            )
            drawCircle(
                color = Color.White,
                radius = 50f - index,
                center = center
                    .plus(offset),
                style = Stroke(width = 1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CirclesPreview() {
    CopperHatTheme {
        Circles()
    }
}
